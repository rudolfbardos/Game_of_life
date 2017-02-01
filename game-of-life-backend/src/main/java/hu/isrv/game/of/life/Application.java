package hu.isrv.game.of.life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("hu.isrv.game.of.life")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
