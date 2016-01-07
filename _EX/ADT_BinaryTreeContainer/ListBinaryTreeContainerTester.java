package ADT_BinaryTreeContainer;

import position.*;

public class ListBinaryTreeContainerTester {

	public static void main(String[] args) {
	
		
		ListBinaryTreeContainer<Integer> list = new ListBinaryTreeContainer<Integer>();
		
		PositionList<Integer> l = new NodePositionList<Integer>();
		
		l.addLast(2);
		l.addLast(3);
		MyBinaryTree<Integer> albero = (MyBinaryTree<Integer>) list.insert(1, l);
		
		PositionList<Integer> l2 = new NodePositionList<Integer>();
		
		l2.addLast(33);
		l2.addLast(4);
		MyBinaryTree<Integer> albero2 = (MyBinaryTree<Integer>) list.insert(1, l2);
		
		
		System.out.println("Albero 1:");
		for(Position<Integer> pos : list.position(albero)){
				System.out.print(pos.element()+" ");
			}
		
		System.out.println("\nAlbero 2:");
		for(Position<Integer> pos : list.position(albero2)){
			System.out.print(pos.element()+" ");
			}

		list.remove(1);
	
		System.out.println("\nQuanti alberi ci sono nel contenitore??? "+list.size());
		System.out.println("La lista è vuota?? "+list.isEmpty());
		
		
		list.leaves(albero);
		System.out.println();
		list.leaves(albero2);
		
		
	}
}
