/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extracao.corretude;

import gramaticas.sintagmatica.GramaticaSintagmaticaLexer;
import gramaticas.sintagmatica.GramaticaSintagmaticaParser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author User
 */
public class CorretudeCalculator {
    
    Set<String> dictionary;
    
    public CorretudeCalculator() {
         this.dictionary = new HashSet<String>();
        // read in dictionary of words
        Scanner sc = null;
        try {
            sc = new Scanner(new File("Jortho/UserDictionary_pt.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CorretudeCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (sc.hasNext()) {
            String word = sc.nextLine();
            dictionary.add(word);
        }
        
        System.out.println("Done reading dictionary");
    }

    
    public float calculaCorretude(String texto) throws FileNotFoundException{

        ANTLRInputStream input = new ANTLRInputStream(texto.toLowerCase());

        //Criação do Lexer
        GramaticaSintagmaticaLexer lexer = new GramaticaSintagmaticaLexer(input);
        //Leitura dos Tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //Criação dos Tokens
        GramaticaSintagmaticaParser parser = new GramaticaSintagmaticaParser(tokens);

        //Por algum motivo os tokens somente são criados se a sua leitura 
        // for obrigada de alguma forma
        tokens.fill();
        float corretos = 0;
        List<Token> allTokens = tokens.getTokens(0, tokens.size() - 1, GramaticaSintagmaticaParser.PALAVRA);
        try {
            for (Token tk : allTokens) {
                if (dictionary.contains(tk.getText().toLowerCase())) {
                    corretos++;
                }
            }
            return (corretos / allTokens.size()) * 100;
        } catch (NullPointerException npe) {
//            npe.printStackTrace();
        }
        
        return 0;
    }
}
