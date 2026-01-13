package br.com.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Editora {
    private int idEditora;
    private String nome;
    private List<Livro> livrosPublicados;

    public Editora(int idEditora, String nome) {
        this.idEditora = idEditora;
        this.nome = nome;
        this.livrosPublicados = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        if (!livrosPublicados.contains(livro)) {
            livrosPublicados.add(livro);
        }
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivrosPublicados() {
        return livrosPublicados;
    }

    public void setLivrosPublicados(List<Livro> livrosPublicados) {
        this.livrosPublicados = livrosPublicados;
    }

    @Override
    public String toString() {
        return "Editora{" +
                "idEditora=" + idEditora +
                ", nome='" + nome + '\'' +
                ", livrosPublicados=" + livrosPublicados.size() +
                '}';
    }
}
