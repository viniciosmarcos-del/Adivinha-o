package adivinhacao;

public class rodada {
	private int num;
	private int chances_gstas;
	private float tempo_final_rodada;
	private String status;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getChances_gstas() {
		return chances_gstas;
	}
	
	public void setChances_gstas(int chances_gstas) {
		this.chances_gstas = chances_gstas;
	}
	
	public float getTempo_final_rodada() {
		return tempo_final_rodada;
	}
	
	public void setTempo_final_rodada(float tempo_final_rodada) {
		this.tempo_final_rodada = tempo_final_rodada;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void mostrar(int num, Sistema s, int tamanho) {
		 System.out.println("\n ============================== RODADA " + (num+1) + " ===============================\n");
		 if(getStatus() == "GANHOU") {
			 System.out.println("  -> Status: " + s.cor(0) + getStatus() + s.cor(-1));
		 }else {
			 System.out.println("  -> Status: " + s.cor(1) + getStatus() + s.cor(-1));
		 }
		 System.out.println("  -> Número sorteado da rodada: " + getNum());
		 System.out.println("  -> Chances gastas: " + getChances_gstas());
		 System.out.printf("  -> Tempo da rodada: " + getTempo_final_rodada() + " segundos \n\n");
		 System.out.println(" -----------------------------------------------------------------------\n");
	}
	
	
	
	
}
