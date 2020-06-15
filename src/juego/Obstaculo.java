package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Obstaculo {
	
	private double x;
	private double y;
	private double angulo;
	private double ancho;
	private double alto;
	private Color color;
	private boolean crece;
	private boolean haceDaño;
	private Image imagen;
	
	public Obstaculo(double x, Color color, boolean crece ) {
		this.x=x;
		this.y=425;
		this.ancho=50;
		this.alto=50;
		this.angulo=0;
		this.color=color;
		this.crece=crece;
			
		imagen = Herramientas.cargarImagen("planta.png");
		
	}
	public void dibujarse(Entorno entorno) {
		
		//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, this.angulo, this.color);
		entorno.dibujarImagen(imagen,this.x, this.y,this.angulo, 0.4);
		if(this.crece) {
			this.crecer();
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
	public void avanzar() {
		if(this.x>0) {
		this.x=x-1;
		}
		else{
		this.x=1200;
		
		}
	}
	public void crecer() {
		
		this.alto=150;
		this.y=400;
	}
	public void achicarse() {
		this.alto=50;
		this.y=425;
	}
	public void setHaceDaño(boolean x) {
		this.haceDaño = x;
	}
	public boolean getHaceDaño() {
		return this.haceDaño;
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
	public boolean getCrece() {
		return crece;
	}
	public void setCrece(boolean crece) {
		this.crece = crece;
	}
	}
	