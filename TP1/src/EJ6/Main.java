package EJ6;

import java.util.Iterator;

import Base.*;

/*
  
Escriba una función que dadas dos listas construya otra con los elementos que están en la
primera pero no en la segunda.
*/
public class Main {
	public static void main(String[] args) {
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();

		lista.insertFront(9);
		lista.insertLast(10);
		lista.insertLast(14);
		lista.insertLast(17);
		lista.insertLast(20);
		lista.insertLast(44);

		MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>();

		lista2.insertFront(7);
		lista2.insertLast(10);
		lista2.insertLast(11);
		lista2.insertLast(20);
		lista2.insertLast(23);
		lista2.insertLast(44);
		MySimpleLinkedList<Integer> aux = new MySimpleLinkedList<Integer>();
		Iterator<Integer> it1 = lista.iterator();
		while (it1.hasNext()) {
			boolean seEncontro = false;
			Integer value1 = it1.next();
			Iterator<Integer> it2 = lista2.iterator();

			while (it2.hasNext()) {
				Integer value2 = it2.next();
				if(value1.equals(value2)) {
					seEncontro=true;
				}
			}
			if(!seEncontro) {
				aux.insertLast(value1);
			}
		}
		
		System.out.println(aux);
	}

}
