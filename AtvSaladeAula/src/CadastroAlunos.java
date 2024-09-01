
public class CadastroAlunos {
	private int qtdAluno = 0;
	private Aluno[] alunos = new Aluno[100];
	
	// Adiciona aluno ao cadastro
	public void adicionarAluno(Aluno aluno) {
		if( qtdAluno == 100 ) {
			System.out.println("Não é possível cadatrar aluno!");
		} else {
			alunos[qtdAluno] = aluno;
			qtdAluno++;	
		}
	}
	
	// pesquisa aluno pelo nome
	// retorna null, caso não encontre aluno
	public Aluno pesquisarNome(String nome) {
		for( int i = 0; i < qtdAluno; i++ ) {
			if( alunos[i].getNome().equals(nome) ) {
				return alunos[i];
			}
		}
		return null;
	}

	// pesquisa aluno pela matricula
	// retorna null, caso não encontre aluno
	public Aluno pesquisarMatricula(int matricula) {
		for( int i = 0; i < qtdAluno; i++ ) {
			if( alunos[i].getMatricula() == matricula ) {
				return alunos[i];
			}
		}
		return null;
	}
}
