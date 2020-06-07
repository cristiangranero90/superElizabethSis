package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	
	
	
	 private Image imagen;
	 private double x;
	 private double y;
	 private int vidas;
	 private double angulo;
	 private  boolean salta;
	 private int balas;
	
	
	
	public Princesa(int x, int y, int vidas){
		this.x = x;
		this.y = y;
		this.imagen= Herramientas.cargarImagen("princesa1.png");
		this.vidas=vidas;
		this.balas=20;
		
		
		
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	
	
	
	public void dibujarse(Entorno entorno) {
		
			entorno.dibujarImagen(imagen, this.x, this.y, this.angulo, 0.1);
		
	}
	public void saltar() {
	if(this.y>200) {
		this.y= this.y - 6;
	}
	}
	public void bajar() {
		if(this.y<=385) {
			this.y=this.y+4;
		}
	}

	public void avanzar() {
		if(this.x<300) {
			this.x= this.x +2;
		}
	}
	
	public void retroceder() {
		if(this.x>50) {
			this.x=this.x-2;
		}
		
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	public double getAngulo() {
		return angulo;
	}
	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	public boolean isSalta() {
		return salta;
	}
	public void setSalta(boolean salta) {
		this.salta = salta;
	}
	public int getBalas() {
		return balas;
	}
	public void setBalas(int balas) {
		this.balas = balas;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}

	
	
	

}
