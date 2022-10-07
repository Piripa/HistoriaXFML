import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class Controlador {
    HashMap<String, Personagem> recebePersonagem;
    HashMap<String,Capitulos> receberCapitulos;
    @FXML
    private Button botaoCarregar;

    @FXML
    private VBox espacoBotoes;

    @FXML
    private Label imagensCap;

    @FXML
    private TextArea textoDoCap;

    @FXML
    void carregar(ActionEvent event) {
        Dicionario leitor = new Dicionario();
        recebePersonagem = leitor.LeitorPersonagem("Main/rsc/Dicpersona.txt");
        receberCapitulos = leitor.LeitorCapitulos("Main/rsc/Dicap.txt", recebePersonagem);
        
        Capitulos raiz = receberCapitulos.get("Piloto");
        mostrarCapitulo(raiz);
    }
    void mostrarCapitulo(Capitulos capitulos)
    {
        imagensCap.setText("");
        try 
        {
            CapituloImagem capituloImagem = (CapituloImagem)capitulos;
            imagensCap.setText(capituloImagem.getImagem());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.out.println("Tentativa de cast não coerente");
        }
        textoDoCap.clear();
        textoDoCap.clear();
        espacoBotoes.getChildren().clear();

        textoDoCap.setText(capitulos.getNome() + "\n" + capitulos.getText() + "\n" + capitulos.alterarEnergiaPersonagem());
        if(capitulos.getEscolhas().size() > 0)
        {
            for (Escolha escolha : capitulos.getEscolhas()) 
            {
                Button botao = new Button(escolha.getTexto());
                botao.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        mostrarCapitulo(escolha.getProximo());
                    }
                    
                });
                espacoBotoes.getChildren().add(botao);
            }
        }
    }
}
