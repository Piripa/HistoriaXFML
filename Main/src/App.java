import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
        Scanner input = new Scanner(System.in);
        Dicionario leitor = new Dicionario();
        HashMap<String, Personagem> recebePersonagem = leitor.LeitorPersonagem("Main/rsc/Dicpersona.txt");
        Personagem perso = recebePersonagem.get("Enzo");
        HashMap<String,Capitulos> receberCapitulos = leitor.LeitorCapitulos("Main/rsc/Dicap.txt", recebePersonagem, input);
        Capitulos raiz = receberCapitulos.get("Piloto");
        raiz.mostrar();
        input.close();
        
    }

    
    public void start(Stage primaryStage) throws Exception
    {   //System.out.println(getClass().getResource("tela.fxml"));
        FXMLLoader carregador = new FXMLLoader(getClass().getResource("/teste.fxml"));
        Parent root = carregador.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Academia do piripa");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}
