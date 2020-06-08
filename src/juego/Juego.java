package juego;


import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Princesa princesa;
	private boolean salto;
	private Bala bala;
	private Soldado [] soldados;
	private boolean disparo;
	private Image fondo;
	private int puntos;
	private int cantidadSoldados;
	
	
	//setter and getter
	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}
	public void setCantidadSoldados(int x) {
		this.cantidadSoldados=x;
	}
	public int getCantidadSoldados() {
		return this.cantidadSoldados;
	}

	public Princesa getPrincesa() {
		return princesa;
	}

	public void setPrincesa(Princesa princesa) {
		this.princesa = princesa;
	}

	public boolean isSalto() {
		return salto;
	}

	public void setSalto(boolean salto) {
		this.salto = salto;
	}

	public Bala getBala() {
		return bala;
	}

	public void setBala(Bala bala) {
		this.bala = bala;
	}

	public Soldado[] getSoldados() {
		return soldados;
	}

	public void setSoldados(Soldado[] soldados) {
		this.soldados = soldados;
	}

	public boolean isDisparo() {
		return disparo;
	}

	public void setDisparo(boolean disparo) {
		this.disparo = disparo;
	}

	public Image getFondo() {
		return fondo;
	}

	public void setFondo(Image fondo) {
		this.fondo = fondo;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public boolean ganado() {
		
	if(this.puntos==100) {
		return true;
	}
	return false;
	
	}

	Juego()
	{
		// Inicializa el objeto entorno
		
		entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 2 - v1", 800, 600);
		
		fondo = Herramientas.cargarImagen("fondo.jpg");
		princesa = new Princesa(200, 385, 5);
		
		/*se crean los 15 soldados
		 * */
		
		this.soldados = new Soldado[15];
		int j=800;
		for(int i=0;i<this.soldados.length;i++) {
			this.soldados[i]=new Soldado(j,385);
			j=j+200;
			this.setCantidadSoldados(this.getCantidadSoldados()+1);
		}

		this.disparo=false;
		this.salto=false;
		
		
		
		// Inicia el juego!
		this.entorno.iniciar();
	}

	public void tick()
	{
		entorno.dibujarImagen(fondo, 0, 0, 0);
		if(!this.ganado()) {
		
		princesa.dibujarse(entorno);
		
	
		
		for(int i=0;i<this.soldados.length;i++) {
			if(this.soldados[i]!= null) 
			{
			this.soldados[i].dibujarse(entorno);
			this.soldados[i].avanzar();
			}
			if(this.bala!=null && this.soldados[i]!=null && this.soldados[i].colisionBala(this.bala)){
				this.soldados[i]=null;
				this.bala=null;
				
				this.setPuntos(this.getPuntos()+10);
				this.setCantidadSoldados(this.getCantidadSoldados()-1);
				this.disparo=false;
				
			}
			
		if(this.bala!=null && this.bala.getX()>799) {
			this.bala=null;
			this.disparo=false;
		}
			
			
		}

		if(this.disparo && this.bala!=null) {
			
			this.bala.dibujarse(entorno);
			this.bala.avanzar();
	
		}

	
		if(this.salto) {
			princesa.saltar(entorno);
		}
		if(princesa.getY()<202) {
			this.salto=false;
		}
		if(!this.salto) {
			princesa.bajar(entorno);
			
		}

		if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && this.disparo==false && princesa.getBalas()>0 && !entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
				
				this.bala = new Bala(princesa.getX(), princesa.getY());
				princesa.setBalas(princesa.getBalas()-1);
				this.disparo=true;
		}
		
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA ) && !this.salto && princesa.getY()>385 ) 
			this.salto=true;
		
		
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) 
			princesa.retroceder();
		
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) 
		princesa.avanzar();
		}else {
			entorno.cambiarFont("Arial", 100, Color.RED);
			entorno.escribirTexto("Ganaste!!!! ", 200, 300);
		}

		entorno.cambiarFont("Arial", 20, Color.BLACK);
		entorno.escribirTexto("Puntos: "+this.getPuntos(), 600, 30);
		entorno.escribirTexto("Vidas: "+princesa.getVidas() , 600, 50);
		entorno.escribirTexto("Balas: "+princesa.getBalas(), 600, 70);
		entorno.escribirTexto("Soldados: "+this.cantidadSoldados , 600, 90);

	
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
