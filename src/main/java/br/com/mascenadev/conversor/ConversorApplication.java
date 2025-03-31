package br.com.mascenadev.conversor;

import br.com.mascenadev.conversor.entities.Instantiation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConversorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Instantiation instantiation = new Instantiation();
        instantiation.displayMenu();
    }
}
