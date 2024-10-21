package application.record;

import application.model.Questao;

public record QuestaoDTO(long id, String enunciado) {
    
    public QuestaoDTO(Questao questao) {
        this(questao.getId(), questao.getEnunciado());
    }
    
}