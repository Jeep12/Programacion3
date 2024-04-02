package ListasOrdenadas;

import Base.MySimpleLinkedList;

import Base.MyIterator;

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
		MyIterator<Integer> it1 = lista.iterator();
		
		while (it1.hasNext()) {
            MyIterator<Integer> it2 = lista2.iterator();
            
            while (it2.hasNext()) {
            	//7 < 9 true
                if (it2.getValue() < it1.getValue()) {
                    it2.toNext();
                } 
                
                if (it1.getValue() < it2.getValue()) {
                    it1.toNext();
                    break; 
                }
                
                if(it1.getValue() == it2.getValue()) { // it1.getValue() == it2.getValue()
                    aux.insertLast(it1.getValue());
                    it1.toNext();
                    it2.toNext();
                    break; 
                }
            }
         
        }

		System.out.println(aux);

	}
}
