package lgpd;

public class LGPDBaseLegal {
    
    private String idBaseLegal;
    private String idPergunta;
    private String textoBLOperator;
    private String textoBLControlador;
    
    private char opBLConsentimento = '1';
    private char opBLRegulacao = '0';
    private char opBLContratual = '0';
    private char opBLLegitimoInteresse = '0';
    private char opBLTutelaSaude = '0';
    
    public LGPDBaseLegal () {}
    public LGPDBaseLegal (String idBaseLegal) {
        this.idBaseLegal = idBaseLegal;
    }
    public String getTextoBLOperador () {
        return textoBLOperator;
    }
    public String getBLControlador () {
        return (!textoBLControlador.equals("")) ? textoBLControlador : "A Base Legal é: " + getTextBaseLegal();
    }
    public void resetDefault () {
        opBLConsentimento = '1';
        opBLRegulacao = '0';
        opBLContratual = '0';
        opBLLegitimoInteresse = '0';
        opBLTutelaSaude = '0';
    }
    public String getTextBaseLegal() {
        String text = "";
        switch(opBLConsentimento){
            case '0':
                text += "";
                break;
            case '1':
                text += "Consentimento";
                break;
        }
        switch(opBLRegulacao){
            case '0':
                text += "";
                break;
            case '1':
                text += "Regulação";
                break;
        }
        switch(opBLContratual){
            case '0':
                text += "";
                break;
            case '1':
                text += "Contratual";
                break;
        }
        switch(opBLLegitimoInteresse){
            case '0':
                text += "";
                break;
            case '1':
                text += "Interesse";
                break;
        }
        switch(opBLTutelaSaude){
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
