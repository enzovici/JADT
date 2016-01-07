package comparator;

import java.util.Comparator;

public class Lexicographic<E extends Point2D> implements Comparator<E> {

	
	public int compare(E a, E b) {
		if(a.getX()!=b.getX())
			return a.getX()-b.getX();
		else
			return a.getY()-b.getY();
	}

}
