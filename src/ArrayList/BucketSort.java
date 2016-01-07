package arrayList;

//counting sort
public class BucketSort {

	public static void bucketSort(IndexList<Integer> V, int k){
		IndexList<Integer> tmp = new ArrayIndexList<Integer>(k);
		for(int i=0; i<k; i++)	//O(k)
			tmp.add(i, 0);
		for(int j=0; j<V.size(); j++){	//O(|V|)
			int valore = V.get(j);
			int contatore = tmp.get(valore);
			tmp.set(valore,  contatore+1);
		}
		int h=0;
		for(int i=0; i<k; i++){						//O(|V|)
			for(int j=0; j<=tmp.get(i)-1;j++){
				V.set(h++, i);
			}
		}
	}
}
