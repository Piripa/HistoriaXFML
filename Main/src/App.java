import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.HashMap;
public class App extends Application {
    public static void main(String[] args) {
        launch( args);
        Scanner input = new Scanner(System.in);
        Dicionario leitor = new Dicionario();
        HashMap<String, Personagem> recebePersonagem = leitor.LeitorPersonagem("Main/rsc/Dicpersona.txt");
        Personagem perso = recebePersonagem.get("Enzo");
        HashMap<String,Capitulos> receberCapitulos = leitor.LeitorCapitulos("Main/rsc/Dicap.txt", recebePersonagem, input);
        Capitulos raiz = receberCapitulos.get("Piloto");
        raiz.mostrar();
        input.close();
        
    }

    @Override
    public void start(Stage arg0) throws Exception {
        arg0.setTitle("Titulo");
        Button botao = new Button("Clique");
        botao.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) 
            {
                System.out.println("Ae");
                
            }
            
        });
        StackPane root = new StackPane();
        root.getChildren().addAll(botao);
        arg0.setScene(new Scene(root, 300, 300)); 
        arg0.show();       
    }
}
