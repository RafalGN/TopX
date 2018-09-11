/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extracao.htmlParser.buscape;

import core.model.Author;
import core.model.Review;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.arquivos.UtilsArquivo;
import util.banco.BancoAutores;

/**
 *
 * @author Rogerio
 */
public class AuthorExtractor {

    private SimpleDateFormat format;
    private List<String> linksProdutos;
    private int linkAtual;

    public AuthorExtractor() {
        format = new SimpleDateFormat("dd/MM/yyyy");
        linksProdutos = carregaLinks();
        try {
            UtilsArquivo.salva("counter.txt", 0 + "");
        } catch (IOException ex) {
            Logger.getLogger(AuthorExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner sc = null;
        try {
            sc = new Scanner(new File("counter.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AuthorExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        linkAtual = Integer.parseInt(sc.nextLine().trim());
    }

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        AuthorExtractor extractor = new AuthorExtractor();
        HashSet<Author> conjuntoAutores = new HashSet<Author>();
        String atual = extractor.nextPage(null, conjuntoAutores);
        while (atual != null) {

            Document doc = extractor.retornaDoc(atual);

            System.out.println(atual);
            Map<String, Element> avatares = extractor.getAllAvatars(doc);
            for (String name : avatares.keySet()) {
                Author aut = extractor.extraiInfoAutor(name, avatares.get(name));
                if (aut != null) {
                    conjuntoAutores.add(aut);
                }
            }
            atual = extractor.nextPage(doc, conjuntoAutores);
        }

        BancoAutores.gravaAutores(conjuntoAutores);

        System.out.println(conjuntoAutores.size());

    }

    /**
     * Extrair os avatares dos autores de uma página
     *
     * @param doc
     * @return lista dos elementos que possuíam link
     */
    public Map<String, Element> getAllAvatars(Document doc) {
        Map<String, Element> avatares = new HashMap<String, Element>();

        Elements userOpinion = doc.getElementsByClass("user-opinion");


        for (Element usrOp : userOpinion) {
            Element avatar = usrOp.getElementsByClass("avatar").first();
            if (avatar.hasAttr("href")) {
                Element shortName = usrOp.getElementsByClass("name").first();
                avatares.put(shortName.text(), avatar);
            }
        }
        return avatares;
    }

    /**
     *
     * @param name
     * @param authorElement
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public Author extraiInfoAutor(String name, Element authorElement) throws ParseException {

        String uid = authorElement.attr("href").substring(authorElement.attr("href").lastIndexOf("uid=") + 4);
        String alt = authorElement.getElementsByTag("img").first().attr("alt");
        Author author = null;
        try {
            author = new Author(uid, name, alt, extraiReviewsProdutos(authorElement.attr("href")));
        } catch (NullPointerException e) {
            return null;
        }
        
        return author;

    }

    /**
     *
     * @param link
     * @return
     * @throws IOException
     */
    public List<Review> extraiReviewsProdutos(String link) throws ParseException, NullPointerException {
        List<Review> listaReviews = new ArrayList<>();

        Document doc = retornaDoc(link);

        Element listaProdutos = null;
        listaProdutos = doc.getElementsByClass("product").first();

        Document opProdutos = retornaDoc("http://www.buscape.com.br/" + listaProdutos.attr("href"));

        Elements opinioes = opProdutos.getElementsByClass("wrapper_opinion");
        for (Element op : opinioes) {
            Review e = geraReview(op);
            if (e != null) {
                listaReviews.add(e);
            }
        }
        return listaReviews;
    }

    /**
     *
     * @param wrapperOpiniao
     * @return
     */
    private Review geraReview(Element wrapperOpiniao) throws ParseException, NullPointerException {
        Review review = new Review();
        review.setComentario(wrapperOpiniao.getElementsByClass("description").text());
//        System.out.println(review.getComentario());

        try {
            review.setData(format.parse(wrapperOpiniao.getElementsByClass("date").get(0).text()));
        } catch (ParseException pe) {
            review.setData(format.parse(wrapperOpiniao.getElementsByClass("date").get(1).text()));
        } catch (IndexOutOfBoundsException offBounds) {
            return null;
        }

//        System.out.println(review.getData());
        review.setEstrelas(wrapperOpiniao.getElementsByClass("starfull").size());
//        System.out.println(review.getEstrelas());
        if (wrapperOpiniao.getElementsByClass("not-recommend").isEmpty()) {
            review.setAvaliacaoManual(1);
        } else {
            review.setAvaliacaoManual(0);
        }
//        System.out.println(review.getAvaliacaoManual());

        return review;
    }

    /**
     *
     * @param atual
     * @return
     */
    private String nextPage(Document atual, HashSet<Author> conjuntoAutores) {
        if (atual != null) {
            String href = atual.getElementsByAttributeValueContaining("title", "Próxima").attr("href");
            if (href.isEmpty()) {
                if (this.linksProdutos.size() == linkAtual + 1) {
                    return null;
                } else {
                    linkAtual++;
                    href = this.linksProdutos.get(linkAtual);
                    try {
                        BancoAutores.gravaAutores(conjuntoAutores);
                        conjuntoAutores.clear();
                        UtilsArquivo.salva("counter.txt", linkAtual + "");
                    } catch (IOException ex) {
                        Logger.getLogger(AuthorExtractor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

//                return href;
            }
            return href;

        } else {
            return this.linksProdutos.get(this.linkAtual);
        }

    }

    private List<String> carregaLinks() {
        List<String> links = new ArrayList<>();
        try {
            Scanner scn = new Scanner(new File("./recursos/Links.txt"));
            while (scn.hasNextLine()) {
                links.add(scn.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AuthorExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return links;
    }

    /**
     *
     * @param link
     * @return
     */
    private Document retornaDoc(String link) {
        Document doc = null;

        try {
            doc = Jsoup.connect(link).timeout(6000).get();
        } catch (IOException ex) {
            boolean pass = false;
            while (pass) {
                try {
                    doc = Jsoup.connect(link).timeout(6000).get();
                    pass = true;
                } catch (IOException ex1) {
                    System.out.println("Erro: " + link);
                    continue;
                }
            }
        }

        return doc;
    }
}
