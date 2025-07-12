package org.teiacoltec.poo.tp2.service;

import org.teiacoltec.poo.tp2.model.*;
import org.teiacoltec.poo.tp2.util.UtilData;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GerenciadorPessoas {
    private List<Pessoa> pessoas;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public GerenciadorPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    public void listar() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (Pessoa p : pessoas) {
                System.out.println(p.obterInformacoes());
            }
        }
    }
    
    public void adicionar(Scanner sc) {
        System.out.print("Tipo (1-Professor, 2-Aluno, 3-Monitor): ");
        int tipo = sc.nextInt(); sc.nextLine();
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("CPF: "); String cpf = sc.nextLine();
        System.out.print("Nascimento (dd-MM-aaaa): "); Date nasc = UtilData.lerData(sc);
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Endereço: "); String end = sc.nextLine();
        Pessoa p = null;
        if (tipo == 1) p = new Professor(cpf, nome, nasc, email, end);
        else if (tipo == 2) p = new Aluno(cpf, nome, nasc, email, end);
        else if (tipo == 3) {
            System.out.print("Matrícula: "); String mat = sc.nextLine();
            System.out.print("Curso: "); String curso = sc.nextLine();
            p = new Monitor(cpf, nome, nasc, email, end, mat, curso);
        }
        if (p != null) {
            pessoas.add(p);
            System.out.println("Pessoa adicionada!");
        } else {
            System.out.println("Tipo inválido!");
        }
    }
    
    public void remover(Scanner sc) {
        System.out.print("CPF da pessoa: ");
        String cpf = sc.nextLine();
        pessoas.removeIf(p -> p.getCpf().equals(cpf));
        System.out.println("Pessoa removida!");
    }
    
    public void editar(Scanner sc) {
        System.out.print("CPF da pessoa a editar: ");
        String cpf = sc.nextLine();
        
        Pessoa pessoa = null;
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpf)) {
                pessoa = p;
                break;
            }
        }
        
        if (pessoa == null) {
            System.out.println("Pessoa não encontrada!");
            return;
        }
        
        System.out.println("Pessoa encontrada: " + pessoa.obterInformacoes());
        System.out.println("Deixe em branco para manter o valor atual");
        
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        if (!nome.trim().isEmpty()) {
            pessoa.setNome(nome);
        }
        
        System.out.print("Nova data de nascimento (dd-MM-aaaa): ");
        String dataNasc = sc.nextLine();
        if (!dataNasc.trim().isEmpty()) {
            try {
                Date nasc = sdf.parse(dataNasc);
                pessoa.setNascimento(nasc);
            } catch (ParseException e) {
                System.out.println("Data inválida! Mantendo data atual.");
            }
        }
        
        System.out.print("Novo email: ");
        String email = sc.nextLine();
        if (!email.trim().isEmpty()) {
            pessoa.setEmail(email);
        }
        
        System.out.print("Novo endereço: ");
        String endereco = sc.nextLine();
        if (!endereco.trim().isEmpty()) {
            pessoa.setEndereco(endereco);
        }
        
        System.out.println("Pessoa editada com sucesso!");
    }
} 