/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.fuzzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import util.arquivos.UtilsArquivo;

/**
 *
 * @author Rogerio
 */
public class TesteFuzzy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String resultado = "";
        List<InputFuzzy> manual = CalculaImportancia.getInputs();
        for (InputFuzzy input : manual) {
            CalculaImportancia ts = new CalculaImportancia();
//            System.out.print(input);
            resultado += ts.executa(input,false);
        }

        UtilsArquivo.salva("./resultados/geral.txt", resultado);
        avaliacoes(manual, resultado);


//        System.out.println(resultado);
    }

    public static void avaliacoes(List<InputFuzzy> manual, String resultadoFuzzy) {
        List<String> resultado = Arrays.asList(resultadoFuzzy.split("\n"));
        HashMap<Integer, InputFuzzy> resultadoInputFuzz = new HashMap<>();
        HashMap<Integer, InputFuzzy> avalManual = new HashMap<>();
        List<Integer> idsManualPositivos = new ArrayList<>();
        List<Integer> idsManualNegativos = new ArrayList<>();
        List<Integer> idsFuzzyPositivos = new ArrayList<>();
        List<Integer> idsFuzzyNegativos = new ArrayList<>();

        for (String r : resultado) {
            String[] rsplit = r.split("\t");
            InputFuzzy ifuzz = new InputFuzzy();
            ifuzz.setId_review(Integer.parseInt(rsplit[0]));
            ifuzz.setAvaliacaoManual(rsplit[1]);
            ifuzz.setValorFuzzy(Double.parseDouble(rsplit[2]));
            resultadoInputFuzz.put(ifuzz.getId_review(), ifuzz);
            if(ifuzz.getId_review()>=1000){
                idsFuzzyNegativos.add(ifuzz.getId_review());
            }else{
                idsFuzzyPositivos.add(ifuzz.getId_review());
            }
        }

        for (InputFuzzy ipf : manual) {
            avalManual.put(ipf.getId_review(), ipf);
            if(ipf.getId_review() >= 1000){
                idsManualNegativos.add(ipf.getId_review());
            }else{
                idsManualPositivos.add(ipf.getId_review());
            }
            
        }

        ordena(idsManualPositivos, avalManual);
        ordena(idsManualNegativos, avalManual);
        
        ordena(idsFuzzyPositivos, resultadoInputFuzz);
        ordena(idsFuzzyNegativos, resultadoInputFuzz);
        
        int total = getTotalImportancia(idsFuzzyPositivos, resultadoInputFuzz, Arrays.asList("PL"));
        int k = 0;
        //8 positivos
        List<Integer> ids = idsFuzzyPositivos.subList(0, total);
        for(int i = 0; i< 8;i++){
            if(ids.contains(idsManualPositivos.get(i))){
                k++;
            }else{
//                System.out.println(idsManualPositivos.get(i) + "\t valor fuzz: " + resultadoInputFuzz.get(idsManualPositivos.get(i)).getValorFuzzy());
            }
        }
      System.out.println(total + " Positivos: " + k);
        
        // 7 negativos
        total = getTotalImportancia(idsFuzzyNegativos, resultadoInputFuzz, Arrays.asList("PL"));
        k = 0;
        for(int i = 0; i<7;i++){
            if(idsFuzzyNegativos.subList(0, total).contains(idsManualNegativos.get(i))){
                k++;
            }else{
//                System.out.println(idsManualNegativos.get(i)  + "\t valor fuzz" + resultadoInputFuzz.get(idsManualPositivos.get(i)).getValorFuzzy());
            }
        }
        
        System.out.println(total + " Negativos: " + k);
        
        //54 positivos
        total = getTotalImportancia(idsFuzzyPositivos, resultadoInputFuzz, Arrays.asList("PL","BM"));
        k = 0;
        for(int i = 0; i<54;i++){
            if(idsFuzzyPositivos.subList(0, total).contains(idsManualPositivos.get(i))){
                k++;
            }else{
//                System.out.println(idsManualPositivos.get(i) + "\t valor fuzz" + resultadoInputFuzz.get(idsManualPositivos.get(i)).getValorFuzzy());
            }
        }
        System.out.println(total + " Positivos: " + k);
        
        // 56 Negativos
        total = getTotalImportancia(idsFuzzyNegativos, resultadoInputFuzz, Arrays.asList("PL","BM"));
        k = 0;
        for(int i = 0; i<56;i++){
            if(idsFuzzyNegativos.subList(0, total).contains(idsManualNegativos.get(i))){
                k++;
            }else{
//                System.out.println(idsManualNegativos.get(i) + "\t valor fuzz" + resultadoInputFuzz.get(idsManualNegativos.get(i)).getValorFuzzy());
            }
        }
        System.out.println(total + " Negativos: " + k);
//        System.out.println(idsManualNegativos.size());
    }

    private static List<Integer> ordena(List<Integer> ids, final HashMap<Integer, InputFuzzy> mapInputs) {
        Collections.sort(ids, new Comparator<Integer>() {
            @Override
            public int compare(Integer id1, Integer id2) {
                if(mapInputs.get(id1).getAvaliacaoManual().equals("PL")){
                    if(mapInputs.get(id2).getAvaliacaoManual().equals("PL")){
                        return 0;
                    }else{
                        return -1;
                    }
                } else if(mapInputs.get(id1).getAvaliacaoManual().equals("BM")){
                    if(mapInputs.get(id2).getAvaliacaoManual().equals("PL")){
                        return 1;
                    } else if(mapInputs.get(id2).getAvaliacaoManual().equals("BM")){
                        return 0;
                    } else{
                        return -1;
                    }
                } else if(mapInputs.get(id1).getAvaliacaoManual().equals("SF")){
                    if(mapInputs.get(id2).getAvaliacaoManual().equals("SF")){
                        return 0;
                    } else if(mapInputs.get(id2).getAvaliacaoManual().equals("IF")){
                        return -1;
                    } else{
                        return 1;
                    }
                }else{
                    if(mapInputs.get(id2).getAvaliacaoManual().equals("IF")){
                        return 0;
                    }else{
                        return 1;
                    }
                }
            }
        });
        return ids;
    }
    
    public static int getTotalImportancia(List<Integer> lista, HashMap<Integer, InputFuzzy> mapInputs, List<String> importancia){
        int total = 0;
        for(Integer value : lista){
            if(importancia.contains(mapInputs.get(value).getAvaliacaoManual())){
                total++;
            }
        }
        return total;
    }
}
