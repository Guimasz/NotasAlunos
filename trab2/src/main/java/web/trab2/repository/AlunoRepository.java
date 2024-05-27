package web.trab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.trab2.model.Aluno;

import java.util.ArrayList;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    ArrayList<Aluno> findAll();

    int countAlunoByTurma(int turma);

}
