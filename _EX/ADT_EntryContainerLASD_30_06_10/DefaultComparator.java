package ADT_EntryContainerLASD_30_06_10;
import java.util.Comparator;

	public class DefaultComparator<E> implements Comparator<E> {
		@SuppressWarnings("all")
		public int compare(E a, E b) throws ClassCastException {
			int x = (Integer)a;
			int y = (Integer)b;
			
			if(x<y)
				return -1;
			
			else if(x==y)
				return 0;
			
			else return 1;
		}

}