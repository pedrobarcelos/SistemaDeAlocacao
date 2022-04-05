package grupo5.SistemaDeAlocacao.rh.dominio;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rg;

    private String cpf;

    private String nome;

    private String endereco;

    private String profissao;

    protected Cliente(){}

    @Deprecated
    public Cliente(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
//
//    public List<String> getEmpregadores() {
//        return empregadores;
//    }
//
//    public void setEmpregadores(List<String> empregadores) {
//        this.empregadores = empregadores;
//    }
//
//    public List<Float> getRendimentos() {
//        return rendimentos;
//    }
//
//    public void setRendimentos(List<Float> rendimentos) {
//        this.rendimentos = rendimentos;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
