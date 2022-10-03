import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controlador {

    @FXML
    private Button campoAccept;

    @FXML
    private TextField campoKey;

    @FXML
    private TextField campoUser;

    @FXML
    void fazerLogin(ActionEvent event) {
        String usuario = campoUser.getText();
        String senha = campoKey.getText();
        if( usuario.equals("vini") && senha.equals("1234"))
        {
            System.out.println("Você fez login");
        }
        else
        {
            System.out.println("Dados Incorretos");
        }
    }

}
