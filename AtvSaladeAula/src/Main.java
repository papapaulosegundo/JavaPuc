import java.util.Scanner;

public class Main {
	
	public static void menu() {
		System.out.println("\nMenu de opcoes\n");

		System.out.println("1 - Matricular Alunos");
		System.out.println("2 - Listar Disciplinas");
		System.out.println("3 - Listar Alunos (por disciplina)");
		System.out.println("4 - Pesquisar Disciplina (por nome ou por código)");
		System.out.println("5 - Pesquisar Aluno (por nome ou matrícula)");
		System.out.println("6 - Alterar informações do estudante");
		System.out.println("7 - Sair");
		System.out.print("\nEscolha a opção: ");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		CadastroAlunos cadAluno = new CadastroAlunos();
		CadastroDisciplina cadDisciplina = new CadastroDisciplina();
		
		System.out.println("Cadastro das informações iniciais");
		System.out.println("\nDados dos alunos\n");
		
		String resposta;
		do {
			String nome;
			int matricula;

			System.out.print("Matricula: ");
			matricula = Integer.parseInt(scanner.nextLine());
			
			System.out.print("Nome: ");
			nome = scanner.nextLine();

			Aluno aluno = new Aluno(matricula, nome);
			cadAluno.adicionarAluno(aluno);

			System.out.println("Continuar cadastro (S/N)? ");
			resposta = scanner.nextLine();
			
		} while( resposta.equals("S") || resposta.equals("s"));
		
	
		// Pede as informações da disciplina
		System.out.println("\nDados das disciplinas\n");
		do {
			String codigo, nome, nomeProfessor;

			System.out.print("Codigo da disciplina: ");
			codigo = scanner.nextLine();
			
			System.out.print("Nome da disciplina: ");
			nome = scanner.nextLine();

			System.out.print("Nome do Professor: ");
			nomeProfessor = scanner.nextLine();

			Disciplina disciplina = new Disciplina(codigo, nome, new Professor(nomeProfessor));
			cadDisciplina.adicionarDisciplina(disciplina);

			System.out.println("Continuar cadastro (S/N)? ");
			resposta = scanner.nextLine();
			
		} while( resposta.equals("S") || resposta.equals("s"));
		
		int opcao;		
		Disciplina disciplina;
		Aluno aluno;
		do {
			menu();
			
			opcao = Integer.parseInt(scanner.nextLine());
			
			switch ( opcao ) {
			
			case 1:
				System.out.print("Nome da disciplina: ");
				String nomeDisciplina = scanner.nextLine();
				System.out.print("Nome do aluno: ");
				String nomeAluno = scanner.nextLine();
				disciplina = cadDisciplina.pesquisarNome(nomeDisciplina);
				aluno = cadAluno.pesquisarNome(nomeAluno);
				if( disciplina == null ) {
					System.out.println("Disciplina não encontrada!");
				} else if ( aluno == null ) {
					System.out.println("Aluno não encontrado!");
				} else {
					disciplina.matricularAluno(aluno);
					System.out.println("Aluno matriculado com sucesso!");
				}
				break;
			case 2:
				cadDisciplina.listar();
				break;
			case 3:
				cadDisciplina.listarAlunos();
				break;
			case 4:
				System.out.print("Informe nome ou código da disciplina: ");
				String nomeOuCodigo = scanner.nextLine();
				disciplina = cadDisciplina.pesquisarCodigo(nomeOuCodigo);
				if( disciplina == null) {
					disciplina = cadDisciplina.pesquisarNome(nomeOuCodigo);
					if( disciplina == null ) {
						System.out.println("Disciplina não encontrada!");
						break;
					}
				}
				System.out.println("Disciplina encontrada: " + disciplina.getCodigo() + " - " + disciplina.getNome());
				break;
			case 5:
				System.out.print("Informe nome ou matrícula do aluno: ");
				String nomeOuMatricula= scanner.nextLine();
				aluno = cadAluno.pesquisarNome(nomeOuMatricula);
				if ( aluno == null) {
					 aluno = cadAluno.pesquisarMatricula(Integer.parseInt(nomeOuMatricula));
					 if (aluno == null) {
						 System.out.println("Aluno não encontrado!");
						 break;
					 }
				}
				System.out.println("Aluno encontrado: " + aluno.getNome() + " - " + aluno.getMatricula());
				break;
			case 6:
				System.out.print("Digite a matrícula do aluno: ");
				int matricula = Integer.parseInt(scanner.nextLine());
				aluno = cadAluno.pesquisarMatricula(matricula);
				 if (aluno == null) {
					 System.out.println("Aluno não encontrado!");
					 break;
				 }
				 System.out.println("Digite o novo nome:");
				 String nome = scanner.nextLine();
				 aluno.setNome(nome);
				break;
			case 7:
				System.out.println("Não tenhamos pressa, mas não percamos tempo <3!");
				break;
			default:
				System.out.println("Opcao inválida!");
					
			}
			
		} while ( opcao != 7 );
		

	}
}


