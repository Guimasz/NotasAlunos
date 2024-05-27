package web.trab2.model;

public class AlunoDto {

    public String id;
    public String turma;
    public String nome;
    public String matricula;
    public String nota;

    public AlunoDto() {}

    public AlunoDto(Aluno a) {
        this.id = String.valueOf(a.getId());
        this.turma = String.valueOf(a.getTurma());
        this.nome = a.getNome();
        this.matricula = a.getMatricula();
        this.nota = String.valueOf(a.getNota());
    }

    @Override
    public String toString() {
        return "AlunoDto{" +
                "id='" + id + '\'' +
                ", turma='" + turma + '\'' +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }
}
