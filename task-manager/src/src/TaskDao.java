/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eduardo
 */
public class TaskDao {

    private final String sqlInsert = "INSERT INTO tasks (task, priority) VALUES (?, ?)";
    private final String sqlSelect = "SELECT * FROM tasks";
    private String sqlDelete = "DELETE FROM tasks WHERE  id = (?)";

    public void insert(String task, int priority) {
        try {
            Connection conn = DataBase.getConnection();
            PreparedStatement statementInsert = conn.prepareStatement(sqlInsert);
            statementInsert.setString(1, task);
            statementInsert.setInt(2, priority);
            statementInsert.executeUpdate();
            conn.close();
            System.out.println("\nInserção concluída com sucesso!\n");
        } catch (SQLException e) {
            System.out.println("\nErro de SQL: " + e + "\n");
        } catch (Exception e) {
            System.out.println("\nOutro Erro: " + e + "\n");
        }
    }

    public void select() {
        try {
            Connection conn = DataBase.getConnection();
            PreparedStatement statementSelect = conn.prepareStatement(sqlSelect);
            ResultSet result = statementSelect.executeQuery();
            listTasks(result);
            conn.close();
            System.out.println("\nBusca concluída com sucesso!\n");
        } catch (SQLException e) {
            System.out.println("\nErro de SQL: " + e + "\n");
        } catch (Exception e) {
            System.out.println("\nOutro Erro: " + e + "\n");
        }
    }

    public void listTasks(ResultSet result) {
        try {
            System.out.println("\n   id   |   tarefa   |   prioridade   ");
            while (result.next()) {
                System.out.println("   " + result.getInt("id") + "   |   "
                        + "   " + result.getString("task") + "   |   "
                        + "   " + result.getInt("priority"));
            };
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e + "\n");
        } catch (Exception e) {
            System.out.println("Outro Erro: " + e + "\n");
        }
    }

    public void delete(int id) {
        try {
            Connection conn = DataBase.getConnection();
            PreparedStatement statementDelete = conn.prepareStatement(sqlDelete);
            statementDelete.setInt(1, id);
            int result = statementDelete.executeUpdate();
            conn.close();
            if (result == 0) {
                System.out.println("\nErro! O Id inserido não existe.\n");
            } else {
                System.out.println("\nExclução concluída com sucesso! Linhas deletadas: " + result + "\n");
            }
        } catch (SQLException e) {
            System.out.println("\nErro de SQL: " + e + "\n");
        } catch (Exception e) {
            System.out.println("\nOutro Erro: " + e + "\n");
        }
    }
}
