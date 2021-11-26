import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.ResourceBundle;

import javax.print.event.PrintJobListener;

public class Scene1Controller implements Initializable{
	@FXML private Spinner<Integer> mySpinner;
	@FXML private Button quickSortButton;
	@FXML private TextField textField;
	@FXML
	public void initialize(URL arg0,ResourceBundle arg1){
		 SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10,1);
        mySpinner.setValueFactory(valueFactory);
	}

	//Caso que no es aleatorio
	@FXML
	private void goToScene2(ActionEvent event) throws IOException{
		//Tomar los valores de Text field para ordenarlos
		String string  = textField.getText();
		String[] arrayNumbers;
		//Validar los datos
		if(check(string)){
			arrayNumbers = string.split(",");
		}else{
			if(string.length()==0){
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("Cadena Vacia");
				alert.showAndWait();
			}else{
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("Los valores deben estar separados\npor comas");
				alert.showAndWait();
			}
			return;
		}
		//Verificacion de datos
		ArrayList<Integer> aux = new ArrayList<>();
		for(String i: arrayNumbers){
			aux.add(Integer.parseInt(i));
		}
		Main.setNumbers(aux);
		System.out.println("Chao"+ Main.getNumbers());

		// Definir la nueva escena y stage segun el fxml
		Parent scene2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		Scene sc2 = new Scene(scene2);
		Stage app = (Stage)((Node)event.getSource()).getScene().getWindow();
		app.setScene(sc2);
		app.show();
	}

	//Caso aleatorio
	@FXML
	private void goToScene2R(ActionEvent event) throws IOException{

		//ArrayList aleatoria con tamano del numero que se encuentre en el spinner
		int j = mySpinner.getValue();
		ArrayList<Integer> aux = new ArrayList<>();
		for(int i=0;i<j;i++){
			aux.add(new Random().nextInt(1000));
		}
		//Manda nuestro arrayList a nuestra variable estatica de Main
		Main.setNumbers(aux);

		Parent scene2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		Scene sc2 = new Scene(scene2);
		Stage app = (Stage)((Node)event.getSource()).getScene().getWindow();
		app.setScene(sc2);
		app.show();
	}

	//Validad entrada
	public boolean check(String s){
		if(s.length()==0){
			return false;
		}
		if(s.charAt(0)==',' || s.charAt(s.length()-1)==',' ){
			return false;
		}

		int coma = 0;
		for(int i =0; i <s.length();i++){
			if(!Character.isDigit(s.charAt(i))){
				if (s.charAt(i)==','){
					++coma;
					System.out.println(coma);
					if(coma>1){
						coma = 0;
						return false;
					}
				}else {
					return false;
				}
			}else{
				coma=0;
			}
		}
		return true;
	}
}


