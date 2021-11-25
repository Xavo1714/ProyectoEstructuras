import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable{
	@FXML private Spinner<Integer> mySpinner;

	@FXML
	public void initialize(URL arg0,ResourceBundle arg1){
		 SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10,1);

        mySpinner.setValueFactory(valueFactory);
	}

	@FXML
	private void goToScene2(ActionEvent event) throws IOException{
		Parent scene2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		Scene sc2 = new Scene(scene2);
		Stage app = (Stage)((Node)event.getSource()).getScene().getWindow();

		app.setScene(sc2);
		app.show();
	}
}

