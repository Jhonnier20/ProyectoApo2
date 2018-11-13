package application;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class DificultadController {

	@FXML private Button facil;
	@FXML private Button intermedio;
	@FXML private Button dificil;
	@FXML private Button volver;
	@FXML private Button jugar;
	@FXML private TextArea contexto;
	
	public void intialize() {
		contexto.setEditable(false);
	}
	
	public void facil() {
		contexto.setText("FACIL");
	}
	
	public void intermedio() {
		contexto.setText("INTERMEDIO");
	}
	
	public void dificil() {
		contexto.setText("DIFICIL");
	}
	
	public void volver(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
			Scene scene = new Scene(root);
			Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			windows.setScene(scene);
			windows.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void jugar(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CampoJuego.fxml"));
			Scene scene = new Scene(root);
			Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			windows.setScene(scene);
			windows.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
