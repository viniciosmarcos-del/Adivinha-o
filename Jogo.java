package adivinhacao;
import java.util.Random;

public class Jogo {
    Random random = new Random();
	private int num;
	private int chance;
	private int tentativas[] = new int[10];
	private int cor[] = new int[10];
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}
	
	public int getCor(int n) {
		return cor[n];
	}

	public void setCor(int cor, int n) {
		this.cor[n] = cor;
	}

	public int getTentativas(int n) {
		return tentativas[n];
	}

	public void setTentativas(int tentativas, int n) {
		this.tentativas[n] = tentativas;
	}
	
	public void inicia_jogo() {
		setNum(random.nextInt(100)); // sortea o número da rodada
		
		//limpa todos os resultados da rodada anterior
		for (int i = 0; i < 10; i++) {
	        tentativas[i] = 0;   
	        cor[i] = -1;      
	    }
	}
	
	public void regras(Sistema s) {
		 System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	     System.out.println(" -------------------------- REGRAS DO JOGO -----------------------------");
	     System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	     System.out.println("\n "+ "             O NOSSO JOGO FUNCIONA DA SEQUINTE FORMA:      ");
	     System.out.println("          1 - A cada rodada um número entre 0 e 100 será sorteado;     \n");
	     System.out.println("          2 - A cada rodada o jogador terá 10 chances de acertar     ");
	     System.out.println("              o número sorteado, seguindo como pista a coloração     ");
	     System.out.println("              do número do chute anterior, as cores podem ser:     \n");
	     System.out.println("                    1 - " + s.cor(1) + "VERMELHO" + s.cor(-1));
	     System.out.println("                      (caso o número chutado seja bem menor) \n");
	     System.out.println("                    2 - " + s.cor(2) + "LARANJA" + s.cor(-1));
	     System.out.println("                      (caso o número chutado esteja entre os 20");
	     System.out.println("                      antecessores do número sorteado) \n");
	     System.out.println("                    3 - " + s.cor(0) + "VERDE" + s.cor(-1));
	     System.out.println("                      (caso o número chutado seja o certo) \n");
	     System.out.println("                    4 - " + s.cor(4) + "AZUL" + s.cor(-1));
	     System.out.println("                      (caso o número chutado esteja entre os 20");
	     System.out.println("                      sucessores do número sorteado) \n");
	     System.out.println("                    5 - " + s.cor(3) + "ROXO" + s.cor(-1));
	     System.out.println("                      (caso o número chutado seja bem maior) \n");
	     System.out.println("          3 - O tempo da rodada será contado e aparecerá nos dados     ");
	     System.out.println("              referente a partida \n");
	     System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");
	}
	
	int n = 0;
	
	public int verificar_num(int chute) {
		if(chute < num) {
			if((num - chute) <= 20) {	// retorna 2 para um numero menor (dentro dos 20 sucessores) LARANJA
				n = 2;
			}else {
				n = 1; // retorna 1 para um numero bem menor VERMELHO
			}
		}
		// retorna 0 se for o numero certo VERDE
		else if (chute == num){
			n = 0;
		}
		else{
			if((chute - num) <= 20) {   // retorna 4 se for um numero menor (dentro dos 20 antecessores) AZUL
				n = 4;
			}else {
				n = 3; // retorna 3 para um numero bem maior ROXO
			}
		}
		
		return n;
	}
}
