package grupo5.SistemaDeAlocacao.rh.dominio;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Rendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    private String origem;

    private Float valor;

    private Long clienteid;

    public Rendimento(){}

    @Deprecated
    public Rendimento(Long clienteid){
        this.clienteid = clienteid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rendimento that = (Rendimento) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long id) {
        this.code = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Long getClienteid() {
        return clienteid;
    }

    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }
}
