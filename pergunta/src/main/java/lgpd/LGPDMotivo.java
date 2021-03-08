package lgpd;

public class LGPDMotivo {
    
    private String idMotivo;
    private String idPergunta;
    private String textoMotivoOperador;
    private String textoMotivoControlador;
    
    private char opMotComunicacao = '0';
    private char opMotFiscal = '0';
    private char opMotRelcionamento = '0';
    private char opMotLegal = '0';
    private char opMotValidacao = '0';
    private char opMotSaude = '0';
    
    public LGPDMotivo () {}
    public LGPDMotivo (String idMotivo) {
        this.idMotivo = idMotivo;
    }
    public String TextoMotivoOperador () {
        return textoMotivoOperador;
    }
    public String getTextoMotivoControlador () {
        return (!textoMotivoControlador.equals("")) ? textoMotivoControlador : "O motivo do texto sera: " + getTextMotivo();
    }
    public void resetDefault () {
        opMotComunicacao = '0';
        opMotFiscal = '0';
        opMotRelcionamento = '0';
        opMotLegal = '0';
        opMotValidacao = '0';
        opMotSaude = '0';
    }
    public String getTextMotivo () {
        String text = "";
        switch(opMotComunicacao){
            case '0':
                text += "";
                break;
            case '1':
                text += "Comunicacao";
                break;
        }
        switch(opMotFiscal){
            case '0':
                text += "";
                break;
            case '1':
                text += "Fiscal";
                break;
        }
        switch(opMotRelcionamento){
            case '0':
                text += "";
                break;
            case '1':
                text += "Relacionamento";
                break;
        }
        switch(opMotLegal){
            case '0':
                text += "";
                break;
            case '1':
                text += "Legal";
                break;
        }
        switch(opMotValidacao){
            case '0':
                text += "";
                break;
            case '1':
                text += "Validacao";
                break;
        }
        switch(opMotSaude){
            case '0':
                text += "";
                break;
            case '1':
                text += "Saude";
                break;
        }
        return text;
    }
    
}
