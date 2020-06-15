package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class FondoMov {
	private double x;
	private double y;
	private double angulo;
	private Image imagen;
	
	
	public FondoMov(double x, double y) {
		this.x=x;
		this.y=y;
		
		imagen = Herramientas.cargarImagen("fondomov.png");

	}
	public void dibujarse (Entorno entorno) {
		entorno.dibujarImagen(imagen, 400, 200, 0, 1.2);
	}

	public void avanzar() {
	
		if(this.getX()>=0) {
			this.setX(this.getX()-1);
		
	}
	else {
		this.setX(800);
	}

}
	private void setX(double d) {
		// TODO Auto-generated method stub
		
	}
	private int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
}