package grupo5.SistemaDeAlocacao.rh.controle;

import grupo5.SistemaDeAlocacao.rh.dominio.Cliente;
import grupo5.SistemaDeAlocacao.rh.dominio.ClienteRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/rh/clientes/novo")
    public String novoCliente(@ModelAttribute("cliente") Cliente cliente){
        return "rh/clientes/form";
    }

    @PostMapping("/rh/clientes/salvar")
    public String salvarPessoa(@ModelAttribute("cliente") Cliente cliente){
        clienteRepo.save(cliente);
        return "redirect:/rh/clientes";
    }

}
