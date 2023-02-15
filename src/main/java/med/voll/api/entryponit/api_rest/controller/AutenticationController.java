package med.voll.api.entryponit.api_rest.controller;

import med.voll.api.entryponit.api_rest.model.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    private final AuthenticationManager manager;

    public AutenticationController(AuthenticationManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody LoginDTO loginDTO) {
        var tolken = new UsernamePasswordAuthenticationToken(loginDTO.login(), loginDTO.password());
        var authentication = manager.authenticate(tolken);


        return ResponseEntity.ok().build();
    }
}
