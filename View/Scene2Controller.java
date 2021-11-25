import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scene2Controller implements Initializable{
	@FXML
	public void initialize(URL arg0,ResourceBundle arg1){
        System.out.println("Hola : " + Main.getNumbers());
	}

	@FXML
	private void goToScene1(ActionEvent event) throws IOException{
		Parent scene2 = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		Scene sc2 = new Scene(scene2);
		Stage app = (Stage)((Node)event.getSource()).getScene().getWindow();

		app.setScene(sc2);
		app.show();
	}
}
