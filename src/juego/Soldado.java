package juego;

import java.awt.Image;
import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;

@SuppressWarnings("unused")
public class Soldado {

	
	private double x;
	private double y;
	private double angulo;
	private boolean haceDano;
	private boolean salto;
	
	private Image soldado1;
	private Image soldado2;
	private Image soldado3;
	private Image soldado4;
	private Image soldado5;
	
	public Soldado(double x) {
		
		this.x=x;
		this.y=400;
		this.soldado1 = Herramientas.cargarImagen("SpritesSoldado/sold1.png");
		this.soldado2 = Herramientas.cargarImagen("SpritesSoldado/sold2.png");
		this.soldado3 = Herramientas.cargarImagen("SpritesSoldado/sold3.png");
		this.soldado4 = Herramientas.cargarImagen("SpritesSoldado/sold4.png");
		this.soldado5 = Herramientas.cargarImagen("SpritesSoldado/sold5.png");
		
	}
	public void avanzar() {
	
		if(getX()>=0) {
			setX(getX()-1.5);
			
		}
		else {
			setX(3000);
		}
	}
	
	public void dibujarse(Entorno entorno, int animar) {
		
		if (animar >= 0 && animar < 10) {
			entorno.dibujarImagen(this.soldado1, this.x, this.y, this.angulo, 0.9);
		}
		else if (animar >= 10 && animar < 20) {
			entorno.dibujarImagen(this.soldado2, this.x, this.y, this.angulo, 0.9);
		}
		else if (animar >= 20 && animar < 30) {
			entorno.dibujarImagen(this.soldado3, this.x, this.y, this.angulo, 0.9);
		}
		else if (animar >= 30 && animar < 40) {
			entorno.dibujarImagen(this.soldado4, this.x, this.y, this.angulo, 0.9);
		}
		else {
			entorno.dibujarImagen(this.soldado5, this.x, this.y, this.angulo, 0.9);
		}
		
		
	}
	
	public boolean colisionPrincesa(Princesa princesa) {
		
		
		double distancia=Math.sqrt((Math.pow((princesa.getX() - this.getX()),2))+(Math.pow(princesa.getY()-this.getY(), 2)));
		
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

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	public void setHaceDano(boolean x) {
		this.haceDano = x;
	}
	public boolean getHaceDano() {
		return this.haceDano;
	}
	public void setSalto(boolean salto) {
		this.salto=salto;
	}
	public boolean getSalto() {
		return this.salto;
	}
	
	
	
	
}
