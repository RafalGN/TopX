package extracao.htmlParser.buscape;

import core.model.Review;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.banco.GravaReviews;

/**
 *
 */
/**
 * @author Rogerio
 *
 */
public class BuscapeExtractor {

    public static void main(String[] args) throws IOException, ParseException {
//        GravaReviews.executa(getPositivas());
//        GravaReviews.executa(getNegativas());
//        grava(getPositivas(), "Positivas");
        //   grava(getNegativas(), "Negativas");
    }

    public static List<Review> getPositivas() throws IOException, ParseException {
        List<Review> opinioesPositivas = new ArrayList<Review>();
        HashMap<String, String> produto = new HashMap();
        produto.put("http://www.buscape.com.br/avaliacao-positiva-sobre--smartphone-samsung-galaxy-s-iii-gt-i9300-desbloqueado--pg-68.html", "samsumg_galaxy_s_iii_gt_9300");

        while (opinioesPositivas.size() < 1000) {
            String link = produto.keySet().iterator().next();
            if (!link.isEmpty()) {

                String nomeProduto = produto.get(link).replaceAll("-", "_");

                Document doc = Jsoup.connect(link).timeout(6000).get();

//                System.out.println(doc);
                //Elements elems = doc.getElementsByClass("opinion");
                Elements elems = doc.getElementsByTag("article");

                for (Element el : elems) {
                    if (!el.getElementsByClass("user-opinion").isEmpty()) {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                        Review rev = new Review();
                        //add comentario
                        rev.setComentario(el.getElementsByClass("opinion").first().getElementsByClass("descr").first().text());

                        //add data
                        Date data = format.parse(el.getElementsByClass("opinion").first().getElementsByClass("date").first().text().substring(13, 23));
                        rev.setData(data);

                        //add autor
                        rev.setAutor(el.getElementsByClass("user-opinion").first().getElementsByClass("name").first().text());

                        //add estrelas
                        rev.setEstrelas(el.getElementsByClass("opinion").first().getElementsByClass("starfull").size());

                        //add avaliacaoDominio
//                        rev.setAvaliacaoDominio(true);

                        //add dominio
                        rev.setDominio("buscape");

                         //add produto
                        rev.setProduto(nomeProduto);
                        
                        //add UtilUp
//                        rev.setUtilUp(Integer.valueOf( el.getElementsByClass("opinion").first().getElementsByClass("pros").first().text()));

                        //add UtilUp
//                        rev.setUtilUp(Integer.valueOf( el.getElementsByClass("opinion").first().getElementsByClass("contras").first().text()));

                        //replicando coleta antiga

                        Date dataRef = format.parse("03/10/2013");
                        if (rev.getData().compareTo(dataRef) <= 0) {
                            opinioesPositivas.add(rev);
                            System.out.println(rev.getData());
                        }
//                        System.out.println(el.text());
                    }
                }

                produto = novoMap(doc.getElementsByClass("bp-pagination").get(0)
                        .getElementsByClass("next").get(0)
                        .getElementsByTag("a").attr("href"),nomeProduto);
//                System.out.println(doc.getElementsByClass("bp-pagination")
//                        .get(0).getElementsByClass("next").get(0)
//                        .getElementsByTag("a").attr("href"));
            } else {
                break;
            }
        }
        return opinioesPositivas;
    }

    private static List<Review> getNegativas() throws IOException, ParseException {
        List<Review> opinioesNegativas = new ArrayList<Review>();

        HashMap<String, String> produto = new HashMap();
        produto.put("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-s-iii-gt-i9300-desbloqueado.html", "samsumg_galaxy_s_iii_gt_9300");

        List<HashMap<String, String>> links = new ArrayList<HashMap<String, String>>();
//		links.add(produto);
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-s-duos-gt-s7562-desbloqueado.html", "samsung_galaxy_s_duos_gt_s7562"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-s-iii-mini-gt-i8190-desbloqueado.html", "samsung_galaxy_s_iii_mini_gt_i8190"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-grand-duos-gt-i9082l-desbloqueado.html", "samsung_galaxy_grand_duos_gt_i9082l"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-apple-iphone-5-16gb-desbloqueado.html", "apple-iphone-5-16gb"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-apple-iphone-4s-16gb-desbloqueado.html", "apple-iphone-4s-16gb"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-s-ii-gt-i9100-desbloqueado.html", "samsung-galaxy-s-ii-gt-i9100"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-motorola-razr-i-xt890-desbloqueado.html", "motorola-razr-i-xt890"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-apple-iphone-4-8gb-desbloqueado.html", "apple-iphone-4-8gb"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-motorola-razr-d3-xt920-desbloqueado.html", "motorola-razr-d3-xt920"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-ace-duos-gt-s6802-desbloqueado.html", "samsung-galaxy-ace-duos-gt-s6802"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-note-ii-n7100-desbloqueado.html", "samsung-galaxy-note-ii-n7100"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-y-duos-gt-s6102-desbloqueado.html", "samsung-galaxy-y-duos-gt-s6102"));
        //links.add("http://compare.buscape.com.br/smartphone-samsung-galaxy-s4-gt-i9500-desbloqueado.html#avaliacoes");
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-s4-gt-i9500-desbloqueado.html", "samsung-galaxy-s4-gt-i9500"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-y-gt-s5360-desbloqueado.html", "samsung-galaxy-y-gt-s5360"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-ace-gt-s5830-desbloqueado.html", "samsung-galaxy-ace-gt-s5830"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--celular-motorola-ex115-desbloqueado.html", "motorola-ex115"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-lg-optimus-net-dual-p698-desbloqueado.html", "lg-optimus-net-dual-p698"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-5-gt-i5500-desbloqueado.html", "samsung-galaxy-5-gt-i5500"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--celular-nokia-c3-desbloqueado.html", "nokia-c3"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--celular-motorola-v3-desbloqueado.html", "motorola-v3"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-apple-iphone-3gs-8gb-desbloqueado.html", "apple-iphone-3gs-8gb"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-motorola-spice-xt300-desbloqueado.html", "motorola-spice-xt300"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-samsung-galaxy-551-gt-i5510-desbloqueado.html", "samsung-galaxy-551-gt-i5510"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--nokia-c5-03-gsm-desbloqueado.html", "nokia-c5-03-gsm"));
        links.add(novoMap("http://www.buscape.com.br/avaliacao-negativa-sobre--smartphone-apple-iphone-4-16gb-desbloqueado.html", "apple-iphone-4-16gb"));

        int i = 0;
        while (opinioesNegativas.size() < 1000) {
            String link = produto.keySet().iterator().next();
            if (!link.isEmpty()) {
                
                String nomeProduto = produto.get(link).replaceAll("-", "_");

                Document doc = Jsoup.connect(link).timeout(6000).get();

//                System.out.println(doc);
                Elements elems = doc.getElementsByTag("article");
                for (Element el : elems) {
                    if (!el.getElementsByClass("user-opinion").isEmpty()) {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        Review rev = new Review();
                        //add comentario
                        rev.setComentario(el.getElementsByClass("opinion").first().getElementsByClass("descr").first().text());

                        //add data
                        Date data = format.parse(el.getElementsByClass("opinion").first().getElementsByClass("date").first().text().substring(13, 23));
                        rev.setData(data);

                        //add autor
                        rev.setAutor(el.getElementsByClass("user-opinion").first().getElementsByClass("name").first().text());

                        //add estrelas
                        rev.setEstrelas(el.getElementsByClass("opinion").first().getElementsByClass("starfull").size());

                        //add avaliacaoDominio
//                        rev.setAvaliacaoDominio(false);

                        //add dominio
                        rev.setDominio("buscape");

                        //add produto
                        rev.setProduto(nomeProduto);

                        //add UtilUp
//                        rev.setUtilUp(Integer.valueOf( el.getElementsByClass("opinion").first().getElementsByClass("pros").first().text()));

                        //add UtilUp
//                        rev.setUtilUp(Integer.valueOf( el.getElementsByClass("opinion").first().getElementsByClass("contras").first().text()));

                        //replicando coleta antiga
                        Date dataRef = format.parse("03/10/2013");
                        if (rev.getData().compareTo(dataRef) <= 0) {
//                            if(lista.contains(rev.getComentario())){
                            opinioesNegativas.add(rev);
//                                System.out.println(rev.getData()+ " -> " + produto);
//                                System.out.println(rev.getComentario());
//                            }
                        }
//                        System.out.println(el.text());
                    }
                }

                produto = novoMap(doc.getElementsByClass("bp-pagination").get(0)
                        .getElementsByClass("next").get(0)
                        .getElementsByTag("a").attr("href"), nomeProduto);
//                System.out.println(doc.getElementsByClass("bp-pagination")
//                        .get(0).getElementsByClass("next").get(0)
//                        .getElementsByTag("a").attr("href"));
            } else {
                produto = links.get(i++);
            }
        }
        return opinioesNegativas;
    }

    public static void grava(List<Review> opinioes, String tipo) throws IOException {
        File arquivo;

        arquivo = new File("opinioes" + tipo + ".txt");
        FileOutputStream fos = new FileOutputStream(arquivo);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        for (Review op : opinioes) {
            bos.write(op.getComentario().getBytes());
            bos.write("\r\n".getBytes());
        }
        bos.flush();
        bos.close();
    }

    public static List<String> le(String arquivo) throws FileNotFoundException {
        List<String> lista = new ArrayList<String>();
        Scanner sc = new Scanner(new File(arquivo));

        while (sc.hasNext()) {
            lista.add(sc.nextLine());
        }
        return lista;
    }

    public static HashMap<String, String> novoMap(String link, String produto) {
        HashMap<String, String> retorno = new HashMap<String, String>();
        retorno.put(link, produto);
        return retorno;
    }
}
