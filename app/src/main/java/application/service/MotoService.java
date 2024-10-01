package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Moto;
import application.repository.MotoRepository;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepo;

    public Iterable<Moto> findAll() {
        return motoRepo.findAll();
    }

    public Moto insert(Moto moto) {
        return motoRepo.save(moto);
    }

}