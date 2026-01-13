package br.com.biblioteca.model;

import java.time.LocalDateTime;

public class Reserva {
    private int idReserva;
    private LocalDateTime dataSolicitacao;
    private LocalDateTime dataExpiracao;
    private StatusReserva status;
    private Usuario usuario;
    private Exemplar exemplar;

    public Reserva(int idReserva, Usuario usuario, Exemplar exemplar) {
        this.idReserva = idReserva;
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataSolicitacao = LocalDateTime.now();
        this.dataExpiracao = LocalDateTime.now().plusDays(7);
        this.status = StatusReserva.PENDENTE;
    }

    public void cancelarReserva() {
        this.status = StatusReserva.CANCELADA;
    }

    public void confirmarReserva() {
        this.status = StatusReserva.CONFIRMADA;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", dataSolicitacao=" + dataSolicitacao +
                ", dataExpiracao=" + dataExpiracao +
                ", status=" + status +
                ", usuario=" + usuario.getNome() +
                ", exemplar=" + exemplar.getIdExemplar() +
                '}';
    }
}
