package set;

import nodeList.PositionList;

/** Class specializing the generic merge template to intersect two sets */
public class IntersectMerge<E> extends Merge<E> {
  protected void aIsLess(E a, PositionList<E> C) { } 
  protected void bothAreEqual(E a, E b, PositionList<E> C) {
    C.addLast(a);	// add a (but not its duplicate b)
  }
  protected void bIsLess(E b, PositionList<E> C) { } 
}