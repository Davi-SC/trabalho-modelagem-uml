package br.com.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private List<Reserva> reservas;
    private List<Emprestimo> emprestimos;

    public Usuario(int idUsuario, String nome, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.reservas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public Reserva fazerReserva(Exemplar exemplar) {
        int novoId = reservas.size() + 1;
        Reserva reserva = new Reserva(novoId, this, exemplar);
        reservas.add(reserva);
        return reserva;
    }

    public Emprestimo realizarEmprestimo(Exemplar exemplar) {
        if (!exemplar.isDisponivel()) {
            throw new IllegalStateException("Exemplar não está disponível para empréstimo");
        }
        
        int novoId = emprestimos.size() + 1;
        Emprestimo emprestimo = new Emprestimo(novoId, this, exemplar);
        emprestimos.add(emprestimo);
        exemplar.marcarComoEmprestado();
        return emprestimo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", reservas=" + reservas.size() +
                ", emprestimos=" + emprestimos.size() +
                '}';
    }
}
