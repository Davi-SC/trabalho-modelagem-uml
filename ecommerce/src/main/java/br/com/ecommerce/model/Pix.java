package main.java.br.com.ecommerce.model;

import java.util.Date;

public class Pix extends Pagamento{
    private String chavePix;

    public Pix(String chavePix, Date dataPagamento) {
        this.chavePix = chavePix;
        this.setDataPagamento(dataPagamento);
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
