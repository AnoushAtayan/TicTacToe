package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Tic Tac Toe");
            primaryStage.setScene(new Scene(root, 375, 400));
            primaryStage.show();

        }


        catch (Exception e) {
            e.printStackTrace();
        }}


    public static void main(String[] args) {
        launch(args);
    }
}

