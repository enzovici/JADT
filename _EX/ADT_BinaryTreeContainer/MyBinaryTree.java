package ADT_BinaryTreeContainer;

import binaryTree.BinaryTree;
import binaryTree.LinkedBinaryTree;
import position.*;

public class MyBinaryTree<E> extends LinkedBinaryTree<E>{
	
	
	private Position<BinaryTree<E>> location;

	
	public MyBinaryTree(){
		super();
		location=null;
	}
	
	public void setPosition(Position<BinaryTree<E>> pos ){
		location=pos;
	}
	
	public Position<BinaryTree<E>> position(){
		return location;
	}
}
