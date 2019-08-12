/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.banco;

import core.model.Review;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rogerio
 */
public class GravaReviews {

    /**
     *
     * @return
     */
    public static Map<Integer, String> selectComments() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();

        HashMap<Integer, String> mapReviews = new HashMap<Integer, String>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select id, comentario from reviews");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mapReviews.put(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return mapReviews;
    }

     /**
     * Retornar somente os comentários avaliados manualmente pelo 
     * revisor de importância.
     * 
     * @return
     */
    public static List<Review> selectCommentsImportanciaManual() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();

        List<Review> listReviews = new ArrayList<Review>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT id, comentario, autor, avaliacao_conceitual FROM reviews where avaliacao_conceitual is not null");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Review r = new Review();
                r.setId(rs.getInt(1));
                r.setComentario(rs.getString(2));
                r.setAutor(rs.getString(3));
                r.setAvaliacao_conceitual(rs.getString(4));
                listReviews.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return listReviews;
    }
    
    /**
     *
     * @return
     */
    public static List<Review> selectReviews() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();

        List<Review> reviews = new ArrayList<Review>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select id, comentario, avaliacao_dominio from reviews");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Review r = new Review(rs.getInt(1), rs.getString(2), rs.getInt(3));
                reviews.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return reviews;
    }

    /**
     *
     * @return
     */
    public static Map<Integer, List<String>> selectPares() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();

        HashMap<Integer, List<String>> mapPares = new HashMap<Integer, List<String>>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select id, caracteristica, qualificador, idreview from pares");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (mapPares.containsKey(rs.getInt(4))) {
                    mapPares.get(rs.getInt(4)).add(rs.getString(2));
                } else {
                    ArrayList<String> carac = new ArrayList<>();
                    carac.add(rs.getString(2));
                    mapPares.put(rs.getInt(4), carac);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return mapPares;
    }

    /**
     * Retornar os padroes existentes no banco de dados
     *
     * @return
     */
    public static Map<Integer, List<String>> selectPadroesNew() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();

        HashMap<Integer, List<String>> mapPadroes = new HashMap<Integer, List<String>>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select id, palavras, idreviews from padroesnew");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (mapPadroes.containsKey(rs.getInt(3))) {
                    mapPadroes.get(rs.getInt(3)).add(rs.getString(2));
                } else {
                    ArrayList<String> carac = new ArrayList<>();
                    carac.add(rs.getString(2));
                    mapPadroes.put(rs.getInt(3), carac);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return mapPadroes;
    }

    /**
     * 
     * @param id
     * @param padroes 
     */
    public static void gravaPatterns(int id, HashMap<String, List<String>> padroes) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("insert into padroes values (null,?,?,?);");
            for (String padrao : padroes.keySet()) {
                for (String palavras : padroes.get(padrao)) {
                    ps.setString(1, padrao);
                    ps.setString(2, palavras);
                    ps.setInt(3, id);
                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param id
     * @param oracoes 
     */
    public static void gravaOracoes(int id, List<String> oracoes) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("insert into oracoes values (null,?,?);");
            for (String oracao : oracoes) {
                ps.setString(1, oracao);
                ps.setInt(2, id);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param id
     * @param pares 
     */
    public static void gravaPares(int id, HashMap<String, String> pares) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("insert into pares_new values (null,?,?,?);");
            for (String carac : pares.keySet()) {
                ps.setString(1, carac);
                ps.setString(2, pares.get(carac));
                ps.setInt(3, id);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @return 
     */
    public static HashMap<Integer, Integer> getQuantPadroes() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();

        HashMap<Integer, Integer> padroesPorReview = new HashMap<Integer, Integer>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select idreviews, count(*) as total from padroes group by idreviews");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                padroesPorReview.put(rs.getInt(1), rs.getInt(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return padroesPorReview;
    }

    /**
     * 
     * @param id
     * @param pares 
     */
    public static void gravaParesNew(int id, HashMap<String, String> pares) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("insert into padroesnew values (null,?,?,?);");
            for (String palavras : pares.keySet()) {
                ps.setString(1, pares.get(palavras));
                ps.setString(2, palavras);
                ps.setInt(3, id);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param reviews 
     */
    public static void insereReviews(List<Review> reviews) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        System.out.println("sql: " + reviews.size() + "\n");
        for (Review rev : reviews.subList(0, 1000)) {
            PreparedStatement ps;
            try {
//                ps = connection.prepareStatement("insert into reviews values (null,?,?,?,?,?,?);");
                ps = connection.prepareStatement("insert into reviewsProduto values (null,?,?,?,?,?,?,?);");
                ps.setString(1, rev.getComentario());
                ps.setDate(2, new Date(rev.getData().getTime()));
                ps.setString(3, rev.getAutor());
                ps.setString(4, rev.getDominio());
                ps.setInt(5, rev.getAvaliacaoManual());
                ps.setDouble(6, rev.getEstrelas());
                ps.setString(7, rev.getProduto());
//                ps.setInt(7, rev.getUtilUp());
//                ps.setInt(8, rev.getUtilDown());
                int rs = ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(GravaReviews.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        conexao.remove(connection);
    }
}
