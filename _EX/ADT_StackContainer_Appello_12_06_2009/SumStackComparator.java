package ADT_StackContainer_Appello_12_06_2009;

import java.util.Comparator;

public class SumStackComparator <E> implements Comparator<E> {

	public int compare(E a, E b) throws ClassCastException {
		
			int x = Integer.parseInt(String.valueOf(a));
			int y = Integer.parseInt(String.valueOf(b));
			
			if(x>y)
				return -1;
			
			else
				if(x==y)
					return 0;
			
			else return 1; 
	}
}