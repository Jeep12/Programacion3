/*
 Crea un m�todo que imprima los d�gitos desde 1 hasta N. 
 Se debe pasar como par�metro el n�mero N
 */
public class EJ2 {
	public void imprimir(int n) {
		if(n>0) {
			imprimir(n-1);
			System.out.println(n);
		}
	}
	public static void main(String[] args) {
		EJ2 ej2 = new EJ2();
		ej2.imprimir(5);
	}
}
