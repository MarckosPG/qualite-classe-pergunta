package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Item;
import models.Pergunta;

public class PerguntaDAO {
    
    private Connection con;

    public PerguntaDAO(Connection con) {
        this.con = con;
    }

    public boolean insert (Pergunta pergunta) {
        Boolean responseQuery = false;
        try {
            String sql = "INSERT INTO tb_pergunta (idPergunta,idCliente,identificadorResposta,tituloResposta,explicacaoPergunta,explicacaoOcultaPergunta,idImagemTituloPergunta,lgpdPergunta,salvoPergunta)"
                 + " VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, pergunta.getIdPergunta());
            pstm.setString(2, pergunta.getIdCliente());
            pstm.setString(3, pergunta.getIdentificadorResposta());
            pstm.setString(4, pergunta.getTitulo()); 
            pstm.setString(5, pergunta.getExplicacao()); 
            pstm.setString(6, String.valueOf(pergunta.getExplicacaoOculta())); 
            pstm.setString(7, pergunta.getIdImagemTitulo()); 
            pstm.setString(8, String.valueOf(pergunta.getLGPD())); 
            pstm.setBoolean(9, pergunta.isSalvo()); 
            pstm.execute();
            responseQuery = true;
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return responseQuery;
    }
    
    public List<String> loadItemChaves (Pergunta pergunta) {
        List<String> items = new ArrayList();
         try {
            String sql = "select * from tb_item where idPergunta='"+pergunta.getIdPergunta()+"'";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(sql);
            while (rs.next()) {
                String chaveItem =  rs.getString("chaveItem");
                items.add(chaveItem);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        System.out.println("Lista chaves iniciada, tamanho: " + items.size());
        return items;
    }
    public List<String> loadItemChaves (String perguntaID) {
        List<String> items = new ArrayList();
         try {
            String sql = "select * from tb_item where idPergunta='"+perguntaID+"'";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(sql);
            while (rs.next()) {
                String chaveItem =  rs.getString("chaveItem");
                items.add(chaveItem);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        System.out.println("Lista chaves iniciada, tamanho: " + items.size());
        return items;
    }
    
    public List<Item> loadItems (Pergunta pergunta) {
        List<Item> items = new ArrayList();
        try {
            String sql = "select * from tb_item where idPergunta='"+pergunta.getIdPergunta()+"'";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(sql);
            while (rs.next()) {
                long id= rs.getLong("_id");
                int idItem = rs.getInt("idItem");
                int numeroDeOrdem = rs.getByte("numeroDeOrdem");
                String idPergunta = rs.getString("idPergunta");
                String tituloItem =  rs.getString("tituloItem");
                String idImagemItem =  rs.getString("idImagemItem");
                String chaveItem =  rs.getString("chaveItem");
                String valorDefault =  rs.getString("valorDefault");
                Item item = new Item(
                     id,
                    (byte) idItem,
                    (byte) numeroDeOrdem,
                    idPergunta,
                    tituloItem,
                    idImagemItem,
                    chaveItem,
                    valorDefault,
                    true,
                    con
                );
                items.add(item);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        System.out.println("Lista itens iniciada, tamanho: " + items.size());
        return items;
    }
    public List<Item> loadItems (String perguntaID) {
        List<Item> items = new ArrayList();
        try {
            String sql = "select * from tb_item where idPergunta='"+perguntaID+"'";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(sql);
            while (rs.next()) {
                long  id= rs.getLong("_id");
                int idItem = rs.getInt("idItem");
                int numeroDeOrdem = rs.getByte("numeroDeOrdem");
                String idPergunta = rs.getString("idPergunta");
                String tituloItem =  rs.getString("tituloItem");
                String idImagemItem =  rs.getString("idImagemItem");
                String chaveItem =  rs.getString("chaveItem");
                String valorDefault =  rs.getString("valorDefault");
                Item item = new Item(
                     id,
                    (byte) idItem,
                    (byte) numeroDeOrdem,
                    idPergunta,
                    tituloItem,
                    idImagemItem,
                    chaveItem,
                    valorDefault,
                    true,
                    con
                );
                items.add(item);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        System.out.println("Lista itens iniciada, tamanho: " + items.size());
        return items;
    }
    
    public long loadMaxLastIdItem () {
        long _id = 0;
        try {
            String sql = "select * from tb_item ORDER BY _id DESC LIMIT 1";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(sql);
            while (rs.next()) {
               _id =  rs.getLong("_id");
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        System.out.println("item _id: " + _id);
        return _id;
    }
    
    public void setCon (Connection con) {
        this.con = con;
    }
    
}
