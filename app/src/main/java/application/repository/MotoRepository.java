package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long> {

    public Moto findByModelo(String modelo);

}