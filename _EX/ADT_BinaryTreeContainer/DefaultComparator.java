package ADT_BinaryTreeContainer;
import java.util.Comparator;

	public class DefaultComparator implements Comparator<Integer> {
	
		public int compare(Integer x, Integer y)  throws ClassCastException {
			if(x>y)
				return -1;
			else
				if(x==y)
				return 0;
			
			else
				return 1;
		}
}