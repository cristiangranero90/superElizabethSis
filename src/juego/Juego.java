package juego;


import java.awt.Color;
import java.awt.Image;
import java.util.Random;

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
	private Obstaculo [] obstaculos;
	private Random r;
	private Color []c;
	
	
	
	// agregar obstaculos;
	
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
		
		r = new Random();
			
		//ejemplo de array de colores, podrìa ser imagenes para los obstaculos.
		this.c= new Color [] {Color.BLACK,Color.blue, Color.white, Color.yellow, Color.cyan};
		
		int a=800; //variable para que aparezcan los obstaculos.
		int k;
		this.obstaculos= new Obstaculo[20];
		
		for(int i =0;i<this.obstaculos.length;i++) {
			k=r.nextInt(3);
		
			if(k==2) {
			this.obstaculos[i]=new Obstaculo(a,c[r.nextInt(4)],true);
			}else {
				this.obstaculos[i]=new Obstaculo(a,c[r.nextInt(4)],false);
			}
			//esta es la separacion de cada obstaculo. Como vuelven a empezar desde atras, hay que calcular para
			//que no se solapen entre si.
			a=a+350; 
			
			
		}
		
		
		
		
		/*se crean los 15 soldados
		 * */
		
		int j=800;
		
		this.soldados = new Soldado[15];
		
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


		if(!this.ganado() && princesa.getVidas()>0)  {


			for(int i=0;i<this.obstaculos.length;i++) {
				
				if(!this.obstaculos[i].colisionPrincesa(princesa)){
					this.obstaculos[i].setHaceDaño(true);
				}
				this.obstaculos[i].dibujarse(entorno);
				this.obstaculos[i].avanzar();
				
				

				if(this.obstaculos[i].colisionPrincesa(princesa) && this.obstaculos[i].getHaceDaño()  ) {
					this.princesa.setVidas(princesa.getVidas()-1);
					this.obstaculos[i].setHaceDaño(false);
				}
				
			}

			for(int i=0;i<this.soldados.length;i++) {
				if(this.soldados[i]!= null) 
				{
					if(!this.soldados[i].colisionPrincesa(princesa) && this.soldados[i]!=null){
						this.soldados[i].setHaceDaño(true);
					}
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
				
				if(this.soldados[i]!=null && this.soldados[i].colisionPrincesa(princesa) && this.soldados[i].getHaceDaño()  ) {
					princesa.setVidas(princesa.getVidas()-1);
					this.soldados[i].setHaceDaño(false);
				}
				
				
			
				
			}
		princesa.dibujarse(entorno);
		
	
	//dibujo de disparo		
		if(this.disparo && this.bala!=null) {
			
			this.bala.dibujarse(entorno);
			this.bala.avanzar();
	
		}

	//salto de princesa
		if(this.salto) {
			princesa.saltar(entorno);
		}
		if(princesa.getY()<202) {
			this.salto=false;
		}
		if(!this.salto) {
			princesa.bajar(entorno);
			
		}

		
	//lectura de teclado
		
		
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
		}
		
		else if(princesa.getVidas()==0) {
			entorno.cambiarFont("Arial", 100, Color.BLUE);
			entorno.escribirTexto("Perdiste!!!! ", 200, 300);
		}
		
		else 

		{
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
