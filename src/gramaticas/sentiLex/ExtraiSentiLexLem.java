/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gramaticas.sentiLex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import util.banco.GravaSentiLex;

/**
 *
 * @author Rogerio
 */
public class ExtraiSentiLexLem {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner sc = new Scanner(new File(".\\src\\gramaticas\\sentiLex\\SentiLex-lem-PT02.txt"));
        List<ObjetoSentiLex> lista = new ArrayList<ObjetoSentiLex>();
        
        while(sc.hasNextLine()){
            String palavra, classe, polaridade;
            String linha = sc.nextLine();
            String[] partes = linha.split(";");
            //Parte 1
            String[] splitPT1 = partes[0].split("\\.");
            palavra = splitPT1[0];
            classe = splitPT1[1].split("=")[1];
            polaridade = partes[2].split("=")[1];
            
            lista.add(new ObjetoSentiLex(palavra, classe, Integer.parseInt(polaridade)));
//            System.out.println(palavra + " : "+ classe + " : " + polaridade);
        }
        GravaSentiLex.gravaPalavras(lista);
    }
}
