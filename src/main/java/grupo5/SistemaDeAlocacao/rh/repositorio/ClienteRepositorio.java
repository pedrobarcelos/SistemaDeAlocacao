package grupo5.SistemaDeAlocacao.rh.repositorio;

import grupo5.SistemaDeAlocacao.rh.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
