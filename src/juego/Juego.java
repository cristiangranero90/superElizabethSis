package juego;

import java.awt.Color;
import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	
	private Entorno entorno;
	private Princesa princesa;
	private boolean salto;
	private Bala bala;
	private Soldado [] soldados;
	private boolean disparo;
	private int puntos;
	private int cantidadSoldados;
	private Obstaculo [] obstaculos;
	private Hongo [] hongo;
	private FondoMov fondomov;
	

	private int animar;
	
	Juego()
	
	{
		

		this.entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 2 - v1", 800, 600);
		this.fondomov = new FondoMov(0,530);
		this.princesa = new Princesa();	
		this.disparo=false;
		this.salto=false;
		this.animar = 0;
		this.entorno.iniciar();
		this.crearSoldados();
		this.creaObstaculos();
		this.cearHongos();
		
	}
	
	private void cearHongos() {
		int v=1000;
		
		this.hongo = new Hongo[3];
		
		for(int i=0;i<this.hongo.length;i++) {
			this.hongo[i]=new Hongo(v,200);
			v=v+600;
			
		}	
	}



	public void crearSoldados() {
		int j=800;
		Random r = new Random();
		this.soldados = new Soldado[15];
		
		for(int i=0;i<this.soldados.length;i++) {
			this.soldados[i]=new Soldado(j);
			j=j+200+(100*r.nextInt(4));
			
			this.setCantidadSoldados(this.getCantidadSoldados()+1);
		}
		
	}
	
	public void creaObstaculos() {
	
		int a=800; //variable para que aparezcan los obstaculos.
		
		this.obstaculos= new Obstaculo[5];
		
		for(int i =0;i<this.obstaculos.length;i++) {
		
				this.obstaculos[i]=new Obstaculo(a,false);

			a=a+250; 
		}
		
	}
	//muestra hongos
	public void muestraHongos() {
		for(int i=0;i<this.hongo.length;i++) {
			if(this.princesa!= null && this.hongo[i]!=null) 
			{
				if(!this.hongo[i].colisionPrincesa(princesa)){
					this.hongo[i].setganarVida(true);
					
				}
				this.hongo[i].dibujarse(entorno);
				this.hongo[i].avanzar();
				
			if(this.hongo[i]!=null && this.princesa!=null && this.hongo[i].colisionPrincesa(princesa) && this.hongo[i].getganarVida()){
				princesa.setVidas(princesa.getVidas()+1);
				Herramientas.play("vida.wav");
				this.hongo[i].setganarVida(false);
				this.hongo[i]=null;
			
			}
				
				
			}
		}
	}

	//muestra y verifica las colisiones de obstaculos
	public void muestraObstaculos() {
		
		for(int i=0;i<this.obstaculos.length;i++) {
			
			if(!this.obstaculos[i].colisionPrincesa(princesa)){
				this.obstaculos[i].setHaceDano(true);
				
			}
			this.obstaculos[i].dibujarse(entorno);
			this.obstaculos[i].avanzar();
			
			if(this.obstaculos[i].colisionPrincesa(princesa) && this.obstaculos[i].getHaceDano()  ) {
				Herramientas.play("enemigo.wav");
				this.princesa.setVidas(princesa.getVidas()-1);
				
				this.obstaculos[i].setHaceDano(false);
				
			}
			if(this.obstaculos[i].getCrece() && this.obstaculos[i].getX()<50) {
				this.obstaculos[i].setCrece(false);
				this.obstaculos[i].achicarse();
			}


			}	
	}
	public void crecerObstaculos() {
		Random r = new Random();
		int j;
		for(int i=0;i<this.obstaculos.length;i++) {
			j=r.nextInt(3);
			
			if(this.obstaculos[i].getX()<400 && this.obstaculos[i].getX()>397 && j==2) {
				
				this.obstaculos[i].setCrece(true);
			}
		}
	}
	
	//muestra y verifica las colisiones de soldados
	public void muestraSoldados() {
		
		for(int i=0;i<this.soldados.length;i++) {
			if(this.soldados[i]!= null) 
			{
				if(!this.soldados[i].colisionPrincesa(princesa) && this.soldados[i]!=null){
					this.soldados[i].setHaceDano(true);
				}
				this.soldados[i].dibujarse(entorno, animar);
				this.soldados[i].avanzar();
				
				
				
			}
			
			if(this.bala!=null && this.soldados[i]!=null && this.soldados[i].colisionBala(this.bala)){
				Herramientas.play("enemigo.wav");
				this.soldados[i]=null;
				this.bala=null;

				this.setPuntos(this.getPuntos()+5);
				this.setCantidadSoldados(this.getCantidadSoldados()-1);
				this.disparo=false;

			}
			

			if(this.bala!=null && this.bala.getX()>799) {
				this.bala=null;
				this.disparo=false;
			}
			
			if(this.soldados[i]!=null && this.soldados[i].colisionPrincesa(princesa) && this.soldados[i].getHaceDano()  ) {
				Herramientas.play("enemigo.wav");
				princesa.setVidas(princesa.getVidas()-1);
				this.soldados[i].setHaceDano(false);
			}
	
		}
		
	}
	public void verificaSalto() {
		
		
		if(this.salto ) {
			princesa.saltar(entorno);
			
		}
		if(princesa.getY()<202) {
			this.salto=false;
		}
		if(!this.salto) {
			princesa.bajar(entorno);
			
	}
	}
	
	public void verificaDisparo() {
			if(this.disparo && this.bala!=null) {
	
			
			this.bala.dibujarse(entorno);
			this.bala.avanzar();
	
		}
	}
	
	
	
	public void tick()
	{

		if (animar >= 50) {
			animar = 0;
		}
		animar++;

		fondomov.dibujarse(entorno);
		
		if(princesa.getVidas() != 0 && !this.ganado()) {
			fondomov.avanzar();
		}
		
		if(!this.ganado() && princesa.getVidas()>0)  {

				this.muestraObstaculos();
				this.muestraSoldados();
				this.muestraHongos();
				
				princesa.dibujarse(entorno, animar);
		
				this.verificaDisparo();
				
				this.verificaSalto();
				this.crecerObstaculos();
				
	//lectura de teclado
		
		
		if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && this.disparo==false && princesa.getBalas()>0 && !entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			
			 	Herramientas.play("disparos.wav");
				this.bala = new Bala(princesa.getX(), princesa.getY());
				princesa.setBalas(princesa.getBalas()-1);
				this.disparo=true;		
		}
		
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA ) && !this.salto && princesa.getY()>385 ) {
			
			this.salto=true;
			Herramientas.play("jump.wav");
		}
		
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) 
			princesa.retroceder();

		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) 
			princesa.avanzar();
		}
		
		
		else if(princesa.getVidas()==0) {
			entorno.cambiarFont("Impact", 120, Color.GRAY);
			entorno.escribirTexto("GameOver", 160, 300);
	
		}
		
		else 

		{
			
			entorno.cambiarFont("Impact", 120, Color.BLUE);
		
			entorno.escribirTexto("Ganaste!!!! ", 160, 300);
		}

		entorno.cambiarFont("Impact", 20, Color.WHITE);
		entorno.escribirTexto("Puntos: "+this.getPuntos(), 600, 30);
		entorno.escribirTexto("Vidas: "+princesa.getVidas() , 600, 50);
		entorno.escribirTexto("Balas: "+princesa.getBalas(), 600, 70);
		entorno.escribirTexto("Soldados: "+this.cantidadSoldados , 600, 90);
	}

	
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

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public boolean ganado() {
		
	if(this.puntos==50) {
		return true;
	}
	return false;
	
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();	
	
	}

}
