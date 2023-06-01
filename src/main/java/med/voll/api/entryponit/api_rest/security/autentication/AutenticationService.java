package med.voll.api.entryponit.api_rest.security.autentication;

import med.voll.api.dataprovider.autentication.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public AutenticationService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Passei pelo método loadUserByUserName");
        return usuarioRepository.findByLogin(username);
    }
}
