package binaryTree;

import position.Position;

public abstract class EulerTour<E, R> {
	  protected BinaryTree<E> tree;
	  /** Execution of the traversal. This abstract method must be
	   * specified in a concrete subclass. */
	  public abstract R execute(BinaryTree<E> T);
	  /** Initialization of the traversal */
	  protected void init(BinaryTree<E> T) { tree = T; }
	  /** Template method */
	  protected R eulerTour(Position<E> v) {
	    TourResult<R> r = new TourResult<R>();
	    visitLeft(v, r);
	    if (tree.hasLeft(v))
	      r.left = eulerTour(tree.left(v));		// recursive traversal
	    visitBelow(v, r);
	    if (tree.hasRight(v))
	      r.right = eulerTour(tree.right(v));	// recursive traversal
	    visitRight(v, r);
	    return r.out;
	  }
	  // Auxiliary methods that can be redefined by subclasses:
	  /** Method called for the visit on the left */
	  protected void visitLeft(Position<E> v, TourResult<R> r) {}
	  /** Method called for the visit on from below */
	  protected void visitBelow(Position<E> v, TourResult<R> r) {}
	  /** Method called for the visit on the right */
	  protected void visitRight(Position<E> v, TourResult<R> r) {}

	}