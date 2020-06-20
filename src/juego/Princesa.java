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
	 private Image saltando1;
	 private Image saltando2;
	 private Image disparando;
	 
	 //Caminando ------------------- Efecto
	 private Image caminando1;
	 private Image caminando2;
	 private Image caminando3;
	 private Image caminando4;
	 private Image caminando5;

	public Princesa(int x, int y, int vidas){
		
		if(x!=200 || y!=400 || vidas!=3) {
			
			throw new RuntimeException("la posición inicial es x=200, y=400,vidas=3");
		}
		
	
		else {
	
		
		this.x = x;
		this.y = y;
		this.vidas=vidas;
		this.balas=200;
		
		//Carga de nuevas imagenes
		this.derecha = Herramientas.cargarImagen("Sprites princesa/caminando1.png");
		this.izquierda = Herramientas.cargarImagen("Sprites princesa/caminandoI1.png");
		this.saltando1 = Herramientas.cargarImagen("Sprites princesa/saltando1.png");
		this.saltando2 = Herramientas.cargarImagen("Sprites princesa/saltando2.png");
		this.disparando = Herramientas.cargarImagen("Sprites princesa/disparando.png");
		
		//Nuevos Sprites
		this.caminando1 = Herramientas.cargarImagen("Sprites princesa/caminando1.png");
		this.caminando2 = Herramientas.cargarImagen("Sprites princesa/caminando2.png");
		this.caminando3 = Herramientas.cargarImagen("Sprites princesa/caminando3.png");
		this.caminando4 = Herramientas.cargarImagen("Sprites princesa/caminando4.png");
		this.caminando5 = Herramientas.cargarImagen("Sprites princesa/caminando5.png");
		}

	}
	
	public void dibujarse(Entorno entorno, int animar) { //Se agregaron los sprites a dibujarse
		
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
				
				if (animar >= 0 && animar < 10) {
					entorno.dibujarImagen(this.caminando1, this.x, this.y, this.angulo, 1.8);
				}
				else if (animar >= 10 && animar < 20) {
					entorno.dibujarImagen(this.caminando2, this.x, this.y, this.angulo, 1.8);
				}
				else if (animar >= 20 && animar < 30) {
					entorno.dibujarImagen(this.caminando3, this.x, this.y, this.angulo, 1.8);
				}
				else if (animar >= 30 && animar < 40) {
					entorno.dibujarImagen(this.caminando4, this.x, this.y, this.angulo, 1.8);
				}
				else {
					entorno.dibujarImagen(this.caminando5, this.x, this.y, this.angulo, 1.8);
				}
				
			}
		
	}
	public void saltar(Entorno entorno) { //Recibe entorno para poder dibujar el salto
	
		if(getY()>200) {
		setY(getY()-6);
		entorno.dibujarImagen(this.saltando1, this.x, this.y, this.angulo, 1.8);
		
		
	}
	
	}
	public void bajar(Entorno entorno) { //Recibe entorno para poder dibujar el salto
		
		if(getY()<=385) {
			setY(getY()+4);
			entorno.dibujarImagen(this.saltando2, this.x, this.y, this.angulo, 1.8);
		}
	}

	public void avanzar() {
		
		if(getX()<300) {
			setX(getX()+2);
		}
	}
	
	public void retroceder() {
		
		if(getX()>50) {
			setX(getX() -2);
		}
		
	}

	//Getters and Setters-------------------------------------------------------------
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}

	
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) { //Vidas mayor que cero
		
		if (vidas < 0) {
			throw new RuntimeException("Las vidas no pueden ser menor que cero.");
		}
		else {
			this.vidas = vidas;
		}
		
	}
	public double getAngulo() {
		return angulo;
	}
	public void setAngulo(double angulo) {  //Invariante de representacion del angulo
		
		if (angulo != 0) {
			throw new RuntimeException("El angulo solo puede ser cero.");
		}
		else {
			this.angulo = angulo;
		}
		
	}
	public int getBalas() {
		return balas;
	}
	public void setBalas(int balas) {
		this.balas = balas;
	}
	public void setX(double x) { // x entre 51 y 299 estricto
		
		if (x < 50 || x > 300) {
			throw new RuntimeException("x debe encontrarse entre los valores 51 y 299");
		}
		else {
			this.x = x;
		}
		
	}
	public void setY(double y) {
		this.y = y;
	}

	
	
	

}
