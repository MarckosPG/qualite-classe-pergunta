package components;

import java.sql.Connection;
import java.util.List;
import lgpd.LGPDBaseLegal;
import lgpd.LGPDMotivo;
import lgpd.LGPDTratamento;
import models.Item;
import models.Pergunta;

public class PerguntaBuilder extends Pergunta {
    
    public PerguntaBuilder(String idPergunta, String idCliente, String identificadorResposta, String titulo, String explicacao, char explicacaoOculta, String idImagemTitulo, char LGPD, boolean salvo, Connection con) {
        super(idPergunta, idCliente, identificadorResposta, titulo, explicacao, explicacaoOculta, idImagemTitulo, LGPD, salvo, con);
    }

    @Override
    public String HTML() {
        return "";
    }

    @Override
    public String HTMLTag() {
        return "";
    }

    @Override
    public String HTMLEdicao() {
        return "";
    }

    @Override
    public String GeraJavascript() {
        return "";
    }
    
}
