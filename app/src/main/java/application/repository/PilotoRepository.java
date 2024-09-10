package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Piloto;

public interface PilotoRepository extends CrudRepository<Piloto, Long> {

    public Piloto findByNome(String nome);

}