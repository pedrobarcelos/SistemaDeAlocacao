package grupo5.SistemaDeAlocacao.rh.repositorio;

import grupo5.SistemaDeAlocacao.rh.dominio.Rendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RendimentoRepositorio extends JpaRepository<Rendimento, Long> {

}
