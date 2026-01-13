package br.com.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private int idAutor;
    private String nome;
    private List<Livro> livrosEscritos;

    public Autor(int idAutor, String nome) {
        this.idAutor = idAutor;
        this.nome = nome;
        this.livrosEscritos = new ArrayList<>();
    }

    public List<Livro> buscarLivros() {
        return new ArrayList<>(livrosEscritos);
    }

    public void adicionarLivro(Livro livro) {
        if (!livrosEscritos.contains(livro)) {
            livrosEscritos.add(livro);
        }
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivrosEscritos() {
        return livrosEscritos;
    }

    public void setLivrosEscritos(List<Livro> livrosEscritos) {
        this.livrosEscritos = livrosEscritos;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nome='" + nome + '\'' +
                ", livrosEscritos=" + livrosEscritos.size() +
                '}';
    }
}
