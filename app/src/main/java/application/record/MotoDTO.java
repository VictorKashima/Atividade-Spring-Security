package application.record;

import application.model.Moto;

public record MotoDTO(long id, String modelo,  String marca) {
    
    public MotoDTO(Moto moto) {
        this(moto.getId(), moto.getModelo(), moto.getMarca());
    }
    
}