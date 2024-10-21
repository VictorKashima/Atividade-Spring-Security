package application.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Questao;
import application.repository.QuestaoRepository;
import application.record.QuestaoDTO;

@Service
public class QuestaoService {
    @Autowired
    private Questao questaoRepo;

    public Iterable<QuestaoDTO> findAll() {
        return questaoRepo.findAll().stream().map(QuestaoDTO::new).toList();
    }

    public QuestaoDTO insert(QuestaoDTO questao) {
        Questao nova = questaoRepo.save(new Questao(questao));
        return new QuestaoDTO(nova);
    }

    public QuestaoDTO findById(long id) {
        Optional<Questao> resultado = questaoRepo.findById(id);
        
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Questao não encontrada");
        }
        
        return new QuestaoDTO(resultado.get());
    }

    public void deleteById(long id) {
        if(!questaoRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Questao não encontrada");
        }

        questaoRepo.deleteById(id);
    }

    public QuestaoDTO update(long id, QuestaoDTO questao) {
        if(!questaoRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Questao não encontrada");
        }
        Questao atualizado = questaoRepo.save(new Questao(questao));
        return new QuestaoDTO(atualizado);

    }

}