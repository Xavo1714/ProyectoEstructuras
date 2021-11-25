import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class Node extends VBox{
    public Node(int element){
        getChildren().add(new Line());
        TextArea txt = new TextArea(Integer.toString(element));
        txt.setPrefHeight(20);
        txt.setPrefWidth(20);
        getChildren().add(txt);
    }
}

