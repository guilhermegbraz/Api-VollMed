package med.voll.api.dataprovider.medico;


import med.voll.api.dataprovider.entities.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaMedicoRepository extends JpaRepository<MedicoEntity, Long> {


}
