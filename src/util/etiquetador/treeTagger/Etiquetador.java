package util.etiquetador.treeTagger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.annolab.tt4j.TokenHandler;
import org.annolab.tt4j.TreeTaggerException;
import org.annolab.tt4j.TreeTaggerWrapper;


public class Etiquetador {

    private List<String> etiquetas = new ArrayList<String>();
    private List<String> palavras = new ArrayList<String>();
    private TreeTaggerWrapper<String> tt;
    public static HashMap<String, String> lemma = new HashMap<String, String>();
    private HashMap<String,String> lemmas = new HashMap<String, String>();

    public Etiquetador(List<String> palavras) {
        Etiquetador.lemma.clear();
        this.palavras = palavras;
    }

    public void etiquetar() {
        System.setProperty("treetagger.home", "./TreeTagger");

        tt = new TreeTaggerWrapper<String>();
        try {
            tt.setModel("./TreeTagger/lib/pt.par:UTF8");
            tt.setHandler(new TokenHandler<String>() {
                @Override
                public void token(String token, String pos, String lemma) {
                    if (token.equals("_")) {
                        pos = "Fz";
                    } else if (lemma.equals("celular")) {
                        pos = "NCMS";
                    } else if(lemma.equals("perfeito")){
                        pos = "AQ0";
                    }
                        
                    
                    etiquetas.add(pos);
                    //    System.out.println(token+"-> "+pos);
                    Etiquetador.lemma.put(token, lemma);
                }
            });
            tt.process(palavras);
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Model não encontrado");
        } catch (TreeTaggerException t) {
            //System.out.println(t.getMessage());
        } finally {
            tt.destroy();
        }
    }
    
     

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public static String getLemma(String palavra) {
        return lemma.get(palavra);
    }
    
    public HashMap<String, String> getLemmas(){
        lemmas.putAll(lemma);
        return lemmas;
    }

    public List<String> getPalavras() {
        return palavras;
    }
}