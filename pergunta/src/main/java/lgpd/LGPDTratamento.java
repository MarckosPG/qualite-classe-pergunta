package lgpd;

public class LGPDTratamento {
    
    private String idTratamento;
    private String idPergunta;
    private String textoTratamentoOperador;
    private String textoTratamentoControlador;
    
    private char opTrat_coleta = '1';
    private char opTrat_producao = '0';
    private char opTrat_recepcao = '1';
    private char opTrat_classificacao = '1';
    private char opTrat_ultilizacao = '1';
    private char opTrat_acesso = '1';
    private char opTrat_reproducao = '1';
    private char opTrat_transmissao = '1';
    private char opTrat_distribuicao = '0';
    private char opTrat_processamento = '1';
    private char opTrat_arquivamento = '1';
    private char opTrat_armazenamento = '1';
    private char opTrat_eliminacao = '1';
    private char opTrat_avaliacao = '1';
    private char opTrat_modificacao = '0';
    private char opTrat_comunicacao = '0';
    private char opTrat_transferencia = '0';
    private char opTrat_difusao = '0';
    private char opTrat_extracao = '1';
    
    public LGPDTratamento () {}
    public LGPDTratamento (String idTratamento) {
        this.idTratamento = idTratamento;
    }
    public String getTextoOperador () {
        return textoTratamentoOperador;
    } 
    public String getTextoTratamentoControlador () {
        return (!textoTratamentoControlador.equals(""))? textoTratamentoControlador : "O tratamento do texto sera: " + getTextTratamento();
    }
    public void resetDefault () {
        opTrat_coleta = '1';
        opTrat_producao = '0';
        opTrat_recepcao = '1';
        opTrat_classificacao = '1';
        opTrat_ultilizacao = '1';
        opTrat_acesso = '1';
        opTrat_reproducao = '1';
        opTrat_transmissao = '1';
        opTrat_distribuicao = '0';
        opTrat_processamento = '1';
        opTrat_arquivamento = '1';
        opTrat_armazenamento = '1';
        opTrat_eliminacao = '1';
        opTrat_avaliacao = '1';
        opTrat_modificacao = '0';
        opTrat_comunicacao = '0';
        opTrat_transferencia = '0';
        opTrat_difusao = '0';
        opTrat_extracao = '1';
    }
    private String getTextTratamento () {
        String text = "";
        
        Coleta:{
            switch(opTrat_coleta){
                case '0':
                    text += "";
                    break;
                case '1':
                    text += "Tratamento";
                    break;
            }
        }
        
        Producao:{
            switch(opTrat_producao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Produção";
                    break;
            }
        }
        
        Recepcao:{
            switch(opTrat_recepcao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Recepção";
                    break;
            }
        }
        
        Classificacao: {
            switch(opTrat_classificacao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Classificação";
                    break;
            }
        }
        
        Ultilizacao: {
            switch(opTrat_ultilizacao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Ultilização";
                    break;
            }
        }
          
        Acesso: {
            switch(opTrat_acesso){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Acesso";
                    break;
            }
        }
        
        Reproducao: {
            switch(opTrat_reproducao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Reprodução";
                    break;
            }
        }
        
        Transmicao: {
            switch(opTrat_transmissao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Transmissão";
                    break;
            }
        }
        
        Distribuicao: {
            switch(opTrat_distribuicao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Distribuição";
                    break;
            }
        }
        
        Processamento: {
            switch(opTrat_processamento){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Processamento";
                    break;
            }
        }
        
        Arquivamento: {
            switch(opTrat_arquivamento){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Arquivamento";
                    break;
            }
        }
        
        Armazenamento: {
            switch(opTrat_armazenamento){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Armazenamento";
                    break;
            }
        }
        
        Eliminacao: {
            switch(opTrat_eliminacao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Eliminação";
                    break;
            }
        }
        
        Avaliacao: {
            switch(opTrat_avaliacao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Avaliação";
                    break;
            }
        }
        
        Modificacao: {
            switch(opTrat_modificacao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Modificação";
                    break;
            }
        }
        
        Comunicacao: {
            switch(opTrat_comunicacao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Comunicação";
                    break;
            }
        }
        
        Transferencia: {
            switch(opTrat_transferencia){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Tranferência";
                    break;
            }
        }
        
        Difusao: {
            switch(opTrat_difusao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Difusão";
                    break;
            }
        }
        
        Extracao: {
            switch(opTrat_extracao){
                 case '0':
                    text += "";
                    break;
                case '1':
                    text += "Extração";
                    break;
            }
        }
        
        return text;
    }
    
}
