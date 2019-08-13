# Projeto TOPX

* O arquivo de entrada tem a seguinte estrutura:
    * 2 colunas: *Texto_do_review [tab] Quantidade_de_Posts_do_Autor_do_Review*;
    * Um Review por linha.

* Modo de execução com o Jar:
    1. Deve-se garantir que o jar está na mesma pasta das pastas **lib**, **recursos** e **TreeTagger**;
    2. Executar com "java -jar ProjetoFinal.jar \<Caminho do arquivo de reviews\>"
    3. A saída será realizada por meio do arquivo com extensão <arquivodereviews>.res.

* A classe principal é: **src/main/Main.java**

* Observações:
    * Avisos do tipo *"token recognition error at:"* são erros de reconhecimento do ANTLR;