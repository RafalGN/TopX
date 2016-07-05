/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.banco;

import core.model.Review;
import gramaticas.sentiLex.ObjetoSentiLex;
import java.sql.Connection;
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
public class GravaCorpusBuscape {

    public static List<Review> selectPositivos() {
        ConexaoCorpusBuscape conexao = new ConexaoCorpusBuscape();
        Connection connection = conexao.getConnection();

        List<Review> comments = new ArrayList<Review>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT tblavalalunos.id, tblavalalunos.op, tblavalalunosautor.author "
                    + "FROM tblavalalunos, tblavallinguista, tblavalalunosautor "
                    + "where tblavalalunos.id = tblavallinguista.id "
                    + "and tblavalalunos.id = tblavalalunosautor.id "
                    + "and tblavallinguista.id = tblavalalunosautor.id "
                    + "and tblavalalunos.pos = 1 "
                    + "and tblavallinguista.pos = 1 "
                    + "and tblavalalunos.neg = 0 "
                    + "and tblavallinguista.neg = 0;");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Review r = new Review(rs.getInt(1), rs.getString(2), 1);
                r.setAutor(rs.getString(3));
                comments.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return comments;
    }

    public static List<Review> selectNegativos() {
        ConexaoCorpusBuscape conexao = new ConexaoCorpusBuscape();
        Connection connection = conexao.getConnection();

        List<Review> comments = new ArrayList<Review>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT tblavalalunos.id, tblavalalunos.op, tblavalalunosautor.author "
                    + "FROM tblavalalunos, tblavallinguista, tblavalalunosautor "
                    + "where tblavalalunos.id = tblavallinguista.id "
                    + "and tblavalalunos.id = tblavalalunosautor.id "
                    + "and tblavallinguista.id = tblavalalunosautor.id "
                    + "and tblavalalunos.pos = 0 \n"
                    + "and tblavallinguista.pos = 0 \n"
                    + "and tblavalalunos.neg = 1 "
                    + "and tblavallinguista.neg = 1;");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Review r = new Review(rs.getInt(1), rs.getString(2), -1);
                r.setAutor(rs.getString(3));
                comments.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return comments;
    }

    public static List<Review> selectPositivosNegativos() {
        ConexaoCorpusBuscape conexao = new ConexaoCorpusBuscape();
        Connection connection = conexao.getConnection();

        List<Review> comments = new ArrayList<Review>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT tblavalalunos.id, tblavalalunos.op, tblavalalunosautor.author "
                    + "FROM tblavalalunos, tblavallinguista, tblavalalunosautor "
                    + "where tblavalalunos.id = tblavallinguista.id "
                    + "and tblavalalunos.id = tblavalalunosautor.id "
                    + "and tblavallinguista.id = tblavalalunosautor.id "
                    + "and tblavalalunos.pos = 1 \n"
                    + "and tblavallinguista.pos = 1 \n"
                    + "and tblavalalunos.neg = 1 "
                    + "and tblavallinguista.neg = 1;");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Review r = new Review(rs.getInt(1), rs.getString(2), 0);
                r.setAutor(rs.getString(3));
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
     * @param palavras
     */
    public static void gravaPalavras(List<ObjetoSentiLex> palavras) {
        ConexaoSentiLex conexao = new ConexaoSentiLex();
        Connection connection = conexao.getConnection();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("insert into lemmas values (null,?,?,?);");
            for (ObjetoSentiLex lemma : palavras) {
                ps.setString(1, lemma.getExpressao());
                ps.setString(2, lemma.getClasseGramatical());
                ps.setInt(3, lemma.getPolaridade());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    public static Map<String, Integer> selectLexico() {
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
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return mapLemmas;
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
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return mapPadroes;
    }

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
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return padroesPorReview;
    }

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
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Review> selectAvaliacaoConceitual() {
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();

        List<Review> comments = new ArrayList<Review>();

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("SELECT id, comentario, autor, avaliacao_dominio FROM comentarios.reviews where avaliacao_conceitual is not null and avaliacao_conceitual not like 'XX';");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Review r = new Review(rs.getInt(1), rs.getString(2), rs.getInt(4));
                r.setAutor(rs.getString(3));
                comments.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GravaCorpusBuscape.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.remove(connection);

        return comments;
    }
}
