import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Controlador {
    HashMap<String, Personagem> recebePersonagem;
    HashMap<String,Capitulos> receberCapitulos;
    @FXML
    private Button botaoCarregar;

    @FXML
    private VBox espacoBotao;

    @FXML
    private Label imagensCap;

    @FXML
    private Label textoDoCap;

    @FXML
    void carregar(ActionEvent event) {
        Dicionario leitor = new Dicionario();
        recebePersonagem = leitor.LeitorPersonagem("Main/rsc/Dicpersona.txt");
        receberCapitulos = leitor.LeitorCapitulos("Main/rsc/Dicap.txt", recebePersonagem);
        Capitulos raiz = receberCapitulos.get("Piloto");
        textoDoCap.setText(raiz.getNome());
    }

}
