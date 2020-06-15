package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Hongo {
	private double x;
	private double y;
	private double angulo;
	private int vida;
	private Image imagen;
	private boolean ganarVida;
	
	
	
	public Hongo(double x, double y) {
		this.x=x;
		this.y=y;

		
		
		imagen = Herramientas.cargarImagen("Hongo.png");
	}

	public void avanzar() {
		if(this.x>0) {
			this.x=x-1;
		}
		else{
			this.x=1000;
	
	}
	}

		
		public void dibujarse(Entorno entorno) {
			
			entorno.dibujarImagen(imagen,this.x, this.y,this.angulo, 0.4);
			
			}
			
		

		public boolean colisionPrincesa(Princesa princesa) {
			
			
			double distancia=Math.sqrt((Math.pow((princesa.getX() - this.getX()),2))+(Math.pow(princesa.getY()-this.getY(), 2)));
			
			if(distancia<=50 ) {
				
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

		public int getVida() {
			return vida;
		}

		public void setVida(int vida) {
			this.vida = vida;
		}

		public void setganarVida(boolean x) {
			this.ganarVida = x;
		}
		public boolean getganarVida() {
			return this.ganarVida;

			
		}
}