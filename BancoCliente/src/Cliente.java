
public class Cliente {
	private String nome;
	
	// construtor vazio
	public Cliente() {
		this.nome = "";
	}
	// construtor com parametros
	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}		
}
