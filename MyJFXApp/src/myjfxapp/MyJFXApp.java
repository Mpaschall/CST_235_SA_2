package myjfxapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import beans.Storage_Bean;
import static javafx.application.Application.launch;

public class MyJFXApp extends Application {
    
    //call storage bean
    Storage_Bean sb = new Storage_Bean();
    
    //create variables
    private double storage;
    private double input;
    private int vids;
    
    //create UI elements and add user interface controls
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Calculate Storage");
        Label instrLabel = new Label();
        instrLabel.setText("Enter Video File Size (GB)");
        Label resLabel = new Label();
        TextField tf = new TextField();
        Label numVidLabel = new Label();
        numVidLabel.setText("Enter Number of Videos");
        TextField num = new TextField();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            //create button action handler 
            //sets variables and calls myStorage method
            @Override
            public void handle(ActionEvent event) {
                input = Double.parseDouble(tf.getText());
                vids = Integer.parseInt(num.getText());
                mystorage();
                resLabel.setText("Total videoSpace is " + 
                        Double.toString(storage) + " GB");
            }
        });
        
        VBox root = new VBox();
        root.getChildren().add(instrLabel);
        root.getChildren().add(tf);
        root.getChildren().add(numVidLabel);
        root.getChildren().add(num);
        root.getChildren().add(btn);
        root.getChildren().add(resLabel);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Access Bean");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //create method to use bean properties and method
    public void mystorage(){
        sb.setVideoSpace(sb.multipleVideos(input, vids));
        storage = sb.getVideoSpace();
    }

    //launch application
    public static void main(String[] args) {
        launch(args);
    }
    
}
