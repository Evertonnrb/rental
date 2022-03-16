package services;

import entities.AluguelDoCarro;
import entities.Fatura;
import interfaces.ImpostosService;

public class AluguelDeCarroService {

    private Double precoPorHora;
    private Double precoDia;

    private ImpostosService impostoService;

    public AluguelDeCarroService(Double precoPorHora, Double precoDia, ImpostosService msImpostoService) {
        this.precoPorHora = precoPorHora;
        this.precoDia = precoDia;
        this.impostoService = msImpostoService;
    }

    public void processamentoDaFatura(AluguelDoCarro aluguelDoCarro) {
        double pagamentoBase;

        long t1 = aluguelDoCarro.getInicioDaLocacao().getTime();
        long t2 = aluguelDoCarro.getFimDaLocacao().getTime();

        double horas = (double)(t2 - t1) / 1000 / 60 / 60;

        if (horas <= 12.0) {
            pagamentoBase = Math.ceil(horas) * precoPorHora;
        }else{
            pagamentoBase = Math.ceil(horas / 24) * precoDia;
        }

        double imposto = impostoService.impostoSobreALocacao(pagamentoBase);

        aluguelDoCarro.setFatura(new Fatura(pagamentoBase, imposto));
    }


}
