package juego;

import java.awt.Color;

import entorno.Entorno;

public class Obstaculo {
	
	private double x;
	private double y;
	private double angulo;
	private double ancho;
	private double alto;
	private Color color;

	
	public Obstaculo(double x, double y, double ancho, double alto, double angulo, Color color ) {
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.angulo=angulo;
		this.color=color;
		
	}
	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, this.angulo, this.color);
	}
	public void avanzar() {
		if(this.x>1) {
		this.x=x-1;
		}else {
		this.x=1500;
		
		}
	}
	public void crecer() {
		
	}

	
}
