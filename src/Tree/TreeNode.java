package tree;

import position.Position;
import nodeList.PositionList;

public class TreeNode<E> implements TreePosition<E> {
	
	private E element;
	private TreePosition<E> parent;
	private PositionList<Position<E>> children;
	
	public TreeNode(){}
	public TreeNode(E element, TreePosition<E> parent, PositionList<Position<E>> children){
		setElement(element);
		setParent(parent);
		setChildren(children);
	}
	
	public E element() {
		return element;
	}

	public void setElement(E o) {
		element=o;
	}

	public PositionList<Position<E>> getChildren() {
		return children;
	}

	public void setChildren(PositionList<Position<E>> c) {
		children=c;
	}

	public TreePosition<E> getParent() {
		return parent;
	}

	public void setParent(TreePosition<E> v) {
		parent=v;
	}
}
