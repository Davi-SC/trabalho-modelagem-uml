package main.java.br.com.ecommerce.model;

import java.util.Date;

public class Cartao extends Pagamento{
    private String numeroCartao;
    private String nomeTitular;
    private Date dataValidade;

    public Cartao(String numeroCartao, String nomeTitular, Date dataValidade, Date dataPagamento) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.setDataPagamento(dataPagamento);
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
}
