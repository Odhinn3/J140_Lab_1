/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;


import Repositories.Repository;
import Repositories.RepositoryInterface;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class UserStage extends Stage {
    private RepositoryInterface repo;

    public UserStage() {
        repo = new Repository();
    }
    
    public void init() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        Scene scene = new Scene(root);
        setTitle("Users");
        setScene(scene);
        show();
    }
}
