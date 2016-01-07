package arrayList;

public class InsertionSort {

	public static void insertionSort(IndexList<Double> V){
		for(int i=0; i<V.size(); i++){
			Double toSwap= V.get(i);
			int j=i-1;
			while (j>=0 && V.get(j)>toSwap){
				V.set(j+1, V.get(j));//shift a sinistra
				j--;
			}
			V.set(j+1, toSwap);
		}
	}
}
