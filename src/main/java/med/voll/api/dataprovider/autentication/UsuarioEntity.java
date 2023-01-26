package med.voll.api.dataprovider.autentication;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.entryponit.api_rest.autentication.Usuario;

@Entity(name = "Usuario")
@Table(schema = "usuarios")
@Getter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;

    public UsuarioEntity(Usuario usuario) {
        this.id = usuario.getId();
        this.senha = usuario.getPassword();
        this.login = usuario.getUsername();
    }
}
