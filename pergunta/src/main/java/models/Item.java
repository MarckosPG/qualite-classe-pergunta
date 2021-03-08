package models;

import dao.ItemDAO;
import java.sql.Connection;

public class Item {
    
    private long _id;
    private byte idItem;
    private byte numeroDeOrdem;
    private String idPergunta;
    private String tituloItem;
    private String idImagemItem;
    private String chaveItem;
    private String valorDefault;
    private boolean salvo;
    private ItemDAO dao;
    private Connection con;
    
    public Item () {}

    public Item(long _id, byte idItem, byte numeroDeOrdem, String idPergunta, String tituloItem, String idImagemItem, String chaveItem, String valorDefault, boolean salvo, Connection con) {
        this._id = _id;
        this.idItem = idItem;
        this.numeroDeOrdem = numeroDeOrdem;
        this.idPergunta = idPergunta;
        this.tituloItem = tituloItem;
        this.idImagemItem = idImagemItem;
        this.chaveItem = chaveItem;
        this.valorDefault = valorDefault;
        this.salvo = salvo;
        this.dao = new ItemDAO(con);
        this.con = con;
    }
    
    public boolean salvar () {
        salvo = true;
        return dao.insert(this);
    }
    
    public boolean remove () {
        return dao.delete(this);
    }
    
    public boolean updateIndex () {
        return dao.updateIndex(this);
    }

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }
    
    
    
    public byte getIdItem() {
        return idItem;
    }

    public void setIdItem(byte idItem) {
        this.idItem = idItem;
    }

    public byte getNumeroDeOrdem() {
        return numeroDeOrdem;
    }

    public void setNumeroDeOrdem(byte numeroDeOrdem) {
        this.numeroDeOrdem = numeroDeOrdem;
    }

    public String getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(String idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getTituloItem() {
        return tituloItem;
    }

    public void setTituloItem(String tituloItem) {
        this.tituloItem = tituloItem;
    }

    public String getIdImagemItem() {
        return idImagemItem;
    }

    public void setIdImagemItem(String idImagemItem) {
        this.idImagemItem = idImagemItem;
    }

    public String getChaveItem() {
        return chaveItem;
    }

    public void setChaveItem(String chaveItem) {
        this.chaveItem = chaveItem;
    }

    public String getValorDefault() {
        return valorDefault;
    }

    public void setValorDefault(String valorDefault) {
        this.valorDefault = valorDefault;
    }

    public ItemDAO getDao() {
        return dao;
    }

    public void setDao(ItemDAO dao) {
        this.dao = dao;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public boolean isSalvo() {
        return salvo;
    }

    public void setSalvo(boolean salvo) {
        this.salvo = salvo;
    }
    
    

}
