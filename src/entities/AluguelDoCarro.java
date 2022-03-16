package entities;

import java.util.Date;

public class AluguelDoCarro {

    private Date inicioDaLocacao;
    private Date fimDaLocacao;

    private Carro carro;
    private Fatura fatura;

    public AluguelDoCarro(Date inicioDaLocacao, Date fimDaLocacao, Carro carro) {
        this.inicioDaLocacao = inicioDaLocacao;
        this.fimDaLocacao = fimDaLocacao;
        this.carro = carro;
    }

    public Date getInicioDaLocacao() {
        return inicioDaLocacao;
    }

    public void setInicioDaLocacao(Date inicioDaLocacao) {
        this.inicioDaLocacao = inicioDaLocacao;
    }

    public Date getFimDaLocacao() {
        return fimDaLocacao;
    }

    public void setFimDaLocacao(Date fimDaLocacao) {
        this.fimDaLocacao = fimDaLocacao;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
