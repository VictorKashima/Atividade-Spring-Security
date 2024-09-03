package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.model.Moto;
import application.repository.MotoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/motos")
public class MotoController {
    
    @Autowired
    private MotoRepository motoRepo;

    @GetMapping
    public Iterable<Moto> getAll() {
        return motoRepo.findAll();
    }

    @PostMapping
    public Moto post(@RequestBody Moto moto) {
        return motoRepo.save(moto);
    }

    @GetMapping("/{id}")
    public Moto getOne(@PathVariable long id) {
        Optional<Moto> resultado = motoRepo.findById(id);
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
        }
        return resultado.get();
    }

    @PutMapping("/{id}")
    public Moto put(@PathVariable long id, @RequestBody Moto novosDados) {
        Optional<Moto> resultado = motoRepo.findById(id);
        
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
        }

        resultado.get().setModelo(novosDados.getModelo());
        resultado.get().setMarca(novosDados.getMarca());

        return motoRepo.save(resultado.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        if (!motoRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
        }

        motoRepo.deleteById(id);
    }
    


    
    

}