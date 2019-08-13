
# Projeto TOPX

  

*  [Download do jar e suas dependências](https://www.dropbox.com/s/5jlz4asb49swuwz/TopX.zip?dl=0)

* O arquivo de entrada tem a seguinte estrutura:

	* 2 colunas: *Texto_do_review [tab] Quantidade_de_Posts_do_Autor_do_Review*;

	* Um Review por linha.

  

* Modo de execução com o Jar:

	1. Deve-se garantir que o jar está na mesma pasta das pastas **lib**, **recursos**, **TreeTagger**, **fcl** e **Jortho**;

	2. Executar com "java -jar ProjetoFinal.jar \<Caminho do arquivo de reviews.txt\>"
	
	4. A saída será realizada por meio do arquivo com extensão <arquivodereviews>.res.

  
* A classe principal é: **src/main/Main.java**

  

* Observações:

	* Avisos do tipo *"token recognition error at:"* são erros de reconhecimento do ANTLR;

  

#### Publicações relacionadas ao projeto:
* [Principal publicação](https://ieeexplore.ieee.org/stamp/stamp.jsp?arnumber=7337914)
	```
	@inproceedings{de2015fuzzy,
	 title={A fuzzy system-based approach to estimate the importance of online customer reviews},
	 author={de Sousa, Rog{\'e}rio F and Rab{\^e}lo, Ricardo AL and Moura, Raimundo S},
	 booktitle={2015 IEEE International Conference on Fuzzy Systems (FUZZ-IEEE)},
	 pages={1--8},
	 year={2015},
	 organization={IEEE}
	}
	```

* **[SOUSA, R. F.](http://lattes.cnpq.br/9346694618502913)**; [RABELO, R. A. L.](http://buscatextual.cnpq.br/buscatextual/visualizacv.do?id=K4732267Z2) ; [MOURA, R. S.](http://lattes.cnpq.br/7902070751612416) . [An Approach to Select the Best User Reviews on the Web](https://www.ijcla.org/2016-1/IJCLA-2016-1-pp-121-141-preprint.pdf). In: International Conference on Intelligent Text Processing and Computational Linguistics, 2015, Cairo. 16th International Conference on Intelligent Text Processing and Computational Linguistics, 2015.

* **[SOUSA, R. F.](http://lattes.cnpq.br/9346694618502913)**; [MOURA, R. S.](http://lattes.cnpq.br/7902070751612416) ; [RABELO, R. A. L.](http://buscatextual.cnpq.br/buscatextual/visualizacv.do?id=K4732267Z2) . [Abordagem Top(X) para Inferir os Comentários mais Importantes sobre produtos e serviços](http://swge.inf.br/SBAI2015/anais/113.PDF). In: Simpósio Brasileiro de Automação Inteligente, 2015, Natal. Abordagem Top(X) para Inferir os Comentários mais Importantes sobre produtos e serviços, 2015.