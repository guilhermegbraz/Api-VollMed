package med.voll.api.dataprovider.converters;

import med.voll.api.core.entities.Email;
import med.voll.api.core.entities.medico.Medico;
import med.voll.api.dataprovider.entities.MedicoEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicoEntityToMedicoConversor {

    public Medico executar(MedicoEntity medico) {
        return new Medico(medico.getId(), medico.getNome(), new Email(medico.getEmail()),
                medico.getCRM(), medico.getTelefone(),medico.getEspecialidade(),medico.getEndereco());
    }
}
