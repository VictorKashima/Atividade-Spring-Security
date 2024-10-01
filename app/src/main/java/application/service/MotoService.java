package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Moto;
import application.repository.MotoRepository;
import application.record.MotoDTO;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepo;

    public Iterable<Moto> findAll() {
        return motoRepo.findAll();
    }

    public Moto insert(MotoDTO moto) {
        return motoRepo.save(new Moto(moto));
    }

}