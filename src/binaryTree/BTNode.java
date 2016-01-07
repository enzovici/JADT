package binaryTree;

public class BTNode<E> implements BTPosition<E> {

	protected E element;
	protected BTPosition<E> left,right,parent;
	
	public BTNode(E elem,BTPosition<E> parent,BTPosition<E> left,BTPosition<E> right){
		this.element=elem;
		this.parent=parent;
		this.left=left;
		this.right=right;
		
	}
	
	
	public E element(){
		return this.element;
	}
	public BTPosition<E> getLeft() {
		return this.left;
	}

	public BTPosition<E> getParent() {
		return this.parent;
	}

	public BTPosition<E> getRight() {
		return this.right;
	}

	public void setElement(E o) {
		this.element=o;
		
	}

	public void setLeft(BTPosition<E> v) {
		this.left=v;
	}

	public void setParent(BTPosition<E> v) {
		this.parent=v;
	}

	public void setRight(BTPosition<E> v) {
		this.right=v;
	}

}
