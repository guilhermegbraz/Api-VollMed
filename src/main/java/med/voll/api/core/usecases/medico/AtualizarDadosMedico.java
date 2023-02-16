package med.voll.api.core.usecases.medico;

import med.voll.api.core.entities.medico.Medico;
import med.voll.api.core.entities.medico.MedicoRepository;


public class AtualizarDadosMedico {


    private final MedicoRepository repositorio;

    public AtualizarDadosMedico(MedicoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Medico executar(AtualizavelMedico dados) {
        Medico medico = repositorio.recuperarUmMedico(dados.getId());

        if(dados.getEndereco() != null) medico.setEndereco(dados.getEndereco());

        if(dados.getNome() != null) medico.setNome(dados.getNome());

        if(dados.getTelefone() != null) medico.setTelefone(dados.getTelefone());

        this.repositorio.atualizar(medico);

        return medico;
    }
}
