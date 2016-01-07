package tree;

import exception.InvalidPositionException;
import nodeList.NodePositionList;
import nodeList.PositionList;
import position.Position;


public class TreeTester {
@SuppressWarnings("all")
	public static void main(String[] args) {
		
		LinkedTree<String> T = new LinkedTree<String>();
		//TreeNode<String> r = new TreeNode<String>();
	
		// Position<String> r = T.addRoot("r");
	
		
		//r=new TreeNode<String>("s",null,null);
		T.addRoot("s");
		Position<String> r = T.root();
		Position<String> a = T.addChild("a",r);
		Position<String> b = T.addChild("b",r);
		Position<String> c = T.addChild("c", a);
		Position<String> e = T.addChild("e", b);
		Position<String> f = T.addChild("f", b);
		Position<String> h = T.addChild("h", f);
		Position<String> i = T.addChild("i", f);
		
		Iterable<Position<String>> collezione=T.positions();
		for(Position<String> u : collezione)
			System.out.print(u.element() + " ");
		
		System.out.println("\n\nNumero di foglie dell'albero radicato in "
				+ T.root().element() + ": " + numberLeaves(T,T.root()));
		
		
//		//System.out.println("Ancestor (b, g) : " + T.ancestor(b,g));
//		System.out.println("Ancestor (a, b) : " + T.ancestor(a,b));
//		
		
		System.out.println("nodi a profondità 2 : ");
		NodePositionList<Position<String>> l = (NodePositionList<Position<String>>) atDepth(T, 2);
		for(Position<String> s: l)
			System.out.print(s.element() + " ");
		
//		System.out.println("\n\nCammino da c a f: ");
//		NodePositionList<Position<String>> x = (NodePositionList<Position<String>>) T.path(c, f);
//		for(Position<String> s : x)
//			System.out.print(s.element() + " ");
		
//		System.out.println("\n\nCammino da c a i: ");
//		x = (NodePositionList<Position<String>>) T.path(c, i);
//		for(Position<String> s: x)
//			System.out.print(s.element() + " ");
//		
//		System.out.println("\n\nCammino da c a h: ");
//		x = (NodePositionList<Position<String>>) T.path(c, h);
//		for(Position<String> s: x)
//			System.out.print(s.element() + " ");
//		
		
		System.out.println("\nMetodo traccia d'esame 14/01/2009 B : ");
		
		//T.remove(a);
		
		System.out.println("\nVisita preOrder dopo la rimozione di f: ");
		PositionList<Position<String>> preOrder = new NodePositionList<Position<String>>();
		T.preorderPositions(r,preOrder);
		for(Position<String> p : preOrder)
			System.out.print(p.element() + " ");
		
	}

	
	/** Conta ricorsivamente le foglie presenti nell'albero con la radice passata come parametro 
	 * @param 	T 	l'albero sul quale operare
	 * @param 	v 	la radice del sottoalbero
	 * @return 		il numero di foglie del sottoalbero */
	public static<E> int numberLeaves(LinkedTree<E> T,Position<E> v) throws InvalidPositionException{
		int i = 0;
		TreeNode<E> nodo = T.checkPosition(v);
		if(T.isExternal(v)) // caso base
			return 1;		// caso base
		else
			for(Position<E> p : nodo.getChildren())		// ricorsione
				i += numberLeaves(T,p);					// ricorsione
		return i;
	}
	
	
	/** Il metodo restituisce una collezione iterabile di tutti i nodi a profondità ( conto da root che vale 0 fino alla fino=i)
	 * @param T		l'albero sul quale operare
	 * @param i		la profondità
	 * @return		la collezione iterabile
	 */
	public static<E> Iterable<Position<E>> atDepth(Tree<E> T, int i)throws InvalidPositionException{
		PositionList<Position<E>> lista = new NodePositionList<Position<E>>();// lista vuota
		LinkedTree<E> albero = (LinkedTree<E>) T;							  // cast
		Iterable<Position<E>> temp;											  // lista iterabile
		
		if(i == 0){
			lista.addLast(T.root());
		}else{
			temp = atDepth(T,i-1);
			for(Position<E> v : temp){
				PositionList<Position<E>> child = albero.checkPosition(v).getChildren();
				for(Position<E> ww : child)
					lista.addLast(ww);
			}
		}
		return lista;
	}
	
}
