/*
Crea un m�todo que obtenga la suma de los n�meros naturales desde 1 hasta N.
 Se debe pasar como par�metro el n�mero N 
 */
public class EJ1 {
	public int sumar(int n) {
		int suma =0;
		if(n==1) {
			return 1;
		}else {
			return n + sumar(n-1);
		}
	}
	public static void main(String[] args) {
		EJ1 ej1 = new EJ1();

		System.out.println(ej1.sumar(4));
	}

}
