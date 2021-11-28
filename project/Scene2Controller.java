import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene2Controller implements Initializable{
	@FXML private VBox animationSpace;
	Stack<ArrayList<String>> nextSteps = new Stack<>();
	Stack<ArrayList<String>> previusSteps = new Stack<>();
	ArrayNode arrayN;

	@FXML
	public void initialize(URL arg0,ResourceBundle arg1){
        System.out.println(Main.getNumbers());

		arrayN = new ArrayNode(Main.getNumbers());
		animationSpace.getChildren().add(arrayN.getView());


		ArrayList<String> claves = new ArrayList<>();
		ArrayList<Integer> valores = new ArrayList<>();

		int[] list = new int[arrayN.size()];

		for(int i=0;i<arrayN.size();i++){
			list[i] = arrayN.get(i).getElement();
		}

		QuickSort.quickSort(list,claves,valores); 


		for(int i = valores.size()-1; i>-1;i--){
			ArrayList<String> aux = new ArrayList<>();
			aux.add(claves.get(i));
			aux.add(String.valueOf(valores.get(i)));
			nextSteps.add(aux);
		}
	}

	@FXML
	private void goToScene1(ActionEvent event) throws IOException{
		Parent scene2 = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		Scene sc2 = new Scene(scene2);
		Stage app = (Stage)((Node)event.getSource()).getScene().getWindow();

		app.setScene(sc2);
		app.show();
	}


	int low = 0;
	int high = 0;
	int pivot = 0;

	void printLHP(){
		System.out.println("low "+low );
		System.out.println("high "+high );
		System.out.println("pivot "+pivot );
	}

	@FXML
	private void nextStep(){

		if (nextSteps.empty()){
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("QuickSort terminado");
			alert.setHeaderText("QuickSort terminado");
			alert.showAndWait();
			return;
		}
		ArrayList<String> aux = nextSteps.pop();
		previusSteps.add(aux);
		if(aux.get(0).equals("pivot") || aux.get(0).equals("pivote")){
			arrayN.get(Integer.parseInt(aux.get(1))).pintarBottomArrow();
			if(nextSteps.peek().get(0).equals("low")){
				pivot = Integer.parseInt(nextSteps.peek().get(1))-1;
			}
		}else if(aux.get(0).equals("low")){
			arrayN.get(Integer.parseInt(aux.get(1))).pintarLowFull();
			low = Integer.parseInt(aux.get(1));
		}else if(aux.get(0).equals("high")){
			arrayN.get(Integer.parseInt(aux.get(1))).pintarHighFull();
			high = Integer.parseInt(aux.get(1));
		}else if(aux.get(1).equals("-1")){
			int s = arrayN.get(high).getElement();
			arrayN.get(high).setElement(arrayN.get(low).getElement());
			arrayN.get(low).setElement(s);
		}else if(aux.get(1).equals("-2")){
			int s = arrayN.get(high).getElement();
			arrayN.get(high).setElement(arrayN.get(pivot).getElement());
			arrayN.get(pivot).setElement(s);
			arrayN.get(high).background();
		};

	}

	@FXML
	private void previousStep(){
		if(previusSteps.empty()){
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Inicio del proceso");
			alert.showAndWait();
			return;
		}
		ArrayList<String> aux = previusSteps.pop();
		nextSteps.add(aux);
		if(aux.get(0)=="pivot" || aux.get(0)=="pivote"){
			arrayN.get(Integer.parseInt(aux.get(1))).borrarBottomArrow();
		}else if(aux.get(0).equals("low")){
			arrayN.get(Integer.parseInt(aux.get(1))).borrarLowFull();
		}else if(aux.get(0).equals("high")){
			arrayN.get(Integer.parseInt(aux.get(1))).borrarHighFull();
		};
	}

	@FXML
	private void jumpToEnd(){
		while(!nextSteps.empty()){
			nextStep();
		}
	}

	@FXML
	private void returnStart(){
		while(!nextSteps.empty()){
			previousStep();
		}
	}
}
