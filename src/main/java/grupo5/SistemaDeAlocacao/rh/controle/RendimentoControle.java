package grupo5.SistemaDeAlocacao.rh.controle;

import grupo5.SistemaDeAlocacao.rh.dominio.Cliente;
import grupo5.SistemaDeAlocacao.rh.repositorio.ClienteRepositorio;
import grupo5.SistemaDeAlocacao.rh.dominio.Rendimento;
import grupo5.SistemaDeAlocacao.rh.repositorio.RendimentoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class RendimentoControle {

    private final ClienteRepositorio clienteRepo;

    private final RendimentoRepositorio rendimentoRepo;

    public RendimentoControle(RendimentoRepositorio rendimentoRepo, ClienteRepositorio clienteRepo){
        this.clienteRepo = clienteRepo;
        this.rendimentoRepo = rendimentoRepo;
    }

    @GetMapping("/rh/clientes/rendimentos/novo/{cliente_id}")
    public String novoRendimento(Model model, @PathVariable("cliente_id")Long cliente_id){
        Rendimento aux = new Rendimento();
        aux.setClienteid(cliente_id);

        model.addAttribute("rendimento", aux);
        model.addAttribute("cliente", clienteRepo.findById(cliente_id));
        return "rh/clientes/rendimentosForm";
    }


    @GetMapping("/rh/clientes/rendimentos/{id}")
    public String listarRendimentos(@PathVariable("id") Long id, Model model){

        List<Rendimento> temp = new ArrayList<Rendimento>();
        List<Rendimento> domain = rendimentoRepo.findAll();

        for (Rendimento rend:domain
             ) {
            if(rend.getClienteid()==id){
                temp.add(rend);
            }
        }

        model.addAttribute("listaRendimentos", temp);
        return "rh/clientes/rendimentosView";
    }


    @PostMapping("rh/clientes/rendimentos/novo/rh/clientes/rendimentos/salvar")
    public String salvarRendimento(@ModelAttribute("rendimento") Rendimento rendimento){
        rendimentoRepo.save(rendimento);
        return "redirect:/rh/clientes";
    }

    @GetMapping("/rh/clientes/rendimentos/excluir/{id}")
    public String excluirRendimentos(@PathVariable("id") long id){
        Optional<Rendimento> rendimentoOpt = rendimentoRepo.findById(id);
        if(rendimentoOpt.isEmpty()){
            throw new IllegalArgumentException("Rendimento inválido");
        }

        rendimentoRepo.delete(rendimentoOpt.get());

        return "redirect:/rh/clientes";
    }

    @GetMapping("/rh/clientes/rendimentos/excluir/{code}")
    public String excluirRendimento(@PathVariable("code") long id){
        Optional<Rendimento> rendimentoOpt = rendimentoRepo.findById(id);
        if(rendimentoOpt.isEmpty()){
            throw new IllegalArgumentException("Rendimento inválido");
        }

       rendimentoRepo.delete(rendimentoOpt.get());

        return "redirect:/rh/clientes";
    }
}
