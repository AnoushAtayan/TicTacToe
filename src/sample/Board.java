package sample;



import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;


/**
 * Created by Anoush Atayan on 2/27/2017.
 */





public class Board {



    ArrayList<TextField> list = new ArrayList<>();
    Computer computer = new Computer();

    @FXML
    private MenuItem newGame, exit;


    @FXML
    public TextField cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9;

    @FXML
    Label text;


    @FXML
    public ChoiceBox choiceBox;


    @FXML
    public void initialize() {


        choiceBox.setValue("");
        choiceBox.getItems().add("X");
        choiceBox.getItems().add("O");


        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            text.setText("You are playing with " + newValue);
            choiceBox.setDisable(true);


        });

        newGame.setOnAction(event -> {
            choiceBox.setDisable(false);
                    for (int i = 0; i <list.size() ; i++) {
                        list.get(i).setDisable(false);
                        list.get(i).setText("");
                    }
        }

        );
        exit.setOnAction(event ->
            Platform.exit()

        );


    }


    @FXML
    public void setText(MouseEvent event) throws InterruptedException {


        if (choiceBox.getValue() == "") {
            ((TextField) event.getSource()).setText("");

        } else if (choiceBox.getValue() == "X") {
            if (((TextField) event.getSource()).getText().isEmpty()) {

                ((TextField) event.getSource()).setText("X");
                ((TextField) event.getSource()).setDisable(true);
            }

        } else if (choiceBox.getValue() == "O") {
            if (((TextField) event.getSource()).getText().isEmpty()) {

                ((TextField) event.getSource()).setText("O");
                ((TextField) event.getSource()).setDisable(true);
            }


        }
        list.add(0, cell1);
        list.add(1, cell2);
        list.add(2, cell3);
        list.add(3, cell4);
        list.add(4, cell5);
        list.add(5, cell6);
        list.add(6, cell7);
        list.add(7, cell8);
        list.add(8, cell9);




        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(0.5),
                        event1 -> {computer.play(this);

                        }
                )
        );

        timeline.play();
        gameOutput();



    }

    public void gameOutput() {
        int output=0;


        if ((cell1.getText().equals("X") && cell4.getText().equals("X") && cell7.getText().equals("X")) ||
                (cell2.getText().equals("X") && cell5.getText().equals("X") && cell8.getText().equals("X")) ||
                (cell3.getText().equals("X") && cell6.getText().equals("X") && cell9.getText().equals("X")) ||
                (cell1.getText().equals("X") && cell2.getText().equals("X") && cell3.getText().equals("X")) ||
                (cell4.getText().equals("X") && cell5.getText().equals("X") && cell6.getText().equals("X")) ||
                (cell7.getText().equals("X") && cell8.getText().equals("X") && cell9.getText().equals("X")) ||
                (cell1.getText().equals("X") && cell5.getText().equals("X") && cell9.getText().equals("X")) ||
                (cell7.getText().equals("X") && cell5.getText().equals("X") && cell3.getText().equals("X"))){
            text.setText("X Player has won!");
            for (int i = 0; i <list.size() ; i++) {
                list.get(i).setDisable(true);

            }
            output=1;

        }

        if ((cell1.getText().equals("O")&& cell4.getText().equals("O") && cell7.getText().equals("O")) ||
                (cell2.getText().equals("O")&& cell5.getText().equals("O") && cell8.getText().equals("O"))||
                (cell3.getText().equals("O")&& cell6.getText().equals("O") && cell9.getText().equals("O"))||
                (cell1.getText().equals("O")&& cell2.getText().equals("O") && cell3.getText().equals("O"))||
                (cell4.getText().equals("O")&& cell5.getText().equals("O") && cell6.getText().equals("O"))||
                (cell7.getText().equals("O")&& cell8.getText().equals("O") && cell9.getText().equals("O"))||
                (cell1.getText().equals("O")&& cell5.getText().equals("O") && cell9.getText().equals("O"))||
                (cell7.getText().equals("O")&& cell5.getText().equals("O") && cell3.getText().equals("O")))
        {
            text.setText("O Player has won!");
            for (int i = 0; i <list.size() ; i++) {
                list.get(i).setDisable(true);

            }
            output=2;

        }
        if(output !=1&& output!=2 && cell1.isDisabled()==true&&cell2.isDisabled()==true&&cell3.isDisabled()==true&&cell4.isDisabled()==true&&
                cell5.isDisabled()==true&& cell6.isDisabled()==true&&cell7.isDisabled()==true&& cell8.isDisabled()==true&&cell9.isDisabled()==true){
            text.setText("No one has won.");
        }


    }

    }


















