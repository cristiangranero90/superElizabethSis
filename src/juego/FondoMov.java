package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class FondoMov {
	private double x;
	private double y;
	private double angulo;
	private Image imagen;
	private Image suelo;
	
	
	public FondoMov(double x, double y) {
		setX(x);
		setY(y);
		
		imagen = Herramientas.cargarImagen("fondomov.png");
		suelo = Herramientas.cargarImagen("suelo.png");

	}
	public void dibujarse (Entorno entorno) {
		entorno.dibujarImagen(imagen, 400, 200, 0, 1.2);
		entorno.dibujarImagen(suelo, getX(), getY(), getAngulo(), 3.5);
	}

	public void avanzar() {
	
		if (getX() < 200) {
			setX(350);
		}
		else {
			setX(getX() - 1);
		}
		

}
	private void setX(double d) {
		// TODO Auto-generated method stub
		this.x  = d;
	}
	private double getX() {
		// TODO Auto-generated method stub
		return this.x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getAngulo() {
		return angulo;
	}
	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	
}