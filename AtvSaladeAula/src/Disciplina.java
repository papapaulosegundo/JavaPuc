
public class Disciplina {
	private String codigo;
	private String nome;
	private Professor professor;
	private int qtdAluno = 0;
	// vetor para armazenar os alunos da disciplina
	private Aluno[] alunos = new Aluno[40];
	
	// construtor
	public Disciplina(String codigo, String nome, Professor professor) {
		this.codigo = codigo;
		this.nome = nome;
		this.professor = professor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public Aluno[] getAlunos() {
		return alunos;
	}
	public void listarDisciplina(String nome) {
		this.nome = nome;
	}
	
	public void matricularAluno(Aluno aluno) {
		if( qtdAluno == 40 ) {
			System.out.println("Turma cheia! Não é possível matrícular!");
		} else {
			alunos[qtdAluno] = aluno;
			qtdAluno++;	
		}
	}

}
