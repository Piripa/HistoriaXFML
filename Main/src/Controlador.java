import java.util.HashMap;

import javafx.event.ActionEvent;
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
    private VBox espacoBotao;

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
        textoDoCap.setText(capitulos.getNome() + "\n" + capitulos.getText() + "\n" + capitulos.alterarEnergiaPersonagem());
    }

    public void mostrar()
    {
        // System.out.println("---------------------------------------------------------------------");
        // System.out.println(this.nome);
        // this.personagem.energy(this.variacaoEnergy);
        // System.out.println();
        // System.out.println(this.texto);
        // if(this.escolhas.size() > 0)
        // {
        //     for (Escolha escolha : escolhas) 
        //     {
        //         System.out.println("-"+ escolha.getTexto());
        //     }
        //     System.out.println();
            
        //     int Id = escolher();
        //     this.escolhas.get(Id).getProximo().mostrar();
        
        // }
    }

}
