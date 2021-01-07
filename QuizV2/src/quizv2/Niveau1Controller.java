/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizv2;


import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import static quizv2.IdentificationController.player;
import quizv2.PlayerReponces;
import quizv2.Quiz;
import static quizv2.QuizV2.fenetre;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class Niveau1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    static Timeline timeline;
    int timer = 300;
    int tentative_nbr = 2;
    public static String S = "";
    int i =1;

    LinkedList<Quiz> _listsL1Quizes = new LinkedList<>();
    LinkedList<RadioButton> lists_toggle = new LinkedList<>();
    LinkedList<PlayerReponces> lists_players_Responses = new LinkedList<>();

    LinkedList<RadioButton> correctRadioButtonsIds = new LinkedList<RadioButton>();
    LinkedList<RadioButton> incorrectRadioButtonsIds = new LinkedList<RadioButton>();

    ToggleGroup group_1 = new ToggleGroup();
    ToggleGroup group_2 = new ToggleGroup();
    ToggleGroup group_3 = new ToggleGroup();
    ToggleGroup group_4 = new ToggleGroup();
    ToggleGroup group_5 = new ToggleGroup();
    
   
    @FXML
    private BorderPane rootPane;
    @FXML
    private Label score_result;
    @FXML
    private Label counter_results;
    @FXML
    private Label Label1;
    @FXML
    private Label Label2;
    @FXML
    private Label Label3;
    @FXML
    private Label Label4;
    @FXML
    private Label Label5;
    @FXML
    private RadioButton Radio1Q1;
    @FXML
    private RadioButton Radio1Q2;
    @FXML
    private RadioButton Radio1Q3;
     @FXML
    private RadioButton Radio1Q4;
    @FXML
    private RadioButton Radio1Q5;
    @FXML
    private RadioButton Radio2Q1;
    @FXML
    private RadioButton Radio2Q2;
    @FXML
    private RadioButton Radio2Q3;
     @FXML
    private RadioButton Radio2Q4;
    @FXML
    private RadioButton Radio2Q5;
    @FXML
    private RadioButton Radio3Q1;
    @FXML
    private RadioButton Radio3Q2;
    @FXML
    private RadioButton Radio3Q3;
     @FXML
    private RadioButton Radio3Q4;
    @FXML
    private RadioButton Radio3Q5;
    
    @FXML
    private Button BtnVerif;
    @FXML
    private ImageView tent1;
    @FXML
    private ImageView tent2;
    @FXML
    private Pane contentPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            if (timer > 0) {
                timer--;
                S = "" + LocalTime.MIN.plusSeconds(timer);
                counter_results.setText(S);
            } else {
                timeline.stop();
                getAlert("GAME OVER");
                System.exit(0);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        niveau1();
    }    
    private void getAlert(String game_over) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(game_over);
        alert.show();
    }

    private void niveau1() {
        Quiz quiz1 = new Quiz("JAVA est  un langage", "Compilé et interpreté", "Compilé", "Interprété", "Compilé et interpreté");
        Quiz quiz2 = new Quiz("Toutes les classes héritent de la classe", "Object", "Main", "Object", "AWT");
        Quiz quiz3 = new Quiz("Par convention une classe", "commence par une majuscule", "est en minuscule", "commence par une majuscule", "est en majuscules");
        Quiz quiz4 = new Quiz("Est-ce que on peut avoir plusieurs constructeurs pour la même classe", "oui", "oui", "non");
        Quiz quiz5 = new Quiz("Dans la ligne \"public class A implements B\", B est:", "Interfacce", "Interfacce", "Classe parent", "Package");
        
        
        
        _listsL1Quizes.add(quiz1);
        _listsL1Quizes.add(quiz2);
        _listsL1Quizes.add(quiz3);
        _listsL1Quizes.add(quiz4);
        _listsL1Quizes.add(quiz5);

        Dessiner();

        BtnVerif.setOnAction((ActionEvent event) -> {
            if (checkAllToggleGroups()) {
                AffichageRepSelectionnees();
                VerifRepCorrects();
                validationNiveau1();
                CorrectionRepIncorrects();
            } else {
                getAlert("All Must Filled Out");
            }
        });
    }

    // show the Plaer The correct  & the incorrect Answers
    private void CorrectionRepIncorrects() {
        for (int i = 0; i < correctRadioButtonsIds.size(); i++) {
            RadioButton get = correctRadioButtonsIds.get(i);
            get.getStyleClass().add("correct_");
            System.out.println("Reponces Correct" + get);
        }
        for (int i = 0; i < incorrectRadioButtonsIds.size(); i++) {
            RadioButton get_ = incorrectRadioButtonsIds.get(i);
            get_.getStyleClass().add("incorrect_");
            System.out.println("Reponces Incorrect" + get_);
        }
    }

    // get the selected answers 
    private void AffichageRepSelectionnees() {

        RadioButton Rd1select = (RadioButton) group_1.getSelectedToggle();
        RadioButton Rd2select = (RadioButton) group_2.getSelectedToggle();
        RadioButton Rd3select = (RadioButton) group_3.getSelectedToggle();
        RadioButton Rd4select = (RadioButton) group_4.getSelectedToggle();
        RadioButton Rd5select = (RadioButton) group_5.getSelectedToggle();

        lists_toggle.add(Rd1select);
        lists_toggle.add(Rd2select);
        lists_toggle.add(Rd3select);
        lists_toggle.add(Rd4select);
        lists_toggle.add(Rd5select);

        /* for (int i = 0; i < lists_toggle.size(); i++) {
            RadioButton items = lists_toggle.get(i);
            System.out.println(items);
        }*/
    }

    // should i procced to the nextlevel or i have the chance to try again
    private void validationNiveau1() {
        if (score() >= 40) {
            //next_level.setDisable(false);
            score_result.setText("Score : " + score());
            BtnVerif.setDisable(true);
            //loadNext_Level();
        } else {
            System.out.println("you loose in this level :( ");
            score_result.setText("Score : " + score());
            BtnVerif.setDisable(true);
            rejouer();
        }
    }

    private void VerifRepCorrects() {
//        player.getId();
//        if (lists_toggle.get(0).getText().equals(_listsL1Quizes.get(0).getResponse()) && lists_toggle.get(1).getText().equals(_listsL1Quizes.get(1).getResponse()) && lists_toggle.get(2).getText().equals(_listsL1Quizes.get(2).getResponse()) && lists_toggle.get(3).getText().equals(_listsL1Quizes.get(3).getResponse()) && lists_toggle.get(4).getText().equals(_listsL1Quizes.get(4).getResponse())) {
//            System.out.println("responses correct");
//        } else {
//
//        }
        for (int i = 0; i < _listsL1Quizes.size(); i++) {
            boolean correctOrNot;
            if (lists_toggle.get(i).getText().equals(_listsL1Quizes.get(i).getReponce())) {
                // System.out.println(lists_toggle.get(i) + " responses correct ");
                correctOrNot = true;
                correctRadioButtonsIds.add(lists_toggle.get(i));
            } else {
                // System.out.println(lists_toggle.get(i).getId() + " responses incorrect ");
                correctOrNot = false;
                incorrectRadioButtonsIds.add(lists_toggle.get(i));
            }
            
            PlayerReponces player_Responses = new PlayerReponces(player.getId(), _listsL1Quizes.get(i).getId(), lists_toggle.get(i).getText(), correctOrNot);
            lists_players_Responses.add(player_Responses);
//            for (int j = 0; j < lists_players_Responses.size(); j++) {
//            Player_Responses player_Responses_ = lists_players_Responses.get(i);
//            System.out.println(player_Responses_.toString());
//            }
        }
    }

    private int score() {
        int score_reward = 0;
        for (int i = 0; i < lists_players_Responses.size(); i++) {
            if (lists_players_Responses.get(i).isCorrect()) {
                score_reward += 20;
            }
            score_reward += 0;
        }
        return score_reward;
    }

    private boolean checkAllToggleGroups() {
        if (group_1.getSelectedToggle() == null || group_2.getSelectedToggle() == null || group_3.getSelectedToggle() == null || group_4.getSelectedToggle() == null || group_5.getSelectedToggle() == null) {
            return false;
        }
        return true;
    }

    private void Dessiner() {
        //Remplissage Question1
        Label1.setText(_listsL1Quizes.get(0).getQuestion());
        
        Radio1Q1.setText(_listsL1Quizes.get(0).getPerChoix());
        Radio1Q1.setToggleGroup(group_1);
        
        Radio2Q1.setText(_listsL1Quizes.get(0).getDexChoix());
        Radio2Q1.setToggleGroup(group_1);
        
        Radio3Q1.setText(_listsL1Quizes.get(0).getTroChoix());
        Radio3Q1.setToggleGroup(group_1);

        
        //Remplissage Question2
        Label2.setText(_listsL1Quizes.get(1).getQuestion());
        
        Radio1Q2.setText(_listsL1Quizes.get(1).getPerChoix());
        Radio1Q2.setToggleGroup(group_2);
        
        Radio2Q2.setText(_listsL1Quizes.get(1).getDexChoix());
        Radio2Q2.setToggleGroup(group_2);
        
        Radio3Q2.setText(_listsL1Quizes.get(1).getTroChoix());
        Radio3Q2.setToggleGroup(group_2);
        
        
        //Remplissage Question3
        Label3.setText(_listsL1Quizes.get(2).getQuestion());
        
        Radio1Q3.setText(_listsL1Quizes.get(2).getPerChoix());
        Radio1Q3.setToggleGroup(group_3);
        
        Radio2Q3.setText(_listsL1Quizes.get(2).getDexChoix());
        Radio2Q3.setToggleGroup(group_3);
        
        Radio3Q3.setText(_listsL1Quizes.get(2).getTroChoix());
        Radio3Q3.setToggleGroup(group_3);

        //Remplissage Question4
        Label4.setText(_listsL1Quizes.get(3).getQuestion());
        
        Radio1Q4.setText(_listsL1Quizes.get(3).getPerChoix());
        Radio1Q4.setToggleGroup(group_4);
        
        Radio2Q4.setText(_listsL1Quizes.get(3).getDexChoix());
        Radio2Q4.setToggleGroup(group_4);
        
        Radio3Q3.setText(_listsL1Quizes.get(3).getTroChoix());
        Radio3Q3.setToggleGroup(group_4);

        

        //Remplissage Question5
        Label5.setText(_listsL1Quizes.get(4).getQuestion());
        
        Radio1Q5.setText(_listsL1Quizes.get(4).getPerChoix());
        Radio1Q5.setToggleGroup(group_5);
        
        Radio2Q5.setText(_listsL1Quizes.get(4).getDexChoix());
        Radio2Q5.setToggleGroup(group_5);
        
        Radio3Q5.setText(_listsL1Quizes.get(4).getTroChoix());
        Radio3Q5.setToggleGroup(group_4);

    }

    /*private void loadNext_Level() {
        next_level.setOnAction((ActionEvent event) -> {
            try {
                level1rootpane = FXMLLoader.load(getClass().getResource("Level_2.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(Level_1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

            Scene scene = new Scene(level1rootpane);
            scene.getStylesheets().add(LoginController.class.getResource("GlobalStyles.css").toExternalForm());

            _Window_.setScene(scene);

            _Window_.setTitle(
                    "Level_2 Window");
            _Window_.show();
        });
    }*/

    private void rejouer() {
        dialog_Confirmation();
    }

    private void dialog_Confirmation() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You Juste Loose This Level :(");
        alert.setContentText(" Do You Wan To Try Again ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (score() < 40 && result.get() == ButtonType.OK) {
            System.out.println("OK I wan To Try");
            // clear All The LinkedLists In This Level And Then Populate The new Level
            tentative_nbr--;
            tent2.setVisible(false);

            _listsL1Quizes.clear();
            lists_toggle.clear();
            lists_players_Responses.clear();
            correctRadioButtonsIds.clear();
            incorrectRadioButtonsIds.clear();

            System.out.println("Lists Quiz : " + _listsL1Quizes);
            System.out.println("Lists Radio Buttons Toggles  : " + lists_toggle);
            System.out.println("Lists Players Responses : " + lists_players_Responses);
            System.out.println("Lists Correct Radio Buttons Toggles  : " + correctRadioButtonsIds);
            BtnVerif.setDisable(false);
            niveau1();

            if (tentative_nbr == 0) {
                CorrectionRepIncorrects();
                System.out.println("You Loose The Game Sorry");
                System.exit(0);
            }
        } else {
            System.out.println("OH NOOOOO");
            oops_YouJusteLooseTheGameAlert();
        }
    }

    private void oops_YouJusteLooseTheGameAlert() {
        System.out.println("Oop's You juste loose the game :( ");
    }
    
}
