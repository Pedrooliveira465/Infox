/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.infox.dal;

import java.sql.*;

/**
 *
 * @author Pedro Lucas
 */
public class ModuloConexao {
    // Método responsável por estabelecer a conexão com o banco
    public static Connection conector(){
        java.sql.Connection conexao = null;
        
        // A linha abaixo "chama" o driver de conexão
        String driver = "com.mysql.jdbc.Driver";
        
        // Armazenando informações referente ao banco
        String url = "jdbc:mysql://localhost:3306/dbinfox?characterEncoding=utf-8";
        String user = "dba";
        String password = "Infox@123456";
        
        // Estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            return null;
        }
    }
}
