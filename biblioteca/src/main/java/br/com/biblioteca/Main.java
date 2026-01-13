package br.com.biblioteca;

import br.com.biblioteca.model.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Biblioteca ===\n");

        // 1. Criar uma editora
        System.out.println("1. Criando editora");
        Editora editoraCN = new Editora(1, "Editora Coelho Neto");
        System.out.println("Editora criada: " + editoraCN.getNome() + "\n");

        // 2. Criar autores
        System.out.println("2. Criando autores");
        Autor autorDiogo = new Autor(1, "Diogo Vinicius");
        Autor autorAlan = new Autor(2, "Francisco Alan");
        System.out.println("Autores criados: " + autorDiogo.getNome() + ", " + autorAlan.getNome() + "\n");

        // 3. Criar livros
        System.out.println("3. Criando livros");
        Livro livro1 = new Livro("978-8535908685", "SR modernos", 2025, editoraCN);
        livro1.adicionarAutor(autorDiogo);

        Livro livro2 = new Livro("978-8520935378", "Redes de Computadores para Leigos", 2025, editoraCN);
        livro2.adicionarAutor(autorAlan);

        System.out.println("Livros criados:");
        System.out.println("Livro 1: " + livro1.getTitulo() + " (" + livro1.getAnoPublicacao() + ")");
        System.out.println("Livro 2: " + livro2.getTitulo() + " (" + livro2.getAnoPublicacao() + ")\n");

        // 4. Criar biblioteca
        System.out.println("4. Criando biblioteca");
        Biblioteca bibliotecaCentral = new Biblioteca(1, "Biblioteca do IFMA", "Rua não sei o nome , 123 - Saida da cidade");
        System.out.println("Biblioteca criada: " + bibliotecaCentral.getNome() + "\n");

        // 5. Criar exemplares
        System.out.println("5. Criando exemplares");
        Exemplar exemplar1 = new Exemplar(1, livro1, bibliotecaCentral);
        Exemplar exemplar2 = new Exemplar(2, livro1, bibliotecaCentral);
        Exemplar exemplar3 = new Exemplar(3, livro2, bibliotecaCentral);

        System.out.println(bibliotecaCentral.getExemplares().size() + " exemplares adicionados à biblioteca");
        System.out.println("Exemplares disponíveis: " + bibliotecaCentral.listarExemplaresDisponiveis().size() + "\n");

        // 6. Criar usuário
        System.out.println("6. Criando usuário");
        Usuario usuario1 = new Usuario(1, "Davi Cruz", "davicruz@email.com");
        System.out.println("Usuário criado: " + usuario1.getNome() + " (" + usuario1.getEmail() + ")\n");

        // 7. Fazer uma reserva
        System.out.println("7. Fazendo reserva");
        Reserva reserva1 = usuario1.fazerReserva(exemplar1);
        System.out.println("Reserva #" + reserva1.getIdReserva() + " criada");
        System.out.println("Status: " + reserva1.getStatus());
        System.out.println("Data de solicitação: " + reserva1.getDataSolicitacao());
        System.out.println("Data de expiração: " + reserva1.getDataExpiracao() + "\n");

        // 8. Confirmar reserva
        System.out.println("8. Confirmando reserva");
        reserva1.confirmarReserva();
        System.out.println("Status atualizado: " + reserva1.getStatus() + "\n");

        // 9. Realizar empréstimo
        System.out.println("9. Realizando empréstimo");
        Emprestimo emprestimo1 = usuario1.realizarEmprestimo(exemplar1);
        System.out.println("Empréstimo #" + emprestimo1.getIdEmprestimo() + " realizado");
        System.out.println("Data de retirada: " + emprestimo1.getDataRetirada());
        System.out.println("Exemplar disponível: " + exemplar1.isDisponivel() + "\n");

        // 10. Verificar exemplares disponíveis
        System.out.println("10. Verificando exemplares disponíveis");
        List<Exemplar> exemplaresDisponiveis = bibliotecaCentral.listarExemplaresDisponiveis();
        System.out.println("Exemplares disponíveis agora: " + exemplaresDisponiveis.size());
        for (Exemplar ex : exemplaresDisponiveis) {
            System.out.println("- Exemplar #" + ex.getIdExemplar() + ": " + ex.getLivro().getTitulo());
        }
        System.out.println();

        // 11. Tentar emprestar exemplar já emprestado
        System.out.println("11. Tentando emprestar exemplar já emprestado");
        try {
            Emprestimo emprestimoErro = usuario1.realizarEmprestimo(exemplar1);
        } catch (IllegalStateException e) {
            System.out.println("Erro capturado: " + e.getMessage() + "\n");
        }

        // 12. Realizar empréstimo de outro exemplar
        System.out.println("12. Realizando empréstimo de exemplar disponível");
        Emprestimo emprestimo2 = usuario1.realizarEmprestimo(exemplar3);
        System.out.println("Empréstimo #" + emprestimo2.getIdEmprestimo() + " realizado com sucesso");
        System.out.println("Livro: " + exemplar3.getLivro().getTitulo() + "\n");

        // 13. Registrar devolução
        System.out.println("13. Registrando devolução do primeiro empréstimo");
        emprestimo1.registrarDevolucao();
        System.out.println("Devolução registrada em: " + emprestimo1.getDataDevolucao());
        System.out.println("Exemplar devolvido: " + emprestimo1.isDevolvido());
        System.out.println("Exemplar disponível: " + exemplar1.isDisponivel() + "\n");

        // 14. Listar livros do autor
        System.out.println("14. Listando livros de "+autorDiogo.getNome());
        List<Livro> livrosDiogo = autorDiogo.buscarLivros();
        System.out.println("Total de livros: " + livrosDiogo.size());
        for (Livro livro : livrosDiogo) {
            System.out.println("- " + livro.getTitulo() + " (" + livro.getAnoPublicacao() + ")");
        }
        System.out.println();

    }
}
