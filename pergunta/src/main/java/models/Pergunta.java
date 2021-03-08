package models;

import dao.PerguntaDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lgpd.LGPDTratamento;
import lgpd.LGPDMotivo;
import lgpd.LGPDBaseLegal;

public abstract class Pergunta {
    
    public long COUNTER_ITEMS_ID = 0;
    
    private String idPergunta;
    private String idCliente;
    private String identificadorResposta;
    private String titulo;
    private String explicacao;
    private char explicacaoOculta;
    private String idImagemTitulo;
    private List<Item> items;
    private char LGPD;
    private LGPDBaseLegal baseLegal;
    private LGPDMotivo motivo;
    private LGPDTratamento tratamento;
    private boolean salvo;
    private PerguntaDAO dao;
    private Connection con;

    public Pergunta(String idPergunta, String idCliente, String identificadorResposta, String titulo, String explicacao, char explicacaoOculta, String idImagemTitulo, char LGPD, boolean salvo, Connection con) {
        this.idPergunta = idPergunta;
        this.idCliente = idCliente;
        this.identificadorResposta = identificadorResposta;
        this.titulo = titulo;
        this.explicacao = explicacao;
        this.explicacaoOculta = explicacaoOculta;
        this.idImagemTitulo = idImagemTitulo;
        items = new ArrayList();
        this.LGPD = LGPD;
        this.salvo = salvo;
        dao = new PerguntaDAO(con);
        this.con = con;
    }
    
    public boolean salvar () {
        salvo = true;
        boolean success = dao.insert(this);
        for(int i = 0; i < items.size(); i++){
            if(!items.get(i).isSalvo()){
                items.get(i).salvar();
            }
        }
        return success;
    }
    
    public byte addItem (Item item) {
        
        boolean dieFunction = false;
        for(int i =0; i < items.size(); i++){
            if(items.get(i).getChaveItem().equals(item.getChaveItem())){
                dieFunction = true;
                break;
            }
        }
        
        if(dieFunction)return -1;
        
        item = new Item (
                (byte)(COUNTER_ITEMS_ID + 1),
                (byte)items.size(),
                (byte)items.size(),
                idPergunta,
                item.getTituloItem(),
                item.getIdImagemItem(),
                item.getChaveItem(),
                item.getValorDefault(),
                false,
                con
        );
        items.add(item);
        return item.getNumeroDeOrdem();
    }
    
    public boolean moveItem (byte a, byte b) {
        Collections.swap(items, a, b);
        for(int i = 0; i < items.size(); i++){
            items.get(i).setNumeroDeOrdem((byte) i);
            items.get(i).setIdItem((byte) i);
            items.get(i).updateIndex();
        }
        return true;
    }
    
    public boolean removeItem (byte item) {
        boolean success = items.get(item).remove() && items.remove(items.get(item));
        for(int i = 0; i < items.size(); i++){
            items.get(i).setNumeroDeOrdem((byte) i);
            items.get(i).setIdItem((byte) i);
            items.get(i).updateIndex();
        }
        return success;
    }
    
    public boolean loadAsyncDbItems () {
        this.items = dao.loadItems(this);
        this.COUNTER_ITEMS_ID = dao.loadMaxLastIdItem();
        return true;
    }
    
    public byte getNumerosItens () {
        return (byte) items.size();
    }
    
    public boolean setChaves (List<String> chaves) {
        return true;
    }
    
    /////////////////////////////////////////////////
    public abstract String HTML ();
    public abstract String HTMLTag ();
    public abstract String HTMLEdicao ();
    public abstract String GeraJavascript ();
    //////////////////////////////////////////////////

    public String getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(String idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdentificadorResposta() {
        return identificadorResposta;
    }

    public void setIdentificadorResposta(String identificadorResposta) {
        this.identificadorResposta = identificadorResposta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getExplicacao() {
        return explicacao;
    }

    public void setExplicacao(String explicacao) {
        this.explicacao = explicacao;
    }

    public char getExplicacaoOculta() {
        return explicacaoOculta;
    }

    public void setExplicacaoOculta(char explicacaoOculta) {
        this.explicacaoOculta = explicacaoOculta;
    }

    public String getIdImagemTitulo() {
        return idImagemTitulo;
    }

    public void setIdImagemTitulo(String idImagemTitulo) {
        this.idImagemTitulo = idImagemTitulo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public char getLGPD() {
        return LGPD;
    }

    public void setLGPD(char LGPD) {
        this.LGPD = LGPD;
    }

    public LGPDBaseLegal getBaseLegal() {
        return baseLegal;
    }

    public void setBaseLegal(LGPDBaseLegal baseLegal) {
        this.baseLegal = baseLegal;
    }

    public LGPDMotivo getMotivo() {
        return motivo;
    }

    public void setMotivo(LGPDMotivo motivo) {
        this.motivo = motivo;
    }

    public LGPDTratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(LGPDTratamento tratamento) {
        this.tratamento = tratamento;
    }

    public boolean isSalvo() {
        return salvo;
    }

    public void setSalvo(boolean salvo) {
        this.salvo = salvo;
    }

    public PerguntaDAO getDao() {
        return dao;
    }

    public void setDao(PerguntaDAO dao) {
        this.dao = dao;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
}
