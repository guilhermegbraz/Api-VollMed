package med.voll.api.core.usecases.medico;

import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.entities.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarDadosMedico {

    @Autowired
    MedicoRepository repositorio;

    public void executar(AtualizavelMedico dados) {
        Medico medico = repositorio.recuperarUmMedico(dados.getId());

        if(dados.getEndereco() != null) medico.setEndereco(dados.getEndereco());

        if(dados.getNome() != null) medico.setNome(dados.getNome());

        if(dados.getTelefone() != null) medico.setTelefone(dados.getTelefone());

        this.repositorio.atualizar(medico);
    }
}
