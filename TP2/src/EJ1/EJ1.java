package EJ1;
import Base.*;
/*
 Ejercicio 1
Implemente un algoritmo recursivo que determine si un arreglo de tama�o N est� ordenado y
responda:
1. �Qu� complejidad O tiene? (La complejidad en el peor caso)
2. �Trae alg�n problema hacerlo recursivo? �Cu�l?
3. �Qu� cambiar�a si la estructura fuera una lista en lugar de un arreglo?
 */
public class EJ1 {

	public static void main(String[] args) {
		MySimpleLinkedList<Integer> list = new MySimpleLinkedList<Integer>();
		list.insertLast(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);
		list.insertLast(6);
		System.out.println(list.isOrdered());
		
		
	}

}
