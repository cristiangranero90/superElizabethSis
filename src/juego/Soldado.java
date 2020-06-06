package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Soldado {

	
	private double x;
	private double y;
	private double angulo;
	private Image imagen;
	
	
	public Soldado(double x, double y) {
		this.x=x;
		this.y=y;
		
		
		imagen = Herramientas.cargarImagen("soldado.png");
		
	}
	public void avanzar() {
		if(this.getX()>=0) {
			this.setX(this.getX()-2);
		}
		else {
			this.setX(3000);
		}
	}
	
	public void dibujarse(Entorno entorno) {
		
		entorno.dibujarImagen(imagen, this.x, this.y, this.angulo, 0.2);
		
		
	}
	
	public void desaparece() {
		
		
	}
	
	
	public boolean colision(Princesa princesa, Soldado soldado) {
		
		
		double distancia=Math.sqrt((Math.pow((princesa.getX() - soldado.getX()),2))+(Math.pow(princesa.getY()-soldado.getY(), 2)));
		
		if(distancia<=50 ) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean colisionBala(Bala bala) {
		
		double distancia=Math.sqrt((Math.pow((bala.getX() - this.getX()),2))+(Math.pow(bala.getY()-this.getY(), 2)));
		
		if(distancia<50) {
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
