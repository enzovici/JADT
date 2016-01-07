package ADT_BinaryTreeContainer_SD_14_09_2010;
import binaryTree.BinaryTree;
import position.Position;

public interface BTContainer<E> {

	public Position<E> insertRight(BinaryTree<E> T, Position<E> v, E elem);
	
	public BinaryTree<E> remove();
	
	public Position<E> insertLeft(BinaryTree<E> T, Position<E> v, E elem);
	
	public BinaryTree<E> insert(E elem);
					
	
	
	
	
	
}
