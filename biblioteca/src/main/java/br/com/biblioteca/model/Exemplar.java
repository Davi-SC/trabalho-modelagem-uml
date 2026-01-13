package br.com.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Exemplar {
    private int idExemplar;
    private Biblioteca biblioteca;
    private boolean disponivel;
    private List<Emprestimo> emprestimos;
    private Livro livro;

    public Exemplar(int idExemplar, Livro livro, Biblioteca biblioteca) {
        this.idExemplar = idExemplar;
        this.livro = livro;
        this.biblioteca = biblioteca;
        this.disponivel = true;
        this.emprestimos = new ArrayList<>();
        
        // Adiciona o exemplar ao livro e à biblioteca
        livro.adicionarExemplar(this);
        biblioteca.adicionarExemplar(this);
    }

    public void marcarComoEmprestado() {
        this.disponivel = false;
    }

    public void marcarComoDisponivel() {
        this.disponivel = true;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        if (!emprestimos.contains(emprestimo)) {
            emprestimos.add(emprestimo);
        }
    }

    public int getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "idExemplar=" + idExemplar +
                ", disponivel=" + disponivel +
                ", livro=" + livro.getTitulo() +
                ", biblioteca=" + biblioteca.getNome() +
                '}';
    }
}
