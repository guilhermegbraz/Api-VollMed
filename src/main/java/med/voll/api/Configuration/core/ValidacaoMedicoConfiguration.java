package med.voll.api.Configuration.core;

import med.voll.api.core.usecases.validação.medico.ValidarEmailNotNull;
import med.voll.api.core.usecases.validação.medico.ValidarNomeNotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidacaoMedicoConfiguration {
    @Bean
    public ValidarEmailNotNull validarEmailNotNull() {
        return new ValidarEmailNotNull();
    }

    @Bean
    public ValidarNomeNotNull validarNomeNotNull() {
        return new ValidarNomeNotNull();
    }
}
