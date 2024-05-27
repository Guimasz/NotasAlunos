package web.trab2.config;

import web.trab2.model.Aluno;
import web.trab2.repository.AlunoRepository;

public class Utils {

    public static void startDb(AlunoRepository repository) {
        // ALUNOS TURMA 1
        Aluno a1 = new Aluno();
        a1.setNome("John Romita");
        a1.setMatricula("2023011654");
        a1.setTurma(1);
        a1.setNota(3.2);
        repository.save(a1);
        Aluno a2 = new Aluno();
        a2.setNome("Gil Kane");
        a2.setMatricula("2023010752");
        a2.setTurma(1);
        a2.setNota(4.5);
        repository.save(a2);
        Aluno a3 = new Aluno();
        a3.setNome("Frank Miller");
        a3.setMatricula("2023014025");
        a3.setTurma(1);
        a3.setNota(7.8);
        repository.save(a3);
        Aluno a4 = new Aluno();
        a4.setNome("Ross Andru");
        a4.setMatricula("2023017365");
        a4.setTurma(1);
        a4.setNota(1.6);
        repository.save(a4);
        Aluno a5 = new Aluno();
        a5.setNome("Adam Kubert");
        a5.setMatricula("2023014780");
        a5.setTurma(1);
        a5.setNota(2.1);
        repository.save(a5);
        Aluno a6 = new Aluno();
        a6.setNome("Alex Ross");
        a6.setMatricula("2023011122");
        a6.setTurma(1);
        a6.setNota(10);
        repository.save(a6);
        Aluno a7 = new Aluno();
        a7.setNome("Esad Ribic");
        a7.setMatricula("2023011114");
        a7.setTurma(1);
        a7.setNota(2.1);
        repository.save(a7);
        Aluno a8 = new Aluno();
        a8.setNome("Neal Adams");
        a8.setMatricula("2023011432");
        a8.setTurma(1);
        a8.setNota(9.5);
        repository.save(a8);
        Aluno a9 = new Aluno();
        a9.setNome("Adi Granov");
        a9.setMatricula("2023017509");
        a9.setTurma(1);
        a9.setNota(6.9);
        repository.save(a9);
        Aluno a10 = new Aluno();
        a10.setNome("Dave McKean");
        a10.setMatricula("2023011113");
        a10.setTurma(1);
        a10.setNota(10);
        repository.save(a10);

        // ALUNOS TURMA 2
        Aluno a11 = new Aluno();
        a11.setNome("Frank Miller");
        a11.setMatricula("2023021971");
        a11.setTurma(2);
        a11.setNota(3.7);
        repository.save(a11);
        Aluno a12 = new Aluno();
        a12.setNome("John Byrne");
        a12.setMatricula("2023021987");
        a12.setTurma(2);
        a12.setNota(9.1);
        repository.save(a12);
        Aluno a13 = new Aluno();
        a13.setNome("Roy Thomas");
        a13.setMatricula("2023021987");
        a13.setTurma(2);
        a13.setNota(0.2);
        repository.save(a13);
        Aluno a14 = new Aluno();
        a14.setNome("Alan Moore");
        a14.setMatricula("2023021987");
        a14.setTurma(2);
        a14.setNota(7.8);
        repository.save(a14);
        Aluno a15 = new Aluno();
        a15.setNome("Andy Kubert");
        a15.setMatricula("2023021987");
        a15.setTurma(2);
        a15.setNota(4.6);
        repository.save(a15);

    }
}
