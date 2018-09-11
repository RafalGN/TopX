package util.arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;

public class UtilsArquivo {

    /**
     * Construtor
     */
    public UtilsArquivo() {
    }

    /**
     *
     * @param dir
     * @param nome
     * @return
     */
    public File criaArq(String dir, String nome) {
        File diretorio = new File(dir);
        File arquivo = new File(diretorio, nome);
        return arquivo;
    }

    /**
     *
     * @param arquivo
     * @param texto
     * @throws IOException
     */
    public void escreverArq(File arquivo, String texto) throws IOException {
        FileOutputStream fos = new FileOutputStream(arquivo);
        fos.write(texto.getBytes());
        fos.close();
    }

    /**
     *
     * @param arquivo
     * @return
     * @throws IOException
     */
    public String lendoArq(File arquivo) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "ISO-8859-1"));
        // l� o arquivo
        while (in.ready()) {
            sb.append(in.readLine());
        }
        return sb.toString();
    }

    public static void salva(String path, String conteudo) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(conteudo);
        bw.close();
    }

    /**
     * Carrega o conte�do de um arquivo em uma String, se o aquivo n�o existir,
     * retornar� null.
     *
     * @param arquivo
     * @return conte�do
     * @throws Exception
     */
    public String carregar(String arquivo)
            throws FileNotFoundException, IOException {

        File file = new File(arquivo);

        if (!file.exists()) {
            return null;
        }

        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        StringBuffer bufSaida = new StringBuffer();

        String linha;
        while ((linha = br.readLine()) != null) {
            bufSaida.append(linha + "\n");
        }
        br.close();
        return bufSaida.toString();
    }

    public static void gravaArquivoFeatures(Set<String> lista, String nomeArquivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        String conteudo = "";

        for (String linha : lista) {
            conteudo += linha + "\n";
        }

        bw.write(conteudo);
        bw.close();
    }
    
    
//	// 		EXEMPLO
//	public static void main(String[] args) {
//		try {
//		String texto = "teste arquivo!";
//
//		UtilsArquivo.salva("emails.txt", texto, false);
//
//		System.out.println(""+UtilsArquivo.carregar("emails.txt"));
//
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
//
//		}
}