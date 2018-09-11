/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.banco;

import core.model.Author;
import core.model.Review;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class BancoAutores {

    public static void gravaAutores(HashSet<Author> dadosAutores) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("insert into autores values (null,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            for (Author autor : dadosAutores) {
                ps.setString(1, autor.getShortName());
                ps.setString(2, autor.getFullName());
                ps.setLong(3, Long.parseLong(autor.getUid()));
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                int id = 0;
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                gravaReviewsAutor(autor.getComentarios(), id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoAutores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void gravaReviewsAutor(List<Review> comentarios, int id) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("insert into comments_author values (null,?,?,?,?,?);");
            for(Review r : comentarios){
                ps.setString(1, r.getComentario());
                ps.setDouble(2, r.getEstrelas());
                ps.setDate(3, new Date(r.getData().getTime()));
                ps.setInt(4, r.getAvaliacaoManual());
                ps.setInt(5, id);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoAutores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     */
    public static Map<String, Integer> selectAllAuthors(){
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        
        HashMap<String, Integer> autores = new HashMap<String, Integer>();
        
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select aut.short_name, count(com.id) from comentarios.autores as aut, comentarios.comments_author as com where aut.idautores = com.idauthor group by com.idauthor");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String shortName = rs.getString(1);
                int total = rs.getInt(2);
                if(autores.containsKey(shortName)){
                    if(autores.get(shortName) < total){
                        autores.put(shortName, total);
                    }
                }else{
                    autores.put(shortName, total);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoAutores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return autores;
    }
}
