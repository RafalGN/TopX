/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.banco;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;

/**
 *
 * @author Rogerio
 */
public class HandleSentiLex {

    public static void main(String[] args) {
        selectLexico();
    }

    public static Map<String, Integer> selectLexico() {

        HashMap<String, Integer> mapLemmas = new HashMap<String, Integer>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File("recursos/sentilex.txt"), "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] str_linha = linha.split(";");
            mapLemmas.put(str_linha[0].trim(), Integer.parseInt(str_linha[1].trim()));
        }
        return mapLemmas;
    }

    public static Map<String, Integer> selectLexicoBD() {
        ConexaoSentiLex conexao = new ConexaoSentiLex();
        Connection connection = conexao.getConnection();

        HashMap<String, Integer> mapLemmas = new HashMap<String, Integer>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select lemma, polaridade from lemmas");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mapLemmas.put(rs.getString(1), rs.getInt(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HandleSentiLex.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return mapLemmas;
    }
}
