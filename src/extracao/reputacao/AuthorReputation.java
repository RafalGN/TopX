/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extracao.reputacao;

import core.model.Review;
import java.util.List;
import java.util.Map;
import util.banco.BancoAutores;
import util.banco.GravaReviews;

/**
 *
 * @author Rogerio
 */
public class AuthorReputation {

    Map<String, Integer> autores;
    
    public AuthorReputation() {
        this.autores = BancoAutores.selectAllAuthors();
    }
    
    
    public static void main(String[] args) {
        List<Review> listaReviews = GravaReviews.selectCommentsImportanciaManual();
        AuthorReputation ar = new AuthorReputation();
//        Map<String, Integer> autores = BancoAutores.selectAllAuthors();
        
        for(Review r : listaReviews){
            System.out.println(r.getId() + "\t" + r.getAvaliacao_conceitual() + "\t" + ar.getQuantPostsAutores(r.getAutor()));
        }
//        System.out.println("");
    }
    
    /**
     * 
     * @param autor
     * @return 
     */
    public int getQuantPostsAutores(String autor){
        if(autor.equalsIgnoreCase("e-bit")){
            return 1;
        }else if(autores.containsKey(autor)){
            return autores.get(autor);
        }else{
            return 1;
        }
    }
}
