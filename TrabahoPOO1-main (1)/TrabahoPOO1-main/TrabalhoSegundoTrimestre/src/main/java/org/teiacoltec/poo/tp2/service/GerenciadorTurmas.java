package org.teiacoltec.poo.tp2.service;

import org.teiacoltec.poo.tp2.model.Turma;
import org.teiacoltec.poo.tp2.util.UtilData;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GerenciadorTurmas {
    private List<Turma> turmas;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public GerenciadorTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public void listar() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            for (Turma t : turmas) {
                System.out.println(t.obterInformacoes());
            }
        }
    }
    
    public void adicionar(Scanner sc) {
        System.out.print("Nome da turma: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        System.out.print("Data início (dd-MM-aaaa): ");
        Date inicio = UtilData.lerData(sc);
        System.out.print("Data fim (dd-MM-aaaa): ");
        Date fim = UtilData.lerData(sc);
        Turma turma = new Turma(turmas.size()+1, nome, desc, inicio, fim, null);
        turmas.add(turma);
        System.out.println("Turma adicionada!");
    }
    
    public void remover(Scanner sc) {
        System.out.print("ID da turma: ");
        int id = sc.nextInt();
        sc.nextLine();
        turmas.removeIf(t -> t.getId() == id);
        System.out.println("Turma removida!");
    }
    
    public void editar(Scanner sc) {
        System.out.print("ID da turma a editar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        Turma turma = null;
        for (Turma t : turmas) {
            if (t.getId() == id) {
                turma = t;
                break;
            }
        }
        
        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return;
        }
        
        System.out.println("Turma encontrada: " + turma.obterInformacoes());
        System.out.println("Deixe em branco para manter o valor atual");
        
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        if (!nome.trim().isEmpty()) {
            turma.setNome(nome);
        }
        
        System.out.print("Nova descrição: ");
        String desc = sc.nextLine();
        if (!desc.trim().isEmpty()) {
            turma.setDescricao(desc);
        }
        
        System.out.print("Nova data início (dd-MM-aaaa): ");
        String dataInicio = sc.nextLine();
        if (!dataInicio.trim().isEmpty()) {
            try {
                Date inicio = sdf.parse(dataInicio);
                turma.setInicio(inicio);
            } catch (ParseException e) {
                System.out.println("Data inválida! Mantendo data atual.");
            }
        }
        
        System.out.print("Nova data fim (dd-MM-aaaa): ");
        String dataFim = sc.nextLine();
        if (!dataFim.trim().isEmpty()) {
            try {
                Date fim = sdf.parse(dataFim);
                turma.setFim(fim);
            } catch (ParseException e) {
                System.out.println("Data inválida! Mantendo data atual.");
            }
        }
        
        System.out.println("Turma editada com sucesso!");
    }
} 