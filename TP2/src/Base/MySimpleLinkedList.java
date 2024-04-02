package Base;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {
	private Node<T> first;
	private int _size;

	public MySimpleLinkedList() {
		this.first = null;
		this._size = 0;
	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		tmp.setNext(this.first);
		this.first = tmp;

		this._size += 1;
	}

	public void insertLast(T info) {
		Node<T> aux = this.first;
		if (aux == null) {
			insertFront(info);
		} else {
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			Node<T> tmp = new Node<T>(info, null);
			aux.setNext(tmp);
			_size++;
		}

	}

	public T extractFront() {

		T retorno = null;
		if (_size != 0) {
			retorno = this.first.getInfo();
			this.first = this.first.getNext();
			this._size--;
		}

		return retorno;
	}

	public boolean isEmpty() {

		return this.first == null;
	}

	public T get(int index) {
		Node<T> aux = this.first;

		int contador = 0;
		if (_size != 0 && index >= 0 && index <= _size - 1) {

			while (contador < index) {
				aux = aux.getNext();
				contador++;
			}
			return aux.getInfo();

		} else {
			System.out.println("Indice fuera de rango");
			return null;
		}

	}

	public int size() {
		return this._size;
	}

	@Override
	public String toString() {
		String texto = "";
		Node<T> aux = this.first;
		int contador = 0;
		while (this.first != null && contador < _size) {
			texto += aux.getInfo() + ",";
			aux = aux.getNext();
			contador++;
		}
		return texto;
	}

	public int indexOf(T search) {
		int pos = -1;
		int contador = 0;
		Iterator<Integer> iterator = (Iterator<Integer>) this.iterator();
		while (iterator.hasNext()) {
			Integer value = iterator.next();
			if (value.equals(search)) {
				pos = contador;
			}
			contador++;
		}
		return pos;
	}

//	public int indexOf(T search) {
//		Node<T> aux = this.first;
//		int retorno = -1;
//		int contador = 0;
//		while (contador < this._size) {
//			if (aux.getInfo().equals(search)) {
//				retorno = contador;
//			}
//			aux = aux.getNext();
//			contador++;
//
//		}
//		return retorno;
//	}
	public MySimpleLinkedList<Integer> combinar2(MySimpleLinkedList<Integer> otraLista) {
		MySimpleLinkedList<Integer> aux = new MySimpleLinkedList<Integer>();

		for (T i : this) {
			if (otraLista.indexOf((Integer) i) != -1) {
				aux.insertFront((Integer) i);
			}
		}

		return aux;
	}

	public MySimpleLinkedList<Integer> combinar(MySimpleLinkedList<Integer> otraLista) {
		MySimpleLinkedList<Integer> aux = new MySimpleLinkedList<Integer>();

		Iterator<Integer> iterator = otraLista.iterator();

		while (iterator.hasNext()) {
			Integer value1 = iterator.next();

			Iterator<Integer> iterator2 = (Iterator<Integer>) this.iterator();

			while (iterator2.hasNext()) {
				Integer value2 = iterator2.next();
				if (value1.equals(value2)) {
					aux.insertFront(value1);
				}
			}
		}
		return aux;
	}
//METODO PARA VER SI ESTA ORDENADO, NO RECURSIVO
//	public boolean isOrdered() {
//		Iterator<Integer> it = (Iterator<Integer>) this.iterator();
//
//		// Si la lista esta vacia consideramos que esta ordenada.
//		// es decir si no tiene siguiente.
//		if (!it.hasNext()) {
//			return true;
//		}
//
//		// Obtengo el primer elemento
//		Integer current = it.next();
//		while (it.hasNext()) {
//			Integer value = it.next();
//			if (current > value) {
//				return false;
//			}
//			current = value;
//		}
//		return true;
//	}
	
	public boolean isOrdered() {
		MyIterator<T> it = this.iterator();
	    if (!it.hasNext()) {
	        return true;
	    }
	    Integer current = (Integer) it.next();
	    
	    System.out.println("current "+current);
		return isOrderedRecursive(it, current);
	}
	
	public boolean isOrderedRecursive(MyIterator<T> it, Integer current) {
	    if (!it.hasNext()) {
	        return true;
	    }
	    
	    Integer next = (Integer) it.next();
	    System.out.println("Siguiente "+next);
	    if (current > next) {
	        return false;
	    }
	    
	    return isOrderedRecursive(it, next);
	}
	public MyIterator<T> iterator() {
		return new MyIterator<T>(first);
	}
}