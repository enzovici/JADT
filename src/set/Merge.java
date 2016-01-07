package set;

import java.util.Comparator;
import java.util.Iterator;

import nodeList.PositionList;


/** Generic merge for sorted sequences. */
public abstract class Merge<E> {
  private E a, b;			// current elements in A and B
  private Iterator<E> iterA, iterB;	// iterators for A and B
  /** Template method */
  public void merge(PositionList<E> A, PositionList<E> B, 
        Comparator<E> comp, PositionList<E> C) {
    iterA = A.iterator(); 
    iterB = B.iterator();
    boolean aExists = advanceA();  // Boolean test if there is a current a
    boolean bExists = advanceB();  // Boolean test if there is a current b
    while (aExists && bExists) {   // Main loop for merging a and b
      int x = comp.compare(a, b);
      if (x < 0) { aIsLess(a, C);  aExists = advanceA(); }
      else if (x == 0) {
	bothAreEqual(a, b, C); aExists = advanceA(); bExists = advanceB(); } 
      else { bIsLess(b, C);  bExists = advanceB(); }
    }
    while (aExists) { aIsLess(a, C); aExists = advanceA(); }
    while (bExists) { bIsLess(b, C); bExists = advanceB(); }
  }
  // auxiliary methods to be specialized by subclasses
  protected void aIsLess(E a, PositionList<E> C) { }
  protected void bothAreEqual(E a, E b, PositionList<E> C) { }
  protected void bIsLess(E b, PositionList<E> C) { }
  // helper methods
  private boolean advanceA() {
    if (iterA.hasNext()) { a = iterA.next(); return true; }
    return false;
  }
  private boolean advanceB() {
    if (iterB.hasNext()) { b = iterB.next(); return true; }
    return false;
  }  
}