package juego;

import java.awt.Image;


import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	
	 private double x;
	 private double y;
	 private int vidas;
	 private double angulo;
	 private int balas;
	
	 //Imagenes de princesa
	 
	 private Image derecha;
	 private Image izquierda;
	 private Image quieta;
	 private Image saltando1;
	 private Image saltando2;
	 private Image disparando;

	public Princesa(int x, int y, int vidas){
		this.x = x;
		this.y = y;
		this.vidas=vidas;
		this.balas=20;
		
		//Carga de nuevas imagenes
		this.derecha = Herramientas.cargarImagen("caminando1.png");
		this.izquierda = Herramientas.cargarImagen("caminandoI1.png");
		this.quieta = Herramientas.cargarImagen("parada1.png");
		this.saltando1 = Herramientas.cargarImagen("saltando1.png");
		this.saltando2 = Herramientas.cargarImagen("saltando2.png");
		this.disparando = Herramientas.cargarImagen("disparando.png");
	}

	public void dibujarse(Entorno entorno) { //Se agregaron los sprites a dibujarse
		
			if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
				entorno.dibujarImagen(this.derecha , this.x, this.y, this.angulo, 1.8);
			}
			else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
				entorno.dibujarImagen(this.izquierda, this.x, this.y, this.angulo, 1.8);
			}
			else if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
				entorno.dibujarImagen(this.disparando, this.x, this.y, this.angulo, 1.8);
			}
			
			else {
				entorno.dibujarImagen(this.quieta, this.x, this.y, this.angulo, 1.8);
			}
		
	}
	public void saltar(Entorno entorno) { //Recibe entorno para poder dibujar el salto
	if(this.y>200) {
		this.y= this.y - 6;
		entorno.dibujarImagen(this.saltando1, this.x, this.y, this.angulo, 1.8);
		
	}
	}
	public void bajar(Entorno entorno) { //Recibe entorno para poder dibujar el salto
		if(this.y<=385) {
			this.y=this.y+4;
			entorno.dibujarImagen(this.saltando2, this.x, this.y, this.angulo, 1.8);
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

	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
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
