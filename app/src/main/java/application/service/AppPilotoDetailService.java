package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.model.Piloto;
import application.repository.PilotoRepository;

@Service
public class AppPilotoDetailService implements UserDetailsService {
    @Autowired
    private PilotoRepository pilotoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Piloto piloto = pilotoRepo.findByNome(username);
        if(piloto == null) {
            throw new UsernameNotFoundException("Usuário Não Encontrado");
        }
        UserDetails detalhesDoUsuario = 
            org.springframework.security.core.userdetails.User.builder()
                .username(piloto.getNome())
                .password(piloto.getEquipe())
                .roles("USER")
                .build();

        return detalhesDoUsuario;
    }
    
}