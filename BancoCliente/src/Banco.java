
public class Banco {
	private int agencia;
	private int conta;
	private double saldo;
	private Cliente cliente;
	
	// construtor
	public Banco(int agencia, int conta, Cliente cliente) {
		this.agencia = agencia;
		this.conta = conta;
		this.saldo = 0.0;
		this.cliente = cliente;
	}
	
	// operacoes
	public void depositar(double valor) {
		saldo = saldo + valor;
	}
	
	public void sacar(double valor) {
		if( saldo >= valor ) 
			saldo = saldo - valor;
		else
			System.out.println("Saldo insuficiente!");
	}
	
	public double consultarSaldo() {
		return saldo;
	}
	
	public void imprimirSaldo() {
		System.out.println("--------------------------------");
		System.out.println("Agencia: " + agencia);
		System.out.println("Conta..: " + conta);
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Saldo..: R$ " + saldo );
		System.out.println("--------------------------------");
	}
	
}
