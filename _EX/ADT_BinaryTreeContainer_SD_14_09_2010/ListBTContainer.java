package ADT_BinaryTreeContainer_SD_14_09_2010;
import java.util.Comparator;
import position.*;
import priorityQueue.DefaultComparator;
import binaryTree.BinaryTree;


public class ListBTContainer<E> implements BTContainer<E>{

	private PositionList<BinaryTree<E>> lista;
	private Comparator<Integer> comp;
	
	
	public ListBTContainer(){
		lista = new NodePositionList<BinaryTree<E>>();
		comp = new DefaultComparator<Integer>();
	}
	
	public BinaryTree<E> insert(E elem) {
		MyBTree<E> albero = new MyBTree<E>();
		albero.addRoot(elem);
		lista.addLast(albero);
		albero.setPosition(lista.last());
		//ordinaLista(albero);
		return albero;
	}

	public Position<E> insertLeft(BinaryTree<E> T, Position<E> v, E elem) {
		MyBTree<E> albero = (MyBTree<E>) T;
		Position<E> leftChild = albero.insertLeft(v,elem);
		lista.remove(albero.position());
		ordinaLista(albero);
		return leftChild;
	}

	public Position<E> insertRight(BinaryTree<E> T, Position<E> v, E elem) {
		MyBTree<E> albero = (MyBTree<E>) T;
		Position<E> rightChild = albero.insertRight(v,elem);
		lista.remove(albero.position());
		ordinaLista(albero);
		return rightChild;
	}

	public boolean isEmpty() {
		return lista.isEmpty();
	}

	public int size() {
		return lista.size();
	}

	public BinaryTree<E> remove() {
		MyBTree<E> albero = (MyBTree<E>) lista.remove(lista.last());
		
		return albero;
	}
	
	public String toString(){
		String stampa="";
		for(BinaryTree<E> t : lista){
			MyBTree<E> albero = (MyBTree<E>) t;
			stampa+="[";
			for(Position<E> p : albero.positions()){
				stampa+=p.element()+" ";
			}
			stampa=stampa.substring(0,stampa.length()-1);
			stampa+="] ";
		}
		return stampa;
	}

	private int contaFoglie(BinaryTree<E> t){
		MyBTree<E> albero = (MyBTree<E>) t;
		int numFoglie=0;
			for(Position<E> p : albero.positions()){
				if(albero.isExternal(p))
					numFoglie++;
			}
		return numFoglie;
	}
	/*** Problema come già accenato durante il compito dopo l'aggiunta di figli non ordina bene
	 * 	nonostante la logica di ordinamento suppongo sia buona!
	 * 
	 * @param t
	 */
	public void ordinaLista(BinaryTree<E> t){
		MyBTree<E> alb1 = (MyBTree<E>) t;
		for(Position<BinaryTree<E>> pT : lista.positions()){
			MyBTree<E> alb2 = (MyBTree<E>) pT.element();
			if(contaFoglie(alb1) < contaFoglie(alb2)){
				lista.addBefore(pT,alb1);
				alb1.setPosition(lista.prev(pT));
				return;
			}
		}
		lista.addLast(alb1);
		alb1.setPosition(lista.last());
	}
	
}
