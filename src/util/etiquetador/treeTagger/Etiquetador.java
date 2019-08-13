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
        System.setProperty("treetagger.home", "TreeTagger");
        this.tt = new TreeTaggerWrapper<String>();
        try {
            this.tt.setModel("TreeTagger/lib/pt.par:UTF8");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("MModel não encontrado");
        }
        
        this.palavras = palavras;
    }

    public void etiquetar() {
        //System.setProperty("treetagger.home", "TreeTagger");

        //tt = new TreeTaggerWrapper<String>();
        try {
            //tt.setModel("TreeTagger/lib/pt.par:UTF8");
            this.tt.setHandler(new TokenHandler<String>() {
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
            this.tt.process(palavras);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("O executável referente ao TreeTagger [Treetagger/bin/treetagger] deve ter permissões de execução. (chmod +x treetagger)");
        } catch (TreeTaggerException t) {
            //System.out.println(t.getMessage());
        } finally {
            this.tt.destroy();
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