package main;

import entities.AluguelDoCarro;
import entities.Carro;
import exeception.DataException;
import services.AluguelDeCarroService;
import services.MSImpostoService;
import services.ValidarLocacaoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        AluguelDoCarro aluguelDoCarro;

        try {
            System.out.println("Dados da locação do carrro");
            System.out.println("Modelo do carro");
            String modelo = in.nextLine();
            System.out.println("Placa ");
            String placa = in.nextLine();
            System.out.println("Data da locação (DD/MM/YYY HH:MM)");
            Date dataLocacao = sdf.parse(in.nextLine());
            System.out.println("Data da devolução (DD/MM/YYY HH:MM)");
            Date dataDevolucao = sdf.parse(in.nextLine());

            ValidarLocacaoService.validarDatas(dataLocacao, dataDevolucao);

            aluguelDoCarro = new AluguelDoCarro(dataLocacao, dataDevolucao, new Carro(modelo, placa));

            System.out.println("Valor do aluguel por hora");
            double valorDoAluguelPorHora = in.nextDouble();
            System.out.println("Valor do aluguel por dia");
            double valorDoAluguelPorDia = in.nextDouble();

            AluguelDeCarroService aluguelDeCarroService = new AluguelDeCarroService(valorDoAluguelPorHora, valorDoAluguelPorDia, new MSImpostoService());
            aluguelDeCarroService.processamentoDaFatura(aluguelDoCarro);

            System.out.println("******************************************************");
            System.out.println("Modelo do carro " + aluguelDoCarro.getCarro().getModelo());
            System.out.println("Placa do veiculo " + aluguelDoCarro.getCarro().getPlaca());
            System.out.println("Data da locação : " + sdf.format(aluguelDoCarro.getInicioDaLocacao()));
            System.out.println("Valor do aluguel sem imposto : R$ " + String.format("$ %.2f", aluguelDoCarro.getFatura().getPagamentoBasico()));
            System.out.println("Valor imposto R$ " + String.format("%.2f", aluguelDoCarro.getFatura().getTaxa()));
            System.out.println("Valor a pagar com impostos estaduais R$ " + String.format("%.2f", aluguelDoCarro.getFatura().getPagamentoTotal()));
            System.out.println("******************************************************");
        } catch (ParseException | DataException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

}
