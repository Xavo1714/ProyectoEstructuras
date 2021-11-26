import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
	public static ArrayList<Integer> numbersArrays = new ArrayList<>();

	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("QuickSort");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args){
		launch(args);
	}

	public static void setNumbers(ArrayList<Integer> arr){
		numbersArrays = arr;
	}

	public static ArrayList<Integer> getNumbers(){
		return numbersArrays;
	}
}

