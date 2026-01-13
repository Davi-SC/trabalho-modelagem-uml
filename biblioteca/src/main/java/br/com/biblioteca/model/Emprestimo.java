package br.com.biblioteca.model;

import java.time.LocalDateTime;

public class Emprestimo {
    private int idEmprestimo;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;
    private boolean devolvido;
    private Usuario usuario;
    private Exemplar exemplar;

    public Emprestimo(int idEmprestimo, Usuario usuario, Exemplar exemplar) {
        this.idEmprestimo = idEmprestimo;
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataRetirada = LocalDateTime.now();
        this.dataDevolucao = null;
        this.devolvido = false;
        
        // Adiciona o empréstimo ao histórico do exemplar
        exemplar.adicionarEmprestimo(this);
    }

    public void registrarDevolucao() {
        this.dataDevolucao = LocalDateTime.now();
        this.devolvido = true;
        this.exemplar.marcarComoDisponivel();
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
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
        return "Emprestimo{" +
                "idEmprestimo=" + idEmprestimo +
                ", dataRetirada=" + dataRetirada +
                ", dataDevolucao=" + dataDevolucao +
                ", devolvido=" + devolvido +
                ", usuario=" + usuario.getNome() +
                ", exemplar=" + exemplar.getIdExemplar() +
                '}';
    }
}
