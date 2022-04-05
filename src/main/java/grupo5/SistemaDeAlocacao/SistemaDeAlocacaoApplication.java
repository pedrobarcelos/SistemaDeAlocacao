package grupo5.SistemaDeAlocacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages={"grupo5.SistemaDeAlocacao"})
@SpringBootApplication
public class SistemaDeAlocacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAlocacaoApplication.class, args);
	}

}
