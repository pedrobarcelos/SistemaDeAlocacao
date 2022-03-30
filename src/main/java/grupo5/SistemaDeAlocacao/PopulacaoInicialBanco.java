package grupo5.SistemaDeAlocacao;

import grupo5.SistemaDeAlocacao.rh.dominio.Cliente;
import grupo5.SistemaDeAlocacao.rh.dominio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

    @Autowired
    private ClienteRepositorio clienteRepo;

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente("Pedro");
        c1.setCpf("08597213612");
        c1.setProfissao("Assistente");

        Cliente c2 = new Cliente("Maria");
        c2.setCpf("33545120987");
        c2.setProfissao("Gerente");

        clienteRepo.save(c1);
        clienteRepo.save(c2);
    }
}
