package application.controller;

import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.model.Questao;
import application.record.QuestaoDTO;
import application.repository.QuestaoRepository;
import application.service.QuestaoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/questao")
public class QuestaoController {
    
    @Autowired
    QuestaoService questaoService;

    @GetMapping
    public Iterable<QuestaoDTO> findAll() {
        return questaoService.findAll();
    }

    @PostMapping
    public QuestaoDTO insert(@RequestBody QuestaoDTO questao) {
        return questaoService.insert(questao);
    }

    @GetMapping("/{id}")
    public QuestaoDTO findOne(@PathVariable long id) {
        QuestaoDTO resultado = new QuestaoDTO(null);
        try {
            resultado = questaoService.findById(id);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException (
                HttpStatus.NOT_FOUND, "Questao não encontrada"
            );
        }

        return questaoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        questaoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public QuestaoDTO update(
        @PathVariable long id,
        @RequestBody QuestaoDTO questao) {
            return questaoService.update(id, questao);
        }


    // @PutMapping("/{id}")
    // public Questao put(@PathVariable long id, @RequestBody Questao novosDados) {
    //     Optional<Questao> resultado = questaoService.findById(id);
        
    //     if (resultado.isEmpty()) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Questao não encontrada");
    //     }

    //     resultado.get().setModelo(novosDados.getModelo());
    //     resultado.get().setMarca(novosDados.getMarca());

    //     return questaoService.save(resultado.get());
    // }

    // @DeleteMapping("/{id}")
    // public void delete(@PathVariable long id) {
    //     if (!questaoService.existsById(id)) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Questao não encontrada");
    //     }

    //     questaoService.deleteById(id);
    // }


} 