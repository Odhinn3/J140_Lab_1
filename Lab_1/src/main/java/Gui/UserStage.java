package Gui;
import static Repositories.Repository.loginstatus;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class UserStage extends Stage {

    public void init(Stage stage) throws IOException{
        Label label = new Label();
        VBox root = new VBox();
        label.setText(loginstatus);
        
        root.getChildren().addAll(label);
        
        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Login status");
        stage.setScene(scene);
        stage.show();
    }
}