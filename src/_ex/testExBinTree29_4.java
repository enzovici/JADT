package _ex;

import position.Position;
import binaryTree.LinkedBinaryTree;

public class testExBinTree29_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		Position<String> last;
		
		
		tree.addRoot("a");
		
		last = tree.root();
		tree.insertLeft(last, "b");
		tree.insertRight(last, "c");
		
		last = tree.left(last); //scendo nel figlio sinistro della radice
		tree.insertLeft(last, "d");
		tree.insertRight(last, "e");
		
		last = tree.left(last); //scendo nel nodo con valore 'd'
		tree.insertLeft(last, "h");
		tree.insertRight(last, "i");
		
		
		last = tree.right(tree.parent(last)); //scendo nel nodo con valore 'e'
		tree.insertLeft(last, "l");
		tree.insertRight(last, "m");
		
		last = tree.right(last); //scendo nel nodo con valore 'm'
		tree.insertRight(last, "x");
		
		last = tree.right(tree.root()); //scendo nel figlio destro della radice
		tree.insertLeft(last, "f");
		tree.insertRight(last, "g");
		
		
		
		
		ExBinTree29_4<String> conta = new ExBinTree29_4<String>();
		
		conta.execute(tree);
		
	}

}
