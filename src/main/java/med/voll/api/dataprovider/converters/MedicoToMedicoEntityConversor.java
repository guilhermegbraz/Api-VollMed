package med.voll.api.dataprovider.converters;

import med.voll.api.core.entities.medico.Medico;
import med.voll.api.dataprovider.entities.MedicoEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicoToMedicoEntityConversor {

    public  MedicoEntity executar(Medico medico) {
        return new MedicoEntity(medico.getNome(), medico.getEmail().getEndereco(),
                medico.getCRM(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
