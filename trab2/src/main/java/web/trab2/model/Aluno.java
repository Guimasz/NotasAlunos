package web.trab2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int turma;
    private String nome;
    private String matricula;
    private double nota;

    public Aluno() {}

    public Aluno(AlunoDto dto) {
        this.id = dto.id.equals("") ? null : Long.parseLong(dto.id);
        this.turma = dto.turma.equals("") ? 0 : Integer.parseInt(dto.turma);
        this.nome = dto.nome;
        this.matricula = dto.matricula;
        this.nota = dto.nota.equals("") ? 0 : Double.parseDouble(dto.nota);
    }

    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", turma=" + turma +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nota=" + nota +
                '}';
    }
}
