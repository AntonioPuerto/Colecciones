package ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Keyboard {
	static Scanner kb = new Scanner(System.in);
	public enum Range{GREATEREQUAL, LESSEREQUAL, GREATER, LESS, EQUAL, BOTHIN , BOTHOUT , MININ , MAXIN}
	//1. Se cierra el teclado.
	public static void close() {
		kb.close();
	}
	//1. Se le pide al usuario un carácter y se controla que si se equivoca se le vuelva a pedir. Al terminar se devuelve el valor.
	public static char charInput() {
		String cadena="";
		char character=' ';
		boolean error;
		do {
			cadena = kb.nextLine();
			error = false;
			if (cadena.length() > 0) {
				character=cadena.charAt(0);
			} else {
				error = true;
			} 
		} while (error);
		return character;
	
	}	
	//1. Se le pide al usuario que introduzca una cadena. Al terminar se devuelve el valor.
	public static String stringInput() {
		String string="";
		do {
			string = kb.nextLine();
		} while (string.length()<1);
		return string;
	}	
	 /* 1.Se le pasa al usuario una pregunta y dos opciones. El usuario sólo podrá introducir 1 ó 2 para seleccionar opciones.  
	 * 	1.1 Para que el usuario no introduzca datos diferentes a 1 ó 2, controlaremos la entrada y la repetiremos tantas veces como haga falta.
	 * 2. Al terminar se devuelve verdadero si el usuario elige 1 y falso si elige 2.
	 */
	public static boolean booleanInput(String title, String option1, String option2) {
		int opt = 0;
		
		try {
			System.out.printf("%s\n1.%s\n2.%s\n",title,option1,option2);
			opt=range(Range.BOTHIN,2,1);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		//1.1 Para que el usuario no introduzca datos diferentes a 1 ó 2, controlaremos la entrada y la repetiremos tantas veces como haga falta.
		if(opt==1) {//2. Al terminar se devuelve verdadero si el usuario elige 1 y falso si elige 2.
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 1. Se le pasa al usuario una pregunta y el usuario tendrá dos opciones, Sí(s) o No(n).
	 * 2. El usuario sólo podrá responder con s o n, independientemente si es mayúsculas o minúscula, por lo que controlaremos la entrada del usuario, y la repetiremos si hace falta.
	 * 3. Al terminar se devuelve verdadero si el usuario escribe s y falso si escribe n.
	 */
	public static boolean booleanInput(String title) {
		String yesOrNo;
		do {
			System.out.printf("%s\t(s/n)",title);
			yesOrNo=stringInput().toLowerCase();
		//2. El usuario sólo podrá responder con s o n, independientemente si es mayúsculas o minúscula, por lo que controlaremos la entrada del usuario, y la repetiremos si hace falta.
		}while(!yesOrNo.equals("s") && !yesOrNo.equals("n"));
		if(yesOrNo.equals("s")) {//3. Al terminar se devuelve verdadero si el usuario escribe s y falso si escribe n.
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 1. Se le pide al usuario un número y se controla que no meta nada diferente.
	 * 2. Se le volverá a pedir mientras el dato no sea válido.
	 * 3. Al final se devuelve el valor.
	 */
	
	public static int intInput() {
		boolean error;
		int num = 0;
		do {
			try {//1. Se le pide al usuario un número y se controla que no meta nada diferente.
				num = kb.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error en la introducción de datos.");
				error = true;
			} finally {
				kb.nextLine();
			}
		} while (error);// 2. Se le volverá a pedir mientras el dato no sea válido.
		return num;// 3. Al final se devuelve el valor.
	}
	/*
	 * 1. Se le pide al usuario un valor siempre que sea mayor (o mayor o igual), menor (o menor o igual) o igual que un parámetro que se le da.
	 * 2. Se le pedirá mientras el valor no sea un número dentro del rango.
	 */
	public static int valueGiven(Range menormayor, int number) {
		int num=0;
		//1. Se le pide al usuario un valor siempre que sea mayor (o mayor o igual), menor (o menor o igual) o igual que un parámetro que se le da.
		if(menormayor==Range.GREATEREQUAL) {
			do{
				num=intInput();
			}while(num<number);
			//2. Se le pedirá mientras el valor no sea un número dentro del rango.
		}else if(menormayor==Range.LESSEREQUAL) {
			do{
				num=intInput();
			}while(num>number);
		}else if(menormayor==Range.GREATER) {
			do {
				num=intInput();
			}while(num<=number);
		}else if(menormayor==Range.LESS) {
			do{
				num=intInput();
			}while(num>=number);
		}else if(menormayor==Range.EQUAL) {
			do{
				num=intInput();
			}while(num!=number);
		}
		return num;
	}
	/*
	 * 1. Se le pedirá al usuario un número dentro de un rango dado.
	 * 	1.1 El rango necesitará de dos números, uno mayor y otro menor y si no es así lanzaremos un error.
	 * 2. Si los valores límites son 1 y 10, el rango podrá ser con los dos números incluidos (1-10), ambos excluidos (2-9), el mayor incluido (2-10) y el menor incluido(1-9)
	 */
	public static int range(Range menormayor, int max, int min) throws IllegalArgumentException {
		int number=0;		
		if(max<min) {
			throw new IllegalArgumentException("El mínimo no puede ser mayor");
			//1.1 El rango necesitará de dos números, uno mayor y otro menor y si no es así lanzaremos un error.
		}else {
			////1. Se le pedirá al usuario un número dentro de un rango dado.
			if(menormayor==Range.BOTHIN) {
			//2. Si los valores límites son 1 y 10, el rango podrá ser con los dos números incluidos (1-10), ambos excluidos (2-9), el mayor incluido (2-10) y el menor incluido(1-9)
				do {
					number=intInput();
				}while(number<min || number>max);
			}else if(menormayor==Range.BOTHOUT) {
				do {
					number=intInput();
				}while(number<=min || number>=max);
			}else if(menormayor==Range.MININ) {
				do {
					number=intInput();
				}while(number<min || number>=max);
			}else if(menormayor==Range.MAXIN) {
				do {
					number=intInput();
				}while(number<=min ||number>max);
			}
		}
		return number;
	}
	// 1. Se le pide al usuario un número y se controla que sea un número no mayor que 127 o menor que -128, si lo es se le volverá a pedir tantas veces como haga falta.
	public static byte byteInput() {
		boolean error;
		byte num = 0;
		do {
			try {
				num = kb.nextByte();//1. Se le pide al usuario un número
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error en la introducción de datos.");
				error = true;
			}catch(NumberFormatException e) {
				error=true;
				System.out.println("Has excedido los valore límites.");
				// y se controla que sea un número no mayor que 127 o menor que -128 
			} finally {
				kb.nextLine();
			}
		} while (error);//si lo es se le volverá a pedir tantas veces como haga falta.
		return num;
	}
	/*
	 * 1.Mismo planteamiento valueGiven() anterior
	 * 2. Como los valores límites son de -128 a 127, hay que controlar que no se le pida al usuario un valor mayor al máximo o menor al mínimo
	 */
	public static byte valueGiven(Range menormayor,byte number) throws NumberFormatException{
		byte num=0;
		if(number<-128 || number>127) {
			throw new NumberFormatException("Parámetro superior al valor límite");
		}
		else {
			if(menormayor==Range.GREATEREQUAL) {
			
			do{
				num=byteInput();
			}while(num<number);
			
			}else if(menormayor==Range.LESSEREQUAL) {
				do{
					num=byteInput();
				}while(num>number);
			}else if(menormayor==Range.GREATER) {
				do {
					num=byteInput();
				}while(num<=number);
			}else if(menormayor==Range.LESS) {
				do{
					num=byteInput();
				}while(num>=number);
			}else if(menormayor==Range.EQUAL) {
				do{
					num=byteInput();
				}while(num!=number);
			}
		}
		return num;
	}
	/*
	 * Planteamiento igual que anterior range.
	 * 2. Si el máximo y/o el mínimo superan los valores límites lanzaremos un aviso
	 */
	public static byte range(Range menormayor, byte max, byte min) throws IllegalArgumentException , NumberFormatException {
		byte number=0;
		if(max<min) {
			throw new IllegalArgumentException("El mínimo no puede ser mayor");
		}else if(max>127 || min<-128) {
			throw new NumberFormatException("Parámetros exceden los valores límites");
		}else {
			if(menormayor==Range.BOTHIN) {
				do {
					number=byteInput();
				}while(number<min || number>max);
			}else if(menormayor==Range.BOTHOUT) {
				do {
					number=byteInput();
				}while(number<=min || number>=max);
			}else if(menormayor==Range.MININ) {
				do {
					number=byteInput();
				}while(number<min || number>=max);
			}else if(menormayor==Range.MAXIN) {
				do {
					number=byteInput();
				}while(number<=min || number>max);
			}
		}
		return number;
	}
	/*
	 * Las funciones que piden un número tienen el mismo planteamiento que intInput()
	 * Las funciones valueGiven() tienen todas el mismo planteamiento, asímismo las range()
	 */
	public static short shortInput(){
		boolean error;
		short num = 0;
		do {
			try {
				num = kb.nextShort();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error en la introducción de datos.");
				error = true;
			}catch (NumberFormatException e) {
				error=true;
				System.out.println("Has excedido los valore límites.");
			} finally {
				kb.nextLine();
			}
		} while (error);
		return num;
	}
	public static short valueGiven(Range menormayor, short number) {
		short num=0;
		if(menormayor==Range.GREATEREQUAL) {
			do{
				num=shortInput();
			}while(num<number);
			
		}else if(menormayor==Range.LESSEREQUAL) {
			do{
				num=shortInput();
			}while(num>number);
		}else if(menormayor==Range.GREATER) {
			do {
				num=shortInput();
			}while(num<=number);
		}else if(menormayor==Range.LESS) {
			do{
				num=shortInput();
			}while(num>=number);
		}else if(menormayor==Range.EQUAL) {
			do{
				num=shortInput();
			}while(num!=number);
		}
		return num;
	}
	public static short range(Range menormayor, short max, short min) throws IllegalArgumentException {
		short number=0;
		if(max<min) {
			throw new IllegalArgumentException("El mínimo no puede ser mayor");
		}else {
			if(menormayor==Range.BOTHIN) {
				do {
					number=shortInput();
				}while(number<min || number>max);
			}else if(menormayor==Range.BOTHOUT) {
				do {
					number=shortInput();
				}while(number<=min || number>=max);
			}else if(menormayor==Range.MININ) {
				do {
					number=shortInput();
				}while(number<min || number>=max);
			}else if(menormayor==Range.MAXIN) {
				do {
					number=shortInput();
				}while(number<=min || number>max);
			}
		}
		return number;
	}
	public static long longInput() {
		boolean error;
		long num = 0;
		do {
			try {
				num = kb.nextLong();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error en la introducción de datos.");
				error = true;
			}  finally {
				kb.nextLine();
			}
		} while (error);
		return num;
	}
	public static long valueGiven(Range menormayor, long number) {
		long num=0;
		if(menormayor==Range.GREATEREQUAL) {
			do{
				num=longInput();
			}while(num<number);
			
		}else if(menormayor==Range.LESSEREQUAL) {
			do{
				num=longInput();
			}while(num>number);
		}else if(menormayor==Range.GREATER) {
			do {
				num=longInput();
			}while(num<=number);
		}else if(menormayor==Range.LESS) {
			do{
				num=longInput();
			}while(num>=number);
		}else if(menormayor==Range.EQUAL) {
			do{
				num=longInput();
			}while(num!=number);
		}
		return num;
	}
	public static long range(Range menormayor, long max, long min) throws IllegalArgumentException {
		long number=0;
		if(max<min) {
			throw new IllegalArgumentException("El mínimo no puede ser mayor");
		}else {
			if(menormayor==Range.BOTHIN) {
				do {
					number=longInput();
				}while(number<min || number>max);
			}else if(menormayor==Range.BOTHOUT) {
				do {
					number=longInput();
				}while(number<=min || number>=max);
			}else if(menormayor==Range.MININ) {
				do {
					number=longInput();
				}while(number<min || number>=max);
			}else if(menormayor==Range.MAXIN) {
				do {
					number=longInput();
				}while(number<=min || number>max);
			}
		}
	
		return number;
	}
	public static double doubleInput() {
		boolean error;
		double num = 0;
		do {
			try {
				num = kb.nextDouble();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error en la introducción de datos.");
				error = true;
			}  finally {
				kb.nextLine();
			}
		} while (error);
		return num;
	}
	public static double valueGiven(Range menormayor,double number) {
		double num=0;
		if(menormayor==Range.GREATEREQUAL) {
			do{
				num=doubleInput();
			}while(num<number);
			
		}else if(menormayor==Range.LESSEREQUAL) {
			do{
				num=doubleInput();
			}while(num>number);
		}else if(menormayor==Range.GREATER) {
			do {
				num=doubleInput();
			}while(num<=number);
		}else if(menormayor==Range.LESS) {
			do{
				num=doubleInput();
			}while(num>=number);
		}else if(menormayor==Range.EQUAL) {
			do{
				num=doubleInput();
			}while(num!=number);
		}
		return num;
	}
	public static double range(Range menormayor, double max, double min) throws IllegalArgumentException {
		double number=0;
		if(max<min) {
			throw new IllegalArgumentException("El mínimo no puede ser mayor");
		}else {
			if(menormayor==Range.BOTHIN) {
				do {
					number=doubleInput();
				}while(number<min || number>max);
			}else if(menormayor==Range.BOTHOUT) {
				do {
					number=doubleInput();
				}while(number<=min || number>=max);
			}else if(menormayor==Range.MININ) {
				do {
					number=doubleInput();
				}while(number<min || number>=max);
			}else if(menormayor==Range.MAXIN) {
				do {
					number=doubleInput();
				}while(number<=min || number>max);
			}
		}
	
		return number;
	}
	public static float floatInput() {
		boolean error;
		float num = 0;
		do {
			try {
				num = kb.nextFloat();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error en la introducción de datos.");
				error = true;
			}  finally {
				kb.nextLine();
			}
		} while (error);
		return num;
	}
	public static float valueGiven(Range menormayor, float number) {
		float num=0;
		if(menormayor==Range.GREATEREQUAL) {
			do{
				num=floatInput();
			}while(num<number);
			
		}else if(menormayor==Range.LESSEREQUAL) {
			do{
				num=floatInput();
			}while(num>number);
		}else if(menormayor==Range.GREATER) {
			do {
				num=floatInput();
			}while(num<=number);
		}else if(menormayor==Range.LESS) {
			do{
				num=floatInput();
			}while(num>=number);
		}else if(menormayor==Range.EQUAL) {
			do{
				num=floatInput();
			}while(num!=number);
		}
		return num;
	}
	public static float range(Range menormayor, float max, float min) throws IllegalArgumentException {
		float number=0;
		if(max<min) {
			throw new IllegalArgumentException("El mínimo no puede ser mayor");
		}else{
			if(menormayor==Range.BOTHIN) {
				do {
					number=floatInput();
				}while(number<min || number>max);
			}else if(menormayor==Range.BOTHOUT) {
				do {
					number=floatInput();
				}while(number<=min || number>=max);
			}else if(menormayor==Range.MININ) {
				do {
					number=floatInput();
				}while(number<min || number>=max);
			}else if(menormayor==Range.MAXIN) {
				do {
					number=floatInput();
				}while(number<=min || number>max);
			}
		}
		return number;
	}
	public static String match(String like, String msg) {
		String string;
		do {
			System.out.printf("%s: ",msg);
			string=Keyboard.stringInput();
		}while(!string.matches(like));
		return string;		
	}
	public static void showArray(int values[]) {
		System.out.print(" |");
		for(int j:values) {
			if(j>9 && j<100) {
				System.out.printf(" %d|",j);
			}else if(j>99){
				System.out.printf("%d|",j);
			}else {
				System.out.printf(" %d |",j);
			}
		}
		System.out.println();
	}
	public static void arrayValues(int numbers[]) {
		for(int i=0;i<numbers.length;i++){
			System.out.printf("Valor nº %d: ",i+1);
			numbers[i]=intInput();
		}
	}
	public static void array09(int numbers[]) {
		for(int i=0;i<numbers.length;i++){
			System.out.printf("Valor nº %d: ",i+1);
			numbers[i]=range(Range.BOTHIN, 9, 0);
		}
	}
	public static void showArray(char values[]) {
		System.out.print(" |");
		for(char j:values) {
			System.out.printf(" %c |",j);
		}
		System.out.println();
	}
	public static void arrayValues(char values[]) {
		for(int i=0;i<values.length;i++){
			System.out.printf("Valor nº %d: ",i+1);
			values[i]=charInput();
		}
	}
	public static void showArray(String values[]) {
		System.out.print(" |");
		for(String j:values) {
			System.out.printf(" %s |",j);
		}
		System.out.println();
	}
	public static void showArray(double values[]) {
		System.out.print(" |");
		for(double j:values) {
			System.out.printf(" %.2f |",j);
		}
		System.out.println();
	}
	public static void arrayValues(String string[]) {
		for(int i=0;i<string.length;i++){
			System.out.printf("Valor nº %d: ",i+1);
			string[i]=stringInput();
		}
	}
	public static void array2Dimensions(int values[][]) {
		for(int i=0;i<values.length;i++) {
			System.out.printf("Fila nº %d\n",i+1);
			Keyboard.arrayValues(values[i]);	
		}
	}
	public static void array2d09(int values[][]) {
		for(int i=0;i<values.length;i++) {
			System.out.printf("Fila nº %d\n",i+1);
			Keyboard.array09(values[i]);	
		}
	}
	public static void array2Dimensions(char values[][]) {
		for(int i=0;i<values.length;i++) {
			System.out.printf("Fila nº %d\n",i+1);
			Keyboard.arrayValues(values[i]);	
		}
	}
	public static void array2Dimensions(String values[][]) {
		for(int i=0;i<values.length;i++) {
			System.out.printf("Fila nº %d\n",i+1);
			Keyboard.arrayValues(values[i]);	
		}
	}
	public static void show2dimensions(int values[][]) {
		for(int i=0;i<values.length;i++) {
			showArray(values[i]);
		}
	}
	public static void show2dimensions(char values[][]) {
		for(int i=0;i<values.length;i++) {
			showArray(values[i]);
		}
	}
	public static void show2dimensions(String values[][]) {
		for(int i=0;i<values.length;i++) {
			showArray(values[i]);
		}
	}
	public static void show2dimensions(double values[][]) {
		for(int i=0;i<values.length;i++) {
			showArray(values[i]);
		}
	}
	public static void show3D(int dec[][][]) {
		for(int i=0;i<dec.length;i++) {
			Keyboard.show2dimensions(dec[i]);
		}
		System.out.println();
	}
}
