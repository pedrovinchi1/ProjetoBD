/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projetoapoo.dal;

import java.sql.*;

/**
 *
 * @author yigor
 */
public class ModuloConexao {

    //método responsável por estabelecer a conexão com o banco
    public static Connection conector() {
        java.sql.Connection conexao = null;
        //a linha abaixo "chama" o drive importado nas Dependencies
        String driver = "org.postgresql.Driver";
        //armazenando informações referente ao banco
        String url = "jdbc:postgresql://localhost:5432/dbBD2";
        String user = "postgres";
        String password = "8844";
        //estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //a linha abaixo serve de apoio para esclarecer o erro
            System.out.println(e);
            return null;
        }
    }
}
