package map;

import entry.Entry;

	public  class HashEntry<K,V> implements Entry<K,V> {
	
		protected K key;
		protected V value;
	
		public HashEntry(K k, V v) {
			key = k; value = v;
		}

		public V getValue() { 
			return value; 
		}

		public K getKey() { return key;
		}

		public V setValue(V val) {
			V oldValue = value;
			value = val;
	
			return oldValue;
		}
	
		@SuppressWarnings("unchecked")
		public boolean equals(Object o) {
	
			HashEntry<K,V> ent;
	
			try { 
				ent = (HashEntry<K,V>) o; 
			}
	
			catch (ClassCastException ex) { return false; }

	return (ent.getKey() == key) && (ent.getValue() == value);
}

		public String toString() { 
			return "(" + key + "," + value + ")"; 
		}
		
		
}
