package MainPack;

import Repositories.Repository;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */

public class App extends Application {
    private static String user;
    private static String password;

    @Override
    public void start(Stage stage) throws IOException {
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        Button btn = new Button();
        btn.setText("Log in");
        btn.setOnAction((ActionEvent) -> {
            user = textField1.getText();
            password = textField2.getText();
            new Repository().checkUsers("admin", "admin");
        });
        
        VBox root = new VBox();
        root.getChildren().addAll(textField1, textField2, btn);
        Scene scene = new Scene(root, 300, 250);        
        stage.setTitle("User login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static String getUser() {
        return user;
    }

    private static void setUser(String user) {
        App.user = user;
    }

    public static String getPassword() {
        return password;
    }

    private static void setPassword(String password) {
        App.password = password;
    }
}