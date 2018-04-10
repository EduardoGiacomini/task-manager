/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Scanner;

/**
 *
 * @author eduardo
 */
public class Main {

    public static void main(String[] args) {

        TaskDao actions = new TaskDao();
        Scanner scanner = new Scanner(System.in);

        String task = null, taskReplaceAll = null;
        int option = 0;
        int priority = 0, id = 0;

        while (option != 4) {

            System.out.println("Escolha uma das opções: ");
            System.out.println("'1' - Inserir Tarefa.");
            System.out.println("'2' - Listar Tarefas.");
            System.out.println("'3' - Deletar Tarefa.");
            System.out.println("'4' - Sair.\n");
            System.err.print(">> ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Tarefa: ");
                    task = scanner.nextLine();
                    taskReplaceAll = task.replaceAll(" ", "");
                    if (taskReplaceAll.length() == 0) {
                        System.out.println("Entrada inválida! Operação cancelada.");
                        break;
                    }
                    System.out.println("Prioridade: ");
                    try {
                        priority = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Erro: " + e);
                        System.out.println("Entrada inválida! Operação cancelada.");
                        break;
                    }
                    actions.insert(task, priority);
                    break;
                case 2:
                    actions.select();
                    break;
                case 3:
                    System.out.println("Id: ");
                    try {
                        id = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Erro: " + e);
                        System.out.println("Entrada inválida! Operação cancelada.");
                        break;
                    }
                    actions.delete(id);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
            }
        }
    }
}
