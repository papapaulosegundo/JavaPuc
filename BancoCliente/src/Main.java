import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Cria um objeto para o cliente
		Cliente cliente = new Cliente();

		// Pede as informações do cliente
		System.out.println("Informe os dados do cliente");
		System.out.print("Nome: ");
		cliente.setNome(scanner.nextLine());
		
		// Pede as informações do banco
		System.out.println();
		System.out.println("Informe os dados bancários");
		System.out.print("Numero da Agencia: ");
		int agencia = scanner.nextInt();
		System.out.print("Numero da conta: ");
		int conta = scanner.nextInt();
		
		// Cria um objeto para o banco com os dados informados
		Banco banco = new Banco(agencia, conta, cliente);
		
		// Apresenta menu de opcoes
		
		int opcao;
		double valor;
		do {
			System.out.println();
			System.out.println("Menu de opcoes:");
			System.out.println("1 - Depositar");
			System.out.println("2 - Sacar");
			System.out.println("3 - Consultar saldo");
			System.out.println("9 - Sair");
			System.out.print("Escolha a opcao: ");
			opcao = scanner.nextInt();
			
			if ( opcao == 1 ) {
				System.out.print("Valor a depositar: ");
				valor = scanner.nextDouble();
				banco.depositar(valor);
				System.out.println("Saldo atual: " + banco.consultarSaldo());
			} else if ( opcao == 2 )  {
				System.out.print("Valor a sacar: ");
				valor = scanner.nextDouble();
				banco.sacar(valor);
				System.out.println("Saldo atual: " + banco.consultarSaldo());
			} else if ( opcao == 3 ) {
				banco.imprimirSaldo();
			}
		} while ( opcao != 9);
		
	}
}
