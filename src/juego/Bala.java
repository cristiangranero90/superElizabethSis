package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Bala {

	private double x;
	private double y;
	private double angulo;
	private Image imagen;
	
	
	 
	
	public Bala(double x, double y) {
		this.x=x;
		this.y=y;
		
		
		imagen = Herramientas.cargarImagen("bala.png");
		
	}
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imagen, this.x, this.y, this.angulo, 0.1);
	}
	public void avanzar() {
		
		if(this.x<800) {
			
			this.x=this.x+3;
		}
		
	}
	public boolean choque(Soldado soldado) {

			double distancia=Math.sqrt((Math.pow((this.getX() - soldado.getX()),2))+(Math.pow(this.getY()-soldado.getY(), 2)));
			
			if(distancia<10) {
				return true;
			}else {
				return false;
			}
		
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
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
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	
	
}
