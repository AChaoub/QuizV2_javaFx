package quizv2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class QuizV2 extends Application {
    static Stage fenetre;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Identification.fxml"));
        fenetre = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(QuizV2.class.getResource("style.css").toExternalForm());
        fenetre.setScene(scene);
        fenetre.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
