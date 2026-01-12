package main.java.br.com.ecommerce.model;

import java.util.Date;

public abstract class Pagamento {
    private Date dataPagamento;

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
