/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.preprocessamentos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.etiquetador.treeTagger.Etiquetador;

/**
 *
 * @author User
 */
public class LemmaTexto {
    /**
     *
     * @param texto
     * @return
     */
    public List<String> lemmaTxt(String texto){
        ArrayList<String> retorno = new ArrayList<>();
        ArrayList<String> textoList = new ArrayList<>(Arrays.asList(texto.split(" ")));
        
        Etiquetador tagger = new Etiquetador(textoList);
        
        tagger.etiquetar();
        retorno.addAll(tagger.getLemmas().values());
        
        return retorno;
    }
}
