class Electrodomestico {
	//Atributos heredables clase Electrodomestico
	static double precioBase;
	protected double precioBaseDefecto = 100;
	String color;
	protected String colorDefecto = "Blanco";
	static char consumoEnergetico;
	protected char consumoEnergeticoDef = 'F';
	static double peso = 5;
	protected double pesoDefecto = 5;
	
	//Constructor por defecto
	Electrodomestico() {
		this.precioBase = precioFinal();
		this.color = comprobarColor(colorDefecto);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergeticoDef);
		this.peso = pesoDefecto;
	}
	
	//Constructor con el precio base y el peso
	Electrodomestico(double precioBase, double peso) {
		this.precioBase = precioBase;
		this.peso = peso;
	}
	
	//Constructor con todos los atributos
	Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
		this.precioBase = precioFinal();
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso;
	}
	
	
	//Mètodes get de los atributos
	public double getPrecioBase() {
		return precioBase;
	}

	public String getColor() {
		return color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public double getPeso() {
		return peso;
	}


	//Método para comprobar si el color es correcto. En caso de error: Color inválido
	public String comprobarColor(String color) {
		
		if(color.equalsIgnoreCase("Blanco") || color.equalsIgnoreCase("Negro") || color.equalsIgnoreCase("Rojo")
				|| color.equalsIgnoreCase("Azul") || color.equalsIgnoreCase("Gris")) {
			this.color = color;
		} else {
			this.color = "Blanco";
		}
		
		return this.color;
	}
	
	//Método para comprobar si el consumo energético es correcto. En caso de error: Z
	public char comprobarConsumoEnergetico(char consumoEnergetico) {
		
		if(consumoEnergetico == 'A' || consumoEnergetico == 'B' || consumoEnergetico == 'C' || consumoEnergetico == 'D'
				 || consumoEnergetico == 'E' || consumoEnergetico == 'F') {
			this.consumoEnergetico = consumoEnergetico;
		} else {
			this.consumoEnergetico = 'F';
		}
		
		return this.consumoEnergetico;
		
	}
	
	//Método para sumar al precio final dependiendo del consumo y del peso
	public static double precioFinal() {
		
		//Comparaciones con el consumo
		if(consumoEnergetico == 'A') {
			precioBase = precioBase + 100;
		}
		if(consumoEnergetico == 'B') {
			precioBase = precioBase + 80;
		}
		if(consumoEnergetico == 'C') {
			precioBase = precioBase + 60;
		}
		if(consumoEnergetico == 'D') {
			precioBase = precioBase + 50;
		}
		if(consumoEnergetico == 'E') {
			precioBase = precioBase + 30;
		}
		if(consumoEnergetico == 'F') {
			precioBase = precioBase + 10;
		}
		
		//Comparaciones con el peso
		if(peso >= 0 && peso <= 19) {
			precioBase = precioBase + 10;
		}
		if(peso >= 20 && peso <= 49) {
			precioBase = precioBase + 50;
		}
		if(peso >= 50 && peso <= 79) {
			precioBase = precioBase + 80;
		}
		if(peso >= 80) {
			precioBase = precioBase + 100;
		}
		
		return precioBase;
	}
	
	//Método para calcular el precio total
	public static double precioTotal() {
		double precioTotal;
		
		precioTotal = precioFinal() + Lavadora.precioFinal() + Television.precioFinal();
		
		return precioTotal;
		
	}
	
	//Sobreescribimos el método toString
	@Override
	public String toString() {
		
		return "Precio Base: " + precioBase +
				"\nColor: " + color +
				"\nConsumo Energético: " + consumoEnergetico +
				"\nPeso: " + peso +
				"\nPrecio Final: " + precioFinal() + 
				"\nPrecio Lavadora: " + Lavadora.precioFinal() + 
				"\nPrecio Television: " + Television.precioFinal() + 
				"\nPrecio Total: " + precioTotal();
	}
	
}

//Clase lavadora que hereda de la clase Electrodomestico
class Lavadora extends Electrodomestico {
	//Atributos
	double carga;
	protected double cargaDef = 5;
	
	//Constructores
	Lavadora() {
		this.carga = cargaDef;
	}
	
	Lavadora(double precioBase, double peso) {
		super(precioBase, peso);
	}
	
	Lavadora(double carga, double precioBase, String color, char consumoEnergetico, double peso) {
		super(precioBase, color, consumoEnergetico, peso);
		this.carga = cargaDef;

	}
	
	//Mètodo get de los atributos
	public double getCarga() {
		return carga;
	}
	
	//Método que llama al método de la clase padre. Y si la carga es superior a 30 se incrementa 50€ al precio base
	public double PrecioFinal() {
		
		super.precioFinal();
		
		if(this.carga > 30) {
			super.precioBase = super.precioBase + 50;
		} 
		
		return super.precioBase;
	}
}

//Clase Television que hereda de Electrodomestico
class Television extends Electrodomestico{
	//Atributos
	int resolucion;
	protected int resolucionDef = 5;
	boolean sintonizador;
	protected boolean sintonizadorDef = false;
	
	//Constructores
	Television() {
		this.resolucion = resolucionDef;
		this.sintonizador = sintonizadorDef;
	}
	
	Television(double precioBase, double peso) {
		super(precioBase, peso);
	}
	
	Television(int resolucion, boolean sintonizador, double precioBase, String color, char consumoEnergetico, double peso) {
		super(precioBase, color, consumoEnergetico, peso);
		this.resolucion = resolucionDef;
		this.sintonizador = sintonizadorDef;
	}
	
	//Mètodes get de los atributos
	public int getResolucion() {
		return resolucion;
	}

	public boolean isSintonizador() {
		return sintonizador;
	}
	
	//Método que llama al método de la clase padre. Si la resolución es superior a 40 se aumenta un 30% el precio al precio base
	//Aparte, si tiene el sintonizador activo, se le aumenta 50€ al precio base
	public double PrecioFinal() {
		
		super.precioFinal();
		
		if(resolucion > 40) {
			super.precioBase = (super.precioBase * 0.3) + super.precioBase;
		}
		
		if(sintonizador == true) {
			super.precioBase = super.precioBase + 50;
		}
		
		return super.precioBase;
	}
	 
}

//Clase main para testear
public class Main {

	public static void main(String[] args) {
		
		//Creación del arry y de sus objetos
		Electrodomestico arrayElectrodomestico[] = new Electrodomestico [10];
		
		arrayElectrodomestico[0] = new Electrodomestico();
		arrayElectrodomestico[1] = new Lavadora();
		arrayElectrodomestico[2] = new Television();
		arrayElectrodomestico[3] = new Electrodomestico();
		arrayElectrodomestico[4] = new Lavadora();
		arrayElectrodomestico[5] = new Television();
		arrayElectrodomestico[6] = new Electrodomestico();
		arrayElectrodomestico[7] = new Lavadora();
		arrayElectrodomestico[8] = new Television();
		arrayElectrodomestico[9] = new Electrodomestico();

		
		//Recorrer el array y mostrar por pantalla el resultado del método toString()
		for (int i = 0;i < arrayElectrodomestico.length;i++){
			System.out.println(arrayElectrodomestico[i].toString());
            System.out.println();
        }

	}

}
