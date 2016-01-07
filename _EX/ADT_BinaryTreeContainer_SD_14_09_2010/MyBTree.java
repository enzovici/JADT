package ADT_BinaryTreeContainer_SD_14_09_2010;
import position.*;
import binaryTree.BinaryTree;
import binaryTree.LinkedBinaryTree;

public class MyBTree<E> extends LinkedBinaryTree<E> {

	private Position<BinaryTree<E>> location;
	
	public MyBTree(){
		super();
		location=null;
	}
	
	public void setPosition(Position<BinaryTree<E>> pos){
		location=pos;
	}
	
	public Position<BinaryTree<E>> position(){
		return location;
	}
}
