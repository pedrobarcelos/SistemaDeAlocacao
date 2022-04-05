package grupo5.SistemaDeAlocacao.rh.controle;

import grupo5.SistemaDeAlocacao.rh.dominio.Cliente;
import grupo5.SistemaDeAlocacao.rh.dominio.Rendimento;
import grupo5.SistemaDeAlocacao.rh.repositorio.ClienteRepositorio;
import grupo5.SistemaDeAlocacao.rh.repositorio.RendimentoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClienteControle {

    private ClienteRepositorio clienteRepo;

    private RendimentoRepositorio rendimentoRepo;

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

    @GetMapping("/rh/clientes/{id}")
    public String alterarCliente(@PathVariable("id") Long id, Model model) {
        Optional<Cliente> clienteOpt = clienteRepo.findById(id);
        if(clienteOpt.isEmpty()){
            throw new IllegalArgumentException("Cliente inválido");
        }

        model.addAttribute("cliente", clienteOpt.get());

        return "rh/clientes/form";
    }

    @GetMapping("/rh/clientes/excluir/{id}")
    public String excluirCliente(@PathVariable("id") long id){
        Optional<Cliente> clienteOpt = clienteRepo.findById(id);
        if(clienteOpt.isEmpty()){
            throw new IllegalArgumentException("Cliente inválido");
        }
        clienteRepo.delete(clienteOpt.get());

//        List<Rendimento> temp = new ArrayList<Rendimento>();
//        List<Rendimento> domain = rendimentoRepo.findAll();
//
//        for (Rendimento rend:domain
//        ) {
//            if(rend.getClienteid()==id){
//                rendimentoRepo.delete(rend);
//            }
//        }

        return "redirect:/rh/clientes";
    }


}
