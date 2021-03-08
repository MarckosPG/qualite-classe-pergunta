package main;

import components.PerguntaBuilder;
import dao.PerguntaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Item;

public class Main {
    
    public static void main (String[] args) {
        
        PerguntaBuilder pergunta1 = new PerguntaBuilder (
                "01252552144549",
                "15455254586588",
                "identificador",
                "titulo",
                "explicacao",
                '0',
                "imagem",
                '0',
                false,
                getConnection()
        );
        
        PerguntaBuilder pergunta2 = new PerguntaBuilder (
                "45234234424234",
                "15455254586588",
                "identificador",
                "titulo",
                "explicacao",
                '0',
                "imagem",
                '0',
                false,
                getConnection()
        );
        
        pergunta1.loadAsyncDbItems(); //iniciar banco de dados da pergunta
        pergunta2.loadAsyncDbItems(); //iniciar banco de dados da pergunta
        
        Item item1 = new Item (
                pergunta1.COUNTER_ITEMS_ID,
                (byte)pergunta1.getItems().size(),
                (byte)pergunta1.getItems().size(),
                "01252552144549",
                "tituloItem",
                "idImagemItem",
                "chaveItem2",
                "valorDefault",
                false,
                getConnection()
        );
        
        Item item2 = new Item (
                pergunta1.COUNTER_ITEMS_ID,
                (byte)pergunta2.getItems().size(),
                (byte)pergunta2.getItems().size(),
                "01252552144549",
                "tituloItem",
                "idImagemItem",
                "chaveItem1",
                "valorDefault",
                false,
                getConnection()
        );
        
        Item item3 = new Item (
                pergunta1.COUNTER_ITEMS_ID,
                (byte)pergunta2.getItems().size(),
                (byte)pergunta2.getItems().size(),
                "01252552144549",
                "tituloItem",
                "idImagemItem",
                "dasdasdd",
                "valorDefault",
                false,
                getConnection()
        );
        
        Item item4 = new Item (
                pergunta2.COUNTER_ITEMS_ID,
                (byte)pergunta2.getItems().size(),
                (byte)pergunta2.getItems().size(),
                "45234234424234",
                "tituloItem",
                "idImagemItem",
                "dasdasdsaddd",
                "valorDefault",
                false,
                getConnection()
        );
        
        Item item5 = new Item (
                pergunta2.COUNTER_ITEMS_ID,
                (byte)pergunta2.getItems().size(),
                (byte)pergunta2.getItems().size(),
                "45234234424234",
                "tituloItem",
                "idImagemItem",
                "3421333",
                "valorDefault",
                false,
                getConnection()
        );
        
        pergunta1.addItem(item1);
        pergunta1.addItem(item2);
        pergunta1.addItem(item3);
        
        pergunta2.addItem(item4);
        pergunta2.addItem(item5);
        
        pergunta1.salvar();
        pergunta2.salvar();
        //pergunta.removeItem((byte) 1);
        
        //pergunta.moveItem((byte) 0, (byte) 2);
        
        for(Item i : pergunta1.getItems()){
            System.out.println("Pergunta1: "+i.getId()+", "+i.getChaveItem()+", "+i.getNumeroDeOrdem());
        }
         
        for(Item i : pergunta2.getItems()){
            System.out.println("Pergunta2: "+i.getId()+", "+i.getChaveItem()+", "+i.getNumeroDeOrdem());
        }
        
    }
    
    public static Connection getConnection () {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qualite_db", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
