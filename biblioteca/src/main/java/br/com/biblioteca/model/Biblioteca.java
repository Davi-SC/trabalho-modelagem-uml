package br.com.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private int idBiblioteca;
    private String nome;
    private String endereco;
    private List<Exemplar> exemplares;

    public Biblioteca(int idBiblioteca, String nome, String endereco) {
        this.idBiblioteca = idBiblioteca;
        this.nome = nome;
        this.endereco = endereco;
        this.exemplares = new ArrayList<>();
    }

    public void adicionarExemplar(Exemplar exemplar) {
        if (!exemplares.contains(exemplar)) {
            exemplares.add(exemplar);
        }
    }

    public List<Exemplar> listarExemplares() {
        return new ArrayList<>(exemplares);
    }

    public List<Exemplar> listarExemplaresDisponiveis() {
        return exemplares.stream()
                .filter(Exemplar::isDisponivel)
                .collect(Collectors.toList());
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "idBiblioteca=" + idBiblioteca +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", exemplares=" + exemplares.size() +
                '}';
    }
}
