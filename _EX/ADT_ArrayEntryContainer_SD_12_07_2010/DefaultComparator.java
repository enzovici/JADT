package ADT_ArrayEntryContainer_SD_12_07_2010;
import java.util.Comparator;

public class DefaultComparator<K> implements Comparator<K> {
	@SuppressWarnings("unchecked")
	public int compare(K a, K b) throws ClassCastException {
			return -((Comparable<K>) a).compareTo(b);
	}

}