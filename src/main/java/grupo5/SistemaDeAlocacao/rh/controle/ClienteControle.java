package grupo5.SistemaDeAlocacao.rh.controle;

import grupo5.SistemaDeAlocacao.rh.dominio.ClienteRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteControle {

    private ClienteRepositorio clienteRepo;

    public ClienteControle(ClienteRepositorio clienteRepo){
        this.clienteRepo = clienteRepo;
    }

    @GetMapping("/rh/clientes")
    public String clientes(Model model){
        model.addAttribute("listaClientes", clienteRepo.findAll());
        return "rh/clientes/index";
    }

}
