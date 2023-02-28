package loteria;
import java.lang.Math;
import java.util.Scanner;   //se hace la importaci�n de la clase SCANNER para leer por teclado

public class Arrays_Loteria {

	public static void main(String[] args) {
		int vector_boleto[]= new int[10];
		int i=0;
		// Primero se guardan los elementos en el vector de enteros
		for (i=0;i<9;i++)
		{
			// El generador de n�meros aleatorios es de tipo DOUBLE, se pone (int) para convertir a tipo entero
			//Si pon�a el numero 99 en donde generaba los n�meros aleatorios, generaba n�meros por encima de 100
			vector_boleto[i] = (int) (Math.floor(Math.random()*90+10));
		}
		// Segundo se muestra por pantalla los n�meros introducidos
			System.out.println("Bienvenido a participar a la loter�a online");
			System.out.println("-- A continuaci�n se le dar� el boleto --");
		    System.out.println("-- El boleto generado es el siguiente  --");
		    System.out.println("");
		for(i=0;i<9;i++)
		{
			System.out.print(" "+vector_boleto[i]+" ");
		}
		//Tercero Pedimos al ususario que vaya introduciendo los datos para adivinar el boleto
		Scanner resultado = new Scanner(System.in);  //preparaci�n para leer por teclado
		int vector_comprobacion[]= new int[15];   //Para guardar el n�mero acertado
		int comprobacion=0;   //Numero que ir� comprobando si se ha acertado o no y en el caso que s�, ser� guardado en los vectores anteriores
		int contador_intentos=0;
		int pivote=0;		//Pivote que recorrer� los vectores de indices y de numeros acertados
		String boleto="";
		
		//Primer numero buscado //
		
		do {
		System.out.println("");
		System.out.println("Introduzca un n�mero para comprobar si ha acertado:");
		System.out.println("");
		comprobacion= resultado.nextInt();
	
		for(i=0;i<9;i++)
		{
			boolean encontrado=false;    //Booleano que dice si se ha encontado el numero o no
			if(vector_boleto[i]==comprobacion)
			{
					System.out.println("Ha acertado el n�mero del boleto!!!");
					vector_comprobacion[pivote]=comprobacion;
					boleto="";  //Se inicializa el STRING boleto para poner despu�s los numeros acertados
					pivote=0;
					  for(i=0;i<9;i++)
						{
							
							//Primero se comprueba si se ha acertado para luego eliminarlo del boleto sustituyendo XX
							if(vector_boleto[i]==vector_comprobacion[pivote])
							{
								boleto=boleto+"  XX";
								i=i+1;   //El boleto ya no incluye el numero adivinado por eso se adelanta el indice siguiente
								pivote=pivote+1;
							}
							boleto= boleto+"  "+vector_boleto[i];
						}
				System.out.println("El boleto queda actualizado de la siguiente manera:");
				System.out.print(boleto);
				encontrado=true;
			}
			if(i==8 && encontrado==false)
			{
				System.out.println("El n�mero: " +comprobacion+" no existe.");
				for(i=0;i<9;i++)
				{
					System.out.print(" "+vector_boleto[i]+" ");
				}
			}
		 }
		contador_intentos=contador_intentos+1;  //Se contabiliza el intento actual
	    }while(contador_intentos<15);
	
		System.out.println("");
		System.out.println("");
		for(i=0;i<10;i++)
		{
			System.out.println("Acertado: "+vector_comprobacion[i]);
		}
	}
}
