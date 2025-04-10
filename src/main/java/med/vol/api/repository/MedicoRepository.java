package med.vol.api.repository;

import med.vol.api.models.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query(value = "SELECT m.id, m.nome, m.email, m.especialidade " +
            "FROM medicos m",
            nativeQuery = true)
    List<Object[]> findMedicosRaw();
}
