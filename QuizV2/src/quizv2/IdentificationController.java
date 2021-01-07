/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizv2;


import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import quizv2.Player;
import static quizv2.QuizV2.fenetre;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class IdentificationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    static Player player;
    static LinkedList<Player> players_lists = new LinkedList<>();

    @FXML
    private TextField Prenom;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Age;
    @FXML
    private BorderPane RootPane;
    @FXML
    private Button BtnLogin;
    @FXML
    private Label verificationChamps;
  
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        BtnLogin.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    if (Prenom.getText().trim().isEmpty() ||Nom.getText().trim().isEmpty()) {
                        verificationChamps.setText("Veuillez remplir tous les champs");
                    } else {
                        player = new Player(Prenom.getText(), Nom.getText(), Integer.parseInt(Age.getText()));
                        players_lists.add(player);
                        try {
                            RootPane = FXMLLoader.load(getClass().getResource("Niveau1.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(IdentificationController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        Scene scene = new Scene(RootPane);
                        scene.getStylesheets().add(IdentificationController.class.getResource("style.css").toExternalForm());

                        fenetre.setScene(scene);

                        fenetre.setTitle("Niveau1");
                        fenetre.show();
                    }
                }
            }
        );
    }

}
    
   
