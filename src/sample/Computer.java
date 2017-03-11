package sample;


import javafx.scene.control.TextField;

import java.util.Random;

/**
 * Created by Anoush Atayan on 2/27/2017.
 */

   public  class  Computer {
    Random rnd = new Random();




    public void play(Board board) {

        boolean isDisable = true;
        for (int i = 0; i <board.list.size() ; i++) {
            if(board.list.get(i).isDisabled()==false){
                isDisable=false;
            }
        }
        if (board.choiceBox.getValue()=="") {

        }
        else if (board.choiceBox.getValue()=="X") {

            do {
                TextField b = board.list.get(rnd.nextInt(board.list.size()));
                if (b.isDisabled() == false) {
                    isDisable = true;
                    b.setText("O");
                    b.setDisable(true);
                }


            }
            while (!isDisable);

            }
        else if(board.choiceBox.getValue()=="O"){
            do {
                TextField b = board.list.get(rnd.nextInt(board.list.size()));
                if (b.isDisabled() == false) {
                    isDisable = true;
                    b.setText("X");
                    b.setDisable(true);
                }


            }
            while (!isDisable);

        }

        }

        }











