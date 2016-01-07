package completBinaryTree;

import position.Position;

public class TestArrayListCompleteBinaryTree {


	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ArrayListCompleteBinaryTree<Integer> lista= new ArrayListCompleteBinaryTree<Integer>();
		
		
		Position<Integer> p1 = lista.add(3);
		Position<Integer> p2 = lista.add(2);
		Position<Integer> p3 = lista.add(7);
		Position<Integer> p4 = lista.add(8);
		Position<Integer> p5 = lista.add(4);
		Position<Integer> p6 = lista.add(9);
		Position<Integer> p7 = lista.add(2);
		Position<Integer> p8 = lista.add(10);
		
		for(Position<Integer> c : lista.positions())
			
			System.out.print(c.element()+" ");
			
		System.out.println("\n<--------------->");
		
		
		System.out.print(lista.sibling(p7).element()+" ");
			
	
		

}
}