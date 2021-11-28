import java.util.ArrayList;
import java.util.Iterator;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class ArrayNode extends ArrayList<node<Integer>>{

    public ArrayNode(ArrayList<Integer> array){
        for(Integer n:array){
            add(new node<Integer>(n));
        }
    }

    public Node getView(){
        Iterator<node<Integer>> iterable =  iterator();
        HBox aux = new HBox();
        while(iterable.hasNext()){
            aux.getChildren().add(iterable.next());
        }
        aux.setAlignment(Pos.CENTER);
        return aux;
    }
}
