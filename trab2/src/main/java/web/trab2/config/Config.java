package web.trab2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import web.trab2.repository.AlunoRepository;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    AlunoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Utils.startDb(repository);
    }
}
