package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.Random;

public class GameController {

    @FXML
    private TextField left;

    @FXML
    private TextField middle;

    @FXML
    private TextField right;

    private int gotChanged = 0;

    public void initialize(){
        setNumbers();
        gotChanged = 0;
    }

    private void setNumbers(){
        Random r = new Random();
        left.setText(r.nextInt(1, 100) + "");
        left.setAlignment(Pos.CENTER);
        middle.setText(r.nextInt(1, 100) + "");
        middle.setAlignment(Pos.CENTER);
        right.setText(r.nextInt(1, 100) + "");
        right.setAlignment(Pos.CENTER);
    }
    @FXML
    void changePressed(ActionEvent event) {
        if(gotChanged < 2){
            setNumbers();
            gotChanged++;
        }
    }

    @FXML
    void stopPressed(ActionEvent event) {
        printEnd();
        initialize();
    }

    private void printEnd(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("your score is: " + (Integer.parseInt(left.getText()) +
                Integer.parseInt(middle.getText()) + Integer.parseInt(right.getText())));
        alert.showAndWait();
    }

}
