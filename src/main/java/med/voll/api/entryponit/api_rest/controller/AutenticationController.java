package med.voll.api.entryponit.api_rest.controller;

import med.voll.api.dataprovider.autentication.UsuarioEntity;
import med.voll.api.entryponit.api_rest.model.LoginDTO;

import med.voll.api.entryponit.api_rest.security.DadosTokenJWTDto;
import med.voll.api.entryponit.api_rest.security.TokenService;
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
    private final TokenService tokenService;

    public AutenticationController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody LoginDTO loginDTO) {
        var tolken = new UsernamePasswordAuthenticationToken(loginDTO.login(), loginDTO.password());
        var authentication = manager.authenticate(tolken);
        var tokenJWT = tokenService.gerarToken((UsuarioEntity) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWTDto(tokenJWT));
    }
}
