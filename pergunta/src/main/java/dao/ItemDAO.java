package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Item;

public class ItemDAO {
    
    private Connection con;

    public ItemDAO(Connection con) {
        this.con = con;
    }
    
    public boolean insert (Item item) {
        Boolean responseQuery = false;
        try {
            String sql = "INSERT INTO tb_item (idItem, numeroDeOrdem, idPergunta, tituloItem, idImagemItem, chaveItem, valorDefault)"
                 + " VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setByte(1, item.getIdItem());
            pstm.setByte(2, item.getNumeroDeOrdem());
            pstm.setString(3, item.getIdPergunta());
            pstm.setString(4, item.getTituloItem()); 
            pstm.setString(5, item.getIdImagemItem()); 
            pstm.setString(6, item.getChaveItem()); 
            pstm.setString(7, item.getValorDefault()); 
            pstm.execute();
            responseQuery = true;
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return responseQuery;
    }
    
    public boolean delete (Item item) {
        Boolean responseQuery = false;
        try {
            String sql = "delete from tb_item where numeroDeOrdem=? and idPergunta=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setByte(1, item.getNumeroDeOrdem());
            pstm.setString(2, item.getIdPergunta());
            pstm.execute();
            responseQuery = true;
        }catch(SQLException ex){
            System.out.println(ex);
            responseQuery = false;
        }
        return responseQuery;
    }
    
    public boolean updateIndex (Item item) {
        Boolean responseQuery = false;
        try {
            String sql = "update tb_item set numeroDeOrdem=?, idItem=? where idPergunta='"+item.getIdPergunta()+"' and _id='"+item.getId()+"'";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setByte(1, item.getNumeroDeOrdem());
            pstm.setByte(2, item.getIdItem());
            pstm.execute();
            responseQuery = true;
        }catch(SQLException ex){
            System.out.println(ex);
        }
        System.out.println("Reload itemID: " + item.getId());
        return responseQuery;
    }
    
    public void setCon (Connection con) {
        this.con = con;
    }
    
   
}


