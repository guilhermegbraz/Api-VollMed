package med.voll.api.dataprovider.medico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class JpaMedicoRepositoryTest {
    @Autowired
    private JpaMedicoRepository medicoRepository;

    @Test
    @DisplayName("Deve fazer uma exclusão lógica, setando um atributo, que indica se o registro" +
            " esta ativo, para false")
    void logicalDeleteById() {
        this.medicoRepository.logicalDeleteById(1L);
        var medico = this.medicoRepository.findById(1L);
        assertTrue(medico.isEmpty());
    }
}