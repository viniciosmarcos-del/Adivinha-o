package adivinhacao;
import java.util.Scanner;

public class Jogador {
	private String nome;
	private String email;
	private String senha;
	
	Scanner leitor = new Scanner(System.in);
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void cadastrar() {
        System.out.print(" 1 - Informe seu nome: ");
        setNome(leitor.nextLine());
        System.out.print(" 2 - Informe seu email: ");
        setEmail(leitor.nextLine());
        System.out.print(" 3 - Informe uma senha: ");
        setSenha(leitor.nextLine());
	}
	
	public void mostrar() {
		System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    System.out.println(" ----------------------- INFORMAÇÕES PESSOAIS --------------------------");
	    System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("\n  -> 1 - Nome: " + getNome());
        System.out.println("  -> 2 - Email: " + getEmail());
        System.out.println("  -> 3 - Senha: " + getSenha() + "\n");
	}
}
