package med.voll.api.core.entities.usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Usuario {
    private Long id;
    private String username;
    private String password;
}
