/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.fuzzy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class uselessARFF {
    
    public static void main(String[] args) throws FileNotFoundException {
        List<InputFuzzy> ipf = getInputs();
        System.out.println(InputFuzzy.toARFF(ipf));
    }
    
     public static List<InputFuzzy> getInputs() throws FileNotFoundException {
        ArrayList<InputFuzzy> retorno = new ArrayList<InputFuzzy>();
        Scanner sc = new Scanner(new File("dadosParesARFF.txt"));
        while (sc.hasNext()) {
            retorno.add(new InputFuzzy(sc.nextLine()));
        }
        return retorno;
    }
}
