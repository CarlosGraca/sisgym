/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */
public class ManagerDataBase {

    /**
     * @param args the command line arguments
     */
    private String driver = "com.mysql.jdbc.Driver";
    public Connection Conn;
    public Statement s;
    
    public static void main(String[] args) {
        new FormPrincipal().setVisible(true);
    }
    
}
