package core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe de modelo de um comentário
 *
 * @author Rogerio
 */
public class Review {

    private int id;
    private String comentario;
    private Date data;
    private String autor;
    private String dominio;
    private int avaliacaoManual;
    private String classeManual;
    private double estrelas;
    private String produto;
    private int utilUp;
    private int utilDown;
    private double importancia;
    private int avaliacaoAutomatica;
    private List<String> padroes;
    private String avaliacao_conceitual;
    private String avaliacao_conceitual_manual;
    private int postsAutor;
    private double percentCorretude;

    public double getPercentCorretude() {
        return percentCorretude;
    }

    public void setPercentCorretude(double percentCorretude) {
        this.percentCorretude = percentCorretude;
    }
    /* Campos que podem ser excluídos */
    private int pos;
    private int neg;

    
    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getNeg() {
        return neg;
    }

    public void setNeg(int neg) {
        this.neg = neg;
    }

    public String getAvaliacao_conceitual() {
        return avaliacao_conceitual;
    }

    public void setAvaliacao_conceitual(String avaliacao_conceitual) {
        this.avaliacao_conceitual = avaliacao_conceitual;
    }

    public String getAvaliacao_conceitual_manual() {
        return avaliacao_conceitual_manual;
    }

    public void setAvaliacao_conceitual_manual(String avaliacao_conceitual_manual) {
        this.avaliacao_conceitual_manual = avaliacao_conceitual_manual;
    }
    
    public String getClasseManual() {
        return this.classeManual;
    }

    public void setNeg(String classeManual) {
        this.classeManual = classeManual;
    }
    
    public Review() {
        this.padroes = new ArrayList<>();
        
    }

    public Review(String comentario, int avaliacaoManual) {
        this.padroes = new ArrayList<>();
        this.comentario = comentario;
        this.avaliacaoManual = avaliacaoManual;
    }
    
    public Review(String comentario, String classeManual) {
        this.padroes = new ArrayList<>();
        this.comentario = comentario;
        this.classeManual = classeManual;
    }

    public Review(int id, String comentario, int avaliacaoManual) {
        this.padroes = new ArrayList<>();
        this.id = id;
        this.comentario = comentario;
        this.avaliacaoManual = avaliacaoManual;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getAvaliacaoManual() {
        return avaliacaoManual;
    }

    public void setAvaliacaoManual(int avaliacaoManual) {
        this.avaliacaoManual = avaliacaoManual;
    }

    public int getAvaliacaoAutomatica() {
        return avaliacaoAutomatica;
    }

    public void setAvaliacaoAutomatica(int avaliacaoAutomatica) {
        this.avaliacaoAutomatica = avaliacaoAutomatica;
    }

    public Review(String comentario, double importancia) {
        this.padroes = new ArrayList<>();
        this.comentario = comentario;
        this.importancia = importancia;
    }

    public double getImportancia() {
        return importancia;
    }

    public void setImportancia(double importancia) {
        this.importancia = importancia;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the dominio
     */
    public String getDominio() {
        return dominio;
    }

    /**
     * @param dominio the dominio to set
     */
    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    /**
     * @return the estrelas
     */
    public double getEstrelas() {
        return estrelas;
    }

    /**
     * @param estrelas the estrelas to set
     */
    public void setEstrelas(double estrelas) {
        this.estrelas = estrelas;
    }

    /**
     * @return the utilUp
     */
    public int getUtilUp() {
        return utilUp;
    }

    /**
     * @param utilUp the utilUp to set
     */
    public void setUtilUp(int utilUp) {
        this.utilUp = utilUp;
    }

    /**
     * @return the utilDown
     */
    public int getUtilDown() {
        return utilDown;
    }

    /**
     * @param utilDown the utilDown to set
     */
    public void setUtilDown(int utilDown) {
        this.utilDown = utilDown;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    public List<String> getPadroes() {
        return padroes;
    }

    public void setPadroes(List<String> padroes) {
        this.padroes = padroes;
    }

    @Override
    public String toString() {
        //return id + "\t" + avaliacaoManual + "\t" + avaliacaoAutomatica + "\t" + importancia +"\n";
        return this.id + "," + this.postsAutor + "," + this.getPadroes().size() + "," + this.getPercentCorretude()
                + "," + this.avaliacao_conceitual_manual +"\n";
    }

    public int getPostsAutor() {
        return postsAutor;
    }

    public void setPostsAutor(int postsAutor) {
        this.postsAutor = postsAutor;
    }
    
    
}
