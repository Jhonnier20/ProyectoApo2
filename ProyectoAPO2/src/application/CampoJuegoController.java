package application;

import java.security.SecureRandom;

import com.sun.glass.events.MouseEvent;

import hilos.HiloDisparo;
import hilos.HiloTiempo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class CampoJuegoController {
	
	@FXML private ImageView  jugador;
//	@FXML private ImageView edificio1;
//	@FXML private ImageView edificio2;
//	@FXML private ImageView edificio3;
//	@FXML private ImageView edificio4;
//	@FXML private ImageView edificio5;
//	@FXML private ImageView edificio6;
//	@FXML private ImageView edificio7;
//	@FXML private ImageView edificio8;
//	@FXML private ImageView edificio9;
	@FXML private Label tiempo;
	@FXML private Circle disparo;
	@FXML private Rectangle pane;
	private boolean control;
	private boolean juego;
	private HiloDisparo hDisparo;
	private HiloTiempo hTiempo;
	private Timeline animation;
	
	public void initialize() {
		juego = true;
		control = true;
		hTiempo = new HiloTiempo(this);
		hDisparo = new HiloDisparo(Main.getNivel().getJugador().getDisparo(), this);
		disparo.setVisible(false);
		disparo.setLayoutX(Main.getNivel().getJugador().getDisparo().getPosX());
		disparo.setLayoutY(Main.getNivel().getJugador().getDisparo().getPosY());
		
		animation = new Timeline(new KeyFrame(Duration.millis(30), new EventHandler<ActionEvent>() {
			
			int dx = 5;
			
			
			@Override
			public void handle(ActionEvent a) {
//				hTiempo.run();
				Main.getNivel().getJugador().setPosX(Main.getNivel().getJugador().getPosX()+dx);
				jugador.setLayoutX(Main.getNivel().getJugador().getPosX());
				jugador.setLayoutY(Main.getNivel().getJugador().getPosY());
				
				if(Main.getNivel().getJugador().getPosX()>= 385) {
					Main.getNivel().getJugador().setPosX(0);
					Main.getNivel().getJugador().setPosY(Main.getNivel().getJugador().getPosY()+30);
				}
				
				disparo.setLayoutX(Main.getNivel().getJugador().getDisparo().getPosX());
				disparo.setLayoutY(Main.getNivel().getJugador().getDisparo().getPosY());
				
				if(Main.getNivel().getJugador().getDisparo().getPosY()>518) {
					control = false;
				}
				
				pane.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event arg0) {
						disparo.setVisible(true);
//						hDisparo.run();
					}
				});
				
			}
		}));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
	}

	public boolean isControl() {
		return control;
	}

	public void setControl(boolean control) {
		this.control = control;
	}

	public boolean isJuego() {
		return juego;
	}

	public void setJuego(boolean juego) {
		this.juego = juego;
	}

	public Label getTiempo() {
		return tiempo;
	}

	public void setTiempo(Label tiempo) {
		this.tiempo = tiempo;
	}
	
	
	
}
