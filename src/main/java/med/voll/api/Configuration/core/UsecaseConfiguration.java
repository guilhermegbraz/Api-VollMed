package med.voll.api.Configuration.core;

import med.voll.api.core.entities.medico.MedicoRepository;
import med.voll.api.core.usecases.medico.AtualizarDadosMedico;
import med.voll.api.core.usecases.medico.CadastroDeMedico;
import med.voll.api.core.usecases.medico.DeletarMedico;
import med.voll.api.core.usecases.validação.medico.ValidadorCadastroMedico;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsecaseConfiguration {
    @Bean
    public CadastroDeMedico cadastroDeMedico(MedicoRepository medicoRepo,
                                             List<ValidadorCadastroMedico> validadorCadastroMedicoList) {
        return new CadastroDeMedico(medicoRepo, validadorCadastroMedicoList);
    }

    @Bean
    public DeletarMedico deletarMedico(MedicoRepository medicoRepository) {
        return new DeletarMedico(medicoRepository);
    }

    @Bean public AtualizarDadosMedico atualizarDadosMedico(MedicoRepository medicoRepository) {
        return new AtualizarDadosMedico(medicoRepository);
    }
}
