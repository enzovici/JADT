package set;

import nodeList.PositionList;

/** Class specializing the generic merge template to subtract two sets */
public class SubstractMerge<E> extends Merge<E> {
  protected void aIsLess(E a, PositionList<E> C) {
    C.addLast(a);	// add a
  }
  protected void bothAreEqual(E a, E b, PositionList<E> C) { } 
  protected void bIsLess(E b, PositionList<E> C) { } 
}