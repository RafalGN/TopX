/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.preProcessamentos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.banco.GravaReviews;
import util.banco.HandleSentiLex;
import util.preprocessamentos.LemmaTexto;

/**
 *
 * @author User
 */
public class ExtracaoFinalVarPadroes {

    private final Map<String, Integer> lexico;
    private final LemmaTexto lemmatizador;

    public ExtracaoFinalVarPadroes() {
        this.lexico = HandleSentiLex.selectLexico();
        this.lemmatizador = new LemmaTexto();
    }

    /**
     * Contar a quantidade de padrões válidos para cada lista de acordo com as
     * features passadas por parâmetro
     *
     * @param pares
     * @param hashPares
     * @param padroes
     * @param hashPadroes
     * @param features
     * @return
     */
    public List<String> contagemPadroes(List<String> pares, HashMap<String, String> hashPares, List<String> padroes, HashMap<String, String> hashPadroes, List<String> features) {
        List<String> retorno = new ArrayList<>();
        int total = 0;
        //Primeiros pares
        total = pares.size();
        for (String carac : pares) {
            boolean found = false;
            for (String feature : features) {
                if (carac.indexOf(feature) != -1) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                total--;
            }else{
                retorno.add(carac.trim()+" "+hashPares.get(carac).trim());
            }
        }

        //Padroes serão verificados agora
        total = total + padroes.size();
        for (String carac : padroes) {
            boolean found = false;
            for (String feature : features) {
                if (carac.indexOf(feature) != -1) {
                    found = true;
                    break;
                }
            }
            if (hashPadroes.get(carac).equals("padrao5")) {
                if (!lexico.keySet().contains(lemmatizador.lemmaTxt(carac).get(1))) {
                    found = false;
                }else{
                    found = true;
                }
            } else if (hashPadroes.get(carac).equals("padrao6")) {
                if (!lexico.keySet().contains(lemmatizador.lemmaTxt(carac).get(0))) {
                    found = false;
                }else{
                    found = true;
                }
            }
            if (!found) {
                total--;
            }else{
                retorno.add(carac);
            }
        }

        return retorno;
    }

    /**
     *
     * @return 
     */
    public static List<String> carregaFeatures(){
        Scanner sc = null;
        try {
            sc = new Scanner(new File("recursos/características.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExtracaoFinalVarPadroes.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<String> lista = new ArrayList<>();
        while (sc.hasNextLine()) {
            lista.add(sc.nextLine());
        }
        return lista;
    }
}
