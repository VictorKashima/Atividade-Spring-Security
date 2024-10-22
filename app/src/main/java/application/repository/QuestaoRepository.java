package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

    

}