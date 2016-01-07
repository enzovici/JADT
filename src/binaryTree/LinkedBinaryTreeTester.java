package binaryTree;


import java.util.Iterator;

import nodeList.NodePositionList;
import nodeList.PositionList;
import position.*;
import stack.NodeStack;

@SuppressWarnings("all")
public class LinkedBinaryTreeTester {

	
	public static void main(String[] args) {
		
		LinkedBinaryTree<Character> albero = new LinkedBinaryTree<Character>();
		Position<Character> r = albero.addRoot('r');
		Position<Character> a = albero.insertLeft(r, 'a');
		Position<Character> b = albero.insertRight(r, 'b');
		Position<Character> c = albero.insertLeft(a, 'c');
		Position<Character> d = albero.insertRight(a, 'd');
		Position<Character> f = albero.insertLeft(b, 'f');
		Position<Character> g = albero.insertRight(b, 'g');
		Position<Character> h = albero.insertLeft(g, 'h');
		Position<Character> i = albero.insertRight(g, 'i');
		Position<Character> l = albero.insertLeft(h, 'l');
		
		Iterator<Character> iteratore = albero.iterator();
		System.out.println("Elementi dell'albero: ");
		while(iteratore.hasNext())
			System.out.print(iteratore.next()+" ");
		
		
		System.out.println("\nFratello di b: " + albero.sibling(b).element());
		System.out.println("Fratello di d: " + albero.sibling(d).element());
		
		System.out.println();
		NodePositionList<Character> lista = preOrder(albero);
		System.out.println("Visita preorder: ");
		for(Character ch : lista)
			System.out.print(ch + " ");
		
		System.out.println("\nAltezza albero: " + albero.altezzaAlbero(r));
		System.out.println("\nHa tutte le foglie allo stesso livello?: " + albero.someLevelLeaves());
		
		System.out.println("\nVisita postOrder: ");
		PositionList<Position<Character>> postOrder = new NodePositionList<Position<Character>>();
		albero.postOrderPositions(r, postOrder);
		for(Position<Character> p : postOrder)
			System.out.print(p.element() + " ");
		
	}
	
	/** Effettua una visita preorder sull'albero utilizzando uno stack
	 * Implementazione Iterativa
	 */
	protected static<E> NodePositionList<E> preOrder(LinkedBinaryTree<E> T){
		
		NodeStack<Position<E>> S = new NodeStack<Position<E>>();
		NodePositionList<E> L = new NodePositionList<E>();
		
		S.push(T.root());
		
		while(!S.isEmpty()){
			Position<E> v = S.pop();
			L.addLast(v.element());
			if(T.hasRight(v))
				S.push(T.right(v));
			if(T.hasLeft(v))
				S.push(T.left(v));
		}
		
		return L;
	}	
}