package services;

import interfaces.ImpostosService;

public class MSImpostoService implements ImpostosService {

    @Override
    public double impostoSobreALocacao(double valor) {
        if (valor <= 100.0) {
            return valor * 0.2;
        } else {
            return valor * 0.15;
        }
    }
}
