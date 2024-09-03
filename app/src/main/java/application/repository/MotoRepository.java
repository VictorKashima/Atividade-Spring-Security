package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Moto;

public interface MotoRepository extends CrudRepository<Moto, Long> {

}