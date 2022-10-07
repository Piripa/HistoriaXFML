
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class App extends Application {
    public static void main(String[] args) 
    {
        launch(args); 
    }

    
    public void start(Stage primaryStage) throws Exception
    {   //System.out.println(getClass().getResource("tela.fxml"));
        FXMLLoader carregador = new FXMLLoader(getClass().getResource("/teste.fxml"));
        Parent root = carregador.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("História");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}
