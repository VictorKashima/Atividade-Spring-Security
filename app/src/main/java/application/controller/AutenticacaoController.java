package application.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Piloto;
import application.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody Piloto piloto) {
        UsernamePasswordAuthenticationToken token =
            new UsernamePasswordAuthenticationToken(piloto.getNome(), piloto.getEquipe());
        Authentication authentication = authManager.authenticate(token);

        return tokenService.generateToken(piloto);
    }
}