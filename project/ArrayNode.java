import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ArrayNode extends HBox{

    public ArrayNode(ArrayList<Integer> array){
        for(Integer n:array){
            getChildren().add(new node<Integer>(n));
        }
        setAlignment(Pos.CENTER);
    }
}
