package br.com.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String isbn;
    private String titulo;
    private int anoPublicacao;
    private List<Autor> autores;
    private Editora editora;
    private List<Exemplar> exemplares;

    public Livro(String isbn, String titulo, int anoPublicacao, Editora editora) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.autores = new ArrayList<>();
        this.exemplares = new ArrayList<>();
        
        // Adiciona o livro à editora
        editora.adicionarLivro(this);
    }

    public void adicionarAutor(Autor autor) {
        if (!autores.contains(autor)) {
            autores.add(autor);
            autor.adicionarLivro(this);
        }
    }

    public void adicionarExemplar(Exemplar exemplar) {
        if (!exemplares.contains(exemplar)) {
            exemplares.add(exemplar);
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", autores=" + autores.size() +
                ", editora=" + editora.getNome() +
                ", exemplares=" + exemplares.size() +
                '}';
    }
}
