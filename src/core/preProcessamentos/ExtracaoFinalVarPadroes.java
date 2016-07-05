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
import util.banco.GravaReviews;
import util.banco.GravaSentiLex;
import util.preprocessamentos.LemmaTexto;

/**
 *
 * @author User
 */
public class ExtracaoFinalVarPadroes {

    private final Map<String, Integer> lexico;
    private final LemmaTexto lemmatizador;

    public ExtracaoFinalVarPadroes() {
        this.lexico = GravaSentiLex.selectLexico();
        this.lemmatizador = new LemmaTexto();
    }

    public static void main(String args[]) throws FileNotFoundException {
//        Map<Integer, List<String>> mapPares = GravaReviews.selectPares();
//        Map<Integer, List<String>> mapPadroes = GravaReviews.selectPadroesNew();
//        List<String> features = carregaFeatures();
//
//        for (int i = 1; i <= 2000; i++) {
//            int total = 0;
//            i = 22;
//            //Primeiros pares
//            if (mapPares.containsKey(i)) {
//                total = mapPares.get(i).size();
//                for (String carac : mapPares.get(i)) {
//                    boolean found = false;
//                    for (String feature : features) {
//                        if (carac.indexOf(feature) != -1) {
//                            found = true;
//                            break;
//                        }
//                    }
//                    if (!found) {
//                        total--;
//                    }
//                }
////                System.out.println(i + "\t" + total);
//            }
//
//            //Padroes serão verificados agora
//            if (mapPadroes.containsKey(i)) {
//                total = total + mapPadroes.get(i).size();
//                for (String carac : mapPadroes.get(i)) {
//                    boolean found = false;
//                    for (String feature : features) {
//                        if (carac.indexOf(feature) != -1) {
//                            found = true;
//                            break;
//                        }
//                    }
//                    if (!found) {
//                        total--;
//                    }
//                }
//            }
//
//            System.out.println(i + "\t" + total);
//        }
    }

    /**
     * Contar a quantidade de padrões válidos para cada lista de acordo com as
     * features passadas por parâmetro
     *
     * @param pares
     * @param padroes
     * @param features
     * @return
     */
    public int contagemPadroes(List<String> pares, List<String> padroes, List<String> features) {

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
            if (!found) {
                total--;
            }
        }

        return total;
    }

    /**
     * Contar a quantidade de padrões válidos para cada lista de acordo com as
     * features passadas por parâmetro
     *
     * @param pares
     * @param padroes
     * @param features
     * @return
     */
    public List<String> contagemPadroesNovo(List<String> pares, HashMap<String, String> hashPares, List<String> padroes, HashMap<String, String> hashPadroes, List<String> features) {
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
     * @return @throws FileNotFoundException
     */
    public static List<String> carregaFeatures() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("características.txt"));
        List<String> lista = new ArrayList<>();
        while (sc.hasNextLine()) {
            lista.add(sc.nextLine());
        }
        return lista;
    }
}
