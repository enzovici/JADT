package ADT_SetContainerLASD_14_01_2009B;
import java.util.Comparator;

public class DefaultComparator<K> implements Comparator<K> {
	@SuppressWarnings("unchecked")
	public int compare(K a, K b) throws ClassCastException {
			return ((Comparable<K>) a).compareTo(b);
	}

}