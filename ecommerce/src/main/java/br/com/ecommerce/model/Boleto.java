package main.java.br.com.ecommerce.model;

import java.util.Date;

public class Boleto extends Pagamento{
    private String codigoBarras;

    private Date dataVencimento;

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
