package _ex;

import position.Position;
import binaryTree.BinaryTree;
import binaryTree.EulerTour;
import binaryTree.TourResult;



/**
 * stampare l'altezza dei nodi di un albero binario ricorsivamente ( usare eulerTour)
 * 
 * 
 * */
public class ExBinTree29_4<E> extends EulerTour<E,E>{
	private int altezza;
	private int h1,h2;
	
	@Override
	public E execute(BinaryTree T) {
		altezza = 0;
		h2 = 0;
		h1 = 0;
		this.init(T);
		return  eulerTour(T.root());
		
	}


	protected void visitRight(Position<E> v, TourResult<E> r) {
			if(tree.isRoot(v))return;
			if(tree.hasLeft(tree.parent(v)) && tree.hasRight(tree.parent(v))){
				if(tree.left(tree.parent(v)).equals(v)){
					if(tree.isInternal(v)){
						altezza = max(h1,h2) + 1;
						h1 = altezza;
					}
					else altezza = h1 = 0;
				}else{
					if(tree.isInternal(v)){
						altezza = max(h1,h2) + 1;
						h2 = altezza;
					}else altezza = h2 = 0;
				}
				
			}else{
				if(tree.hasLeft(tree.parent(v)) && tree.left(tree.parent(v)).equals(v)){//se è solo il figlio sinistro
					if(tree.isInternal(v)){
						altezza = h1;
					}
					else altezza = h1 = 0;
				}else{
					if(tree.hasRight(tree.parent(v)) && tree.isInternal(v)){ // se è solo il figlio destro
						altezza = h2;
					}else altezza = h2 = 0;
				}
			}
			r.out = v.element();
			//System.out.println(r.left + " - " + r.right + " - " + r.out );
			System.out.println("Altezza nodo: " + v.element() + " = " + altezza);
	}


	private int max(int a,int b) {
		if(a >= b)return a;
		return b;
	}
	
	
}
