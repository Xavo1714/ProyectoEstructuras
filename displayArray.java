package project;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class displayArray extends Application{
   @Override
   public void start(Stage primaryStage){
      Button boton1 = new Button("Step");
      Button boton2 = new Button("Reset");
   
      node<Integer> celda1 = new node<>(10);
      node<Integer> celda2 = new node<>(11);
      node<Integer> celda3 = new node<>(13);
      node<Integer> celda4 = new node<>(18);
      node<Integer> celda5 = new node<>(512);
      node<Integer> celda6 = new node<>(18);
      node<Integer> celda7 = new node<>(512);
      
      HBox hbox = new HBox();
      hbox.setAlignment(Pos.CENTER);
      hbox.getChildren().addAll(celda1,celda2,celda3,celda4,celda5,celda6,celda7);
      
      HBox botones = new HBox();
      botones.setSpacing(30);
      botones.setAlignment(Pos.CENTER);
      botones.setPadding(new Insets(10));
      botones.getChildren().addAll(boton1, boton2); 
      
      BorderPane borderPane = new BorderPane();
      borderPane.setCenter(hbox);
      borderPane.setBottom(botones);
      
      //AQUI PRUEBO BORRAR LOS HIGH,LOW, FLECHAS Y CAMBIAR DE COLOR EL FONDO
      celda1.borrarTopArrow();
      celda2.background();
      celda3.borrarBottomArrow();
      celda4.borrarHigh();
      celda5.borrarLow();
   
      Scene scene = new Scene(borderPane);
      primaryStage.setTitle("Example");
      primaryStage.setScene(scene);
      //primaryStage.setResizable(false);
      primaryStage.show();
   }
   
}
