package org.teiacoltec.poo.tp2.service;

import org.teiacoltec.poo.tp2.model.Atividade;
import org.teiacoltec.poo.tp2.util.UtilData;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GerenciadorAtividades {
    private List<Atividade> atividades;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public GerenciadorAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
    
    public void listar() {
        if (atividades.isEmpty()) {
            System.out.println("Nenhuma atividade cadastrada.");
        } else {
            for (Atividade a : atividades) {
                System.out.println(a.obterInformacoes());
            }
        }
    }
    
    public void adicionar(Scanner sc) {
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("Descrição: "); String desc = sc.nextLine();
        System.out.print("Data início (dd-MM-aaaa): "); Date inicio = UtilData.lerData(sc);
        System.out.print("Data fim (dd-MM-aaaa): "); Date fim = UtilData.lerData(sc);
        System.out.print("Valor: "); float valor = sc.nextFloat(); sc.nextLine();
        Atividade a = new Atividade(atividades.size()+1, nome, desc, inicio, fim, valor);
        atividades.add(a);
        System.out.println("Atividade adicionada!");
    }
    
    public void remover(Scanner sc) {
        System.out.print("ID da atividade: ");
        int id = sc.nextInt();
        sc.nextLine();
        atividades.removeIf(a -> a.getId() == id);
        System.out.println("Atividade removida!");
    }
    
    public void editar(Scanner sc) {
        System.out.print("ID da atividade a editar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        Atividade atividade = null;
        for (Atividade a : atividades) {
            if (a.getId() == id) {
                atividade = a;
                break;
            }
        }
        
        if (atividade == null) {
            System.out.println("Atividade não encontrada!");
            return;
        }
        
        System.out.println("Atividade encontrada: " + atividade.obterInformacoes());
        System.out.println("Deixe em branco para manter o valor atual");
        
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        if (!nome.trim().isEmpty()) {
            atividade.setNome(nome);
        }
        
        System.out.print("Nova descrição: ");
        String desc = sc.nextLine();
        if (!desc.trim().isEmpty()) {
            atividade.setDescricao(desc);
        }
        
        System.out.print("Nova data início (dd-MM-aaaa): ");
        String dataInicio = sc.nextLine();
        if (!dataInicio.trim().isEmpty()) {
            try {
                Date inicio = sdf.parse(dataInicio);
                atividade.setInicio(inicio);
            } catch (ParseException e) {
                System.out.println("Data inválida! Mantendo data atual.");
            }
        }
        
        System.out.print("Nova data fim (dd-MM-aaaa): ");
        String dataFim = sc.nextLine();
        if (!dataFim.trim().isEmpty()) {
            try {
                Date fim = sdf.parse(dataFim);
                atividade.setFim(fim);
            } catch (ParseException e) {
                System.out.println("Data inválida! Mantendo data atual.");
            }
        }
        
        System.out.print("Novo valor: ");
        String valorStr = sc.nextLine();
        if (!valorStr.trim().isEmpty()) {
            try {
                float valor = Float.parseFloat(valorStr);
                atividade.setValor(valor);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Mantendo valor atual.");
            }
        }
        
        System.out.println("Atividade editada com sucesso!");
    }
} 