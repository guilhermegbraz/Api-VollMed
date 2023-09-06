package med.voll.api.dataprovider.medico;



import med.voll.api.core.entities.Endereco;
import med.voll.api.dataprovider.entities.MedicoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface JpaMedicoRepository extends JpaRepository<MedicoEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Medico m SET m.nome = :nomeNovo, m.telefone = :telefoneNovo, m.endereco = :enderecoNovo WHERE m.id = :id")
    void update(@Param("nomeNovo") String nome, @Param("telefoneNovo") String telefone,
                @Param("enderecoNovo") Endereco endereco, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Medico m SET m.flagAtivo = false WHERE m.id = :id")
    void logicalDeleteById( @Param("id") Long id);

    Page<MedicoEntity> findAllByFlagAtivoTrue(Pageable pageable);

    Optional<MedicoEntity> findByIdAndFlagAtivoTrue(Long aLong);
}
