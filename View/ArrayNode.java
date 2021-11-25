import java.util.ArrayList;

import javafx.scene.layout.HBox;

public class ArrayNode extends HBox{

    public ArrayNode(int size,boolean random,ArrayList<Integer> array){
        for(Integer n:array){
            getChildren().add(new Node(n));
        }
    }
}
