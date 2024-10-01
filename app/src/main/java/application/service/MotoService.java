package application.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Moto;
import application.repository.MotoRepository;
import application.record.MotoDTO;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepo;

    public Iterable<MotoDTO> findAll() {
        return motoRepo.findAll().stream().map(MotoDTO::new).toList();
    }

    public MotoDTO insert(MotoDTO moto) {
        Moto nova = motoRepo.save(new Moto(moto));
        return new MotoDTO(nova);
    }

    public MotoDTO findById(long id) {
        Optional<Moto> resultado = motoRepo.findById(id);
        
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
        }
        
        return new MotoDTO(resultado.get());
    }

    public void deleteById(long id) {
        if(!motoRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
        }

        motoRepo.deleteById(id);
    }

    public MotoDTO update(long id, MotoDTO moto) {
        if(!motoRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada");
        }
        Moto atualizado = motoRepo.save(new Moto(moto));
        return new MotoDTO(atualizado);

    }

}