package hilos;

import application.CampoJuegoController;
import modelo.Disparo;

public class HiloDisparo implements Runnable {
	
	private Disparo disparo;
	private CampoJuegoController campo;

	public HiloDisparo(Disparo disparo, CampoJuegoController campo) {
		this.disparo = disparo;
		this.campo = campo;
	}

	@Override
	public void run() {
		while(campo.isControl()) {
			disparo.setPosY(disparo.getPosY()-3);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
