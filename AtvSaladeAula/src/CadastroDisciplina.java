
public class CadastroDisciplina {
	private int qtdDisciplina = 0;
	private Disciplina[] disciplinas = new Disciplina[100];
	
	// Adiciona aluno ao cadastro
	public void adicionarDisciplina(Disciplina disciplina) {
		if( qtdDisciplina == 100 ) {
			System.out.println("Não é possível cadatrar aluno!");
		} else {
			disciplinas[qtdDisciplina] = disciplina;
			qtdDisciplina++;	
		}
	}
	
	// pesquisa aluno pelo nome
	// retorna null, caso não encontre aluno
	public Disciplina pesquisarNome(String nome) {
		for( int i = 0; i < qtdDisciplina; i++ ) {
			if( disciplinas[i].getNome().equals(nome) ) {
				return disciplinas[i];
			}
		}
		return null;
	}

	// pesquisa aluno pela matricula
	// retorna null, caso não encontre aluno
	public Disciplina pesquisarCodigo(String codigo) {
		for( int i = 0; i < qtdDisciplina; i++ ) {
			if( disciplinas[i].getCodigo().equals(codigo) ) {
				return disciplinas[i];
			}
		}
		return null;
	}
	
	// lista as disciplinas cadastradas
	public void listar() {
		System.out.println("Listagem de disciplinas");
		System.out.println("--------------------------------------------");
		for( int i = 0; i < qtdDisciplina; i++ ) {
			System.out.println(disciplinas[i].getCodigo() + " - " + disciplinas[i].getNome());
		}		
		System.out.println("--------------------------------------------");
	}

	// lista as disciplinas cadastradas
	public void listarAlunos() {
		System.out.println("Listagem de alunos por disciplina");
		System.out.println("--------------------------------------------");
		for( int i = 0; i < qtdDisciplina; i++ ) {
			System.out.println(disciplinas[i].getCodigo() + " - " + disciplinas[i].getNome());
			Aluno[] alunos = disciplinas[i].getAlunos();
			for( Aluno aluno : alunos ) {
				if (aluno == null )
					break;
				System.out.println("\t" + aluno.getMatricula() + " - " + aluno.getNome());
			}
		}		
		System.out.println("--------------------------------------------");
	}

}
