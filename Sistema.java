package adivinhacao;
import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
	Jogador j = new Jogador();
	Jogo jogo = new Jogo();
	ArrayList<rodada> rodadas = new ArrayList<>();

	Scanner sc = new Scanner(System.in);
	
	public String cor(int n) {
		String cor = "";
		// Se o número chutado for bem menor do que o número do certo - VERMELHO
		if (n == 1) {
			cor = "\u001B[31m";
		}
		// Se o número chutado for menor, mas estuver entre os 20 números antecessores do certo - LARANJA
		else if (n == 2) {
			cor = "\u001B[1;33m";
		}
		// Se acertar o número - VERDE
		else if (n == 0) {
			cor = "\u001B[32m";
		}
		// Se o número chutado for maior, porém está entre os 20 sucessores do certo - ROXO
		else if (n == 3) {
			cor = "\u001B[35m";
		}
		// Se o número chutado for bem maior do que o certo - AZUL
		else if (n == 4) {
			cor ="\u001B[34m";
		}
		// LIMPA A COR
		else if (n == -1) {
			cor ="\u001B[0m";
		}
		return cor;
	}
	
	// Variaveis para calcular o tempo da partida
	long inicio = 0;
	long fim = 0;
	
	// Variavel para criar novas rodadas
	int r = 0;

	public void jogar () {
		int cont = 0;
		int result = -1;
		int chances = 11;
		
		jogo.inicia_jogo(); //Inicia um novo
		inicio = System.currentTimeMillis(); // Começa a contar o tempo
		
		while (cont < 10 && result != 0) {
			System.out.println(" -----------------------------------------------------------------------");
			System.out.println();
			rodada_da_vez(); // Mostra os números da rodada, cada um com sua cor
			System.out.println();
			System.out.println("                                             chances disponiveis: " + (chances-=1));
			System.out.println(" -----------------------------------------------------------------------");
			System.out.print("    -> Chute da vez: ");
			jogo.setTentativas(sc.nextInt(), cont);
			
			result = jogo.verificar_num(jogo.getTentativas(cont)); // joga na verificação e vê o resultado, dependendo do valor ele vai ganhar uma cor
			
			jogo.setCor(result, cont); // O valor que vier de result vai ser adicionado no vetor cor
			if(result == 0) { // Se ganhar o jogo aparece na tela, somente para ver que o valor ficou verde
				System.out.println(" -----------------------------------------------------------------------");
				System.out.println();
				rodada_da_vez();
				System.out.println();
				System.out.println("                                             chances disponiveis: " + (chances-=1));
				System.out.println(" -----------------------------------------------------------------------");
			}

			cont ++; 
			
		}
		
        fim = System.currentTimeMillis();  //Lógica do jogo, ao terminar finaliza o tempo e mostra tempo gasto.
        System.out.println();
		System.out.println(" -----------------------------------------------------------------------");
			
		if (result == 0) {
			System.out.println("               PARABÉNS!! (^-^) - VOCÊ ACERTOU O NÚMERO");
		}else {
			System.out.println("                  POXA!! (x-x) - VOCÊ ERROU O NÚMERO");
		}
		System.out.println(" -----------------------------------------------------------------------");
        System.out.println("      -> Rodada finalizada             -> Tempo gasto: " + ((fim - inicio)/1000) + " segundos.");   //Calculo para saber o valor em segundos.
        
        float resultado = (fim-inicio)/1000; // Calculo do tempo gasto na rodada em segundos
        
        rodada rnova = new rodada(); 
        rodadas.add(rnova); // Adiciona uma nova rodada para colocar os valores adiquiridos agora
        
        // set esses valores
        rodadas.get(r).setNum(jogo.getNum());
        rodadas.get(r).setTempo_final_rodada(resultado);
        
        if (result == 0) {
        	rodadas.get(r).setStatus("GANHOU");
        	rodadas.get(r).setChances_gstas(cont);
        }else {
        	rodadas.get(r).setStatus("PERDEU");
        	rodadas.get(r).setChances_gstas(10);
        }
        
        r++; 
	}
	
	public void rodada_da_vez() { // Vai mostrando os valores, de acordo com o seu chute os números vão aparecer da cor correspondente
		System.out.print("          ");
		for(int i = 0; i<10; i++) {
			System.out.print("   [ " + cor(jogo.getCor(i)) + jogo.getTentativas(i) +  cor(-1) + " ] ");
			if(i == 4) {
				System.out.println(" ");
				System.out.print("          ");
			}else if(i == 9) {
				System.out.println(" ");
			}
		}
	}
	
	public void menu(Sistema s) {
	        int op;
	        System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	        System.out.println(" ------------------------- ADIVINHE O NÚMERO ---------------------------");
	        System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	        System.out.println("\n "+ "         SEJA MUITO BEM-VINDO AO NOSSO JOGO DA ADIVINHAÇÃO!!     ");
	        System.out.println("          Antes de mais nada, pediremos alguns dados pessoais que     ");
	        System.out.println("          serão acrescentados ao seu cadastro pessoal, tudo isso     ");
	        System.out.println("          servirá para auxiliar na hora de expor os seus resultados      ");
	        System.out.println("          dentro do jogo!!     \n");
	        System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	        System.out.println(" ------------------------------ CADASTRO -------------------------------");
	        System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
	        j.cadastrar();
	        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	        
	        do{
	            System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		        System.out.println(" --------------------------- MENU DE OPÇÕES ----------------------------");
		        System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
	            System.out.println("  -> Digite (1) - Para jogar\n  -> Digite (2) - Para ver as regras do jogo\n  -> Digite (3) - Mostrar dados\n  -> Digite (0) - Para sair\n");
	            System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ");
	            System.out.print("\n  -> INFORME AQUI A SUA ESCOLHA: ");
	            op = sc.nextInt();
	            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	            switch(op) {
	                case 1:
	                    jogar();
	                    break;
	                case 2:
	                    jogo.regras(s);
	                    break;
	                case 3:
	                    j.mostrar();
	                    System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    		        System.out.println(" ------------------------------ RODADAS --------------------------------");
	    		        System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
	                    if(r == 0) {
	                    	System.out.println("              O usuário ainda não jogou nenhuma rodada \n");
	                    }else {
	                    	for(int i = 0; i< rodadas.size(); i++) {
	                    		rodadas.get(i).mostrar(i, s, rodadas.size());
	                    	}
	                    }
	                    break;
	                default: 
	                    System.out.println("Opção inválida!");
	                    break;
	                case 0:
	                	System.out.println(" -----------------------------------------------------------------------\n");
	                    System.out.println("                           Jogo Finalizado!! \n");
	                    System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    		        System.out.println(" ------------------------ OBRIGADO POR JOGAR ---------------------------");
	    		        System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n");
	                    break;
	            }
	        }while(op!=0);
	}

}
