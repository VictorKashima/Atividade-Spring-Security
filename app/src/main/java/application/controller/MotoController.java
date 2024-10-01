package application.controller;

import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.model.Moto;
import application.record.MotoDTO;
import application.repository.MotoRepository;
import application.service.MotoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/moto")
public class MotoController {
    
    @Autowired
    MotoService motoService;

    @GetMapping
    public Iterable<MotoDTO> findAll() {
        return motoService.findAll();
    }

    @PostMapping
    public MotoDTO insert(@RequestBody MotoDTO moto) {
        return motoService.insert(moto);
    }

    @GetMapping("/{id}")
    public MotoDTO findOne(@PathVariable long id) {
        MotoDTO resultado = new MotoDTO(null);
        try {
            resultado = motoService.findById(id);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException (
                HttpStatus.NOT_FOUND, "Moto não encontrada"
            );
        }

        return motoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        motoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MotoDTO update(
        @PathVariable long id,
        @RequestBody MotoDTO moto) {
            return motoService.update(id, moto);
        }

    }

    // @PutMapping("/{id}")
    // public Moto put(@PathVariable long id, @RequestBody Moto novosDados) {
    //     Optional<Moto> resultado = motoService.findById(id);
        
    //     if (resultado.isEmpty()) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
    //     }

    //     resultado.get().setModelo(novosDados.getModelo());
    //     resultado.get().setMarca(novosDados.getMarca());

    //     return motoService.save(resultado.get());
    // }

    // @DeleteMapping("/{id}")
    // public void delete(@PathVariable long id) {
    //     if (!motoService.existsById(id)) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
    //     }

    //     motoService.deleteById(id);
    // }


}