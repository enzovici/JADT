package set;

import nodeList.PositionList;


/** Class specializing the generic merge template to union two sets */
public class UnionMerge<E> extends Merge<E> {
  protected void aIsLess(E a, PositionList<E> C) {
    C.addLast(a);	// add a
  }
  protected void bothAreEqual(E a, E b, PositionList<E> C) {
    C.addLast(a);    // add a (but not its duplicate b)
  }
  protected void bIsLess(E b, PositionList<E> C) {
    C.addLast(b);   // add b
  }
}