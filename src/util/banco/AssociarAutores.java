/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.banco;

import core.model.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rogerio
 */
public class AssociarAutores {

    public static void main(String[] args) {
        List<Integer> usados = new ArrayList<>();
        List<Review> comments = selectComments();
        for (Review r : comments) {
            Map<Integer, String> mapa = getAuthorsByComment(r.getComentario());
            if (mapa.size() > 1) {
                List<Integer> ids = new ArrayList<>(mapa.keySet());
                Collections.sort(ids);
                for (Integer id : ids) {
                    if (!usados.contains(id)) {
                        r.setAutor(mapa.get(id));
                        usados.add(id);
                        break;
                    }
                }
            } else {
                for(Integer id: mapa.keySet()){
                    r.setAutor(mapa.get(id));
                    usados.add(id);
                }
            }
        }
        for(Review r : comments){
            if(r.getAutor() == null){
                System.out.println(r.getId());
            }
        }
            
        insereNovosReviews(comments);
    }

    public static List<Review> selectComments() {
        ConexaoCorpusBuscape conexao = new ConexaoCorpusBuscape();
        Connection connection = conexao.getConnection();

        List<Review> comments = new ArrayList<Review>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT id, op, pos, neg FROM tblavalalunos \n");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Review r = new Review();
                r.setId(rs.getInt(1));
                r.setComentario(rs.getString(2));
                r.setPos(rs.getInt(3));
                r.setNeg(rs.getInt(4));
                comments.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return comments;
    }

    /**
     *
     * @return
     */
    public static Map<Integer, String> getAuthorsByComment(String comment) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();

        Map<Integer, String> authors = new HashMap<Integer, String>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select id, autor from reviews where comentario like ?");
            ps.setString(1, comment);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                authors.put(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssociarAutores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authors;
    }
    
    public static void insereNovosReviews(List<Review> lista){
        ConexaoCorpusBuscape conexao = new ConexaoCorpusBuscape();
        Connection connection = conexao.getConnection();
        
        for (Review rev : lista) {
            //tblavalalunosautor
            PreparedStatement ps;
            try {
                ps = connection.prepareStatement("insert into tblavalalunosautor values (?,?,?,?,?);");
                ps.setInt(1, rev.getId());
                ps.setString(2, rev.getComentario());
                ps.setInt(3, rev.getPos());
                ps.setInt(4, rev.getNeg());
                ps.setString(5, rev.getAutor());
                
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AssociarAutores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
