package clube_campo.model.dependente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import clube_campo.model.associado.Associado;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {
    List<Dependente> findByAssociado(Associado associado);
}