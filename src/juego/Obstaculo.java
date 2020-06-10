package juego;

import java.awt.Color;
import java.util.Random;

import entorno.Entorno;

public class Obstaculo {
	
	private double x;
	private double y;
	private double angulo;
	private double ancho;
	private double alto;
	private Color color;
	private boolean crece;

	
	public Obstaculo(double x, Color color, boolean crece ) {
		this.x=x;
		this.y=422;
		this.ancho=50;
		this.alto=50;
		this.angulo=0;
		this.color=color;
		this.crece=crece;
			
		
	}
	public void dibujarse(Entorno entorno) {
		
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, this.angulo, this.color);
		if(this.crece && this.x<400) {
			this.crecer();
		}
		
	}
	public void avanzar() {
		if(this.x>1) {
		this.x=x-0.5;
		}
		
		else {
		this.x=7000;
		
		}
	}
	public void crecer() {
		

		this.alto=100;
		this.y=400;
	}
	
}
