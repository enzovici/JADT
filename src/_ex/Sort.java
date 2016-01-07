package _ex;

import arrayList.IndexList;

public class Sort {
	
	public Sort(){
		
	}
	
	public static void quickSort(IndexList<Integer> A,int a,int b){
		if(a>=b) return ;
		int pivot = b;
		int l = a;
		int r = b-1;
		while(l<=r){
			while(l<=r && A.get(l)<=A.get(pivot)) l++;
			while(l<=r && A.get(l)>=A.get(pivot)) r--;
			//swap
			if(l<r){
			int tmp = A.get(l);
			A.set(l, A.get(r));
			A.set(r, tmp);
			}
		}
		
		//sistemo il pivot tra gli elementi più grandi di lui e più piccoli
		int tmp = A.get(l);
		A.set(l, A.get(pivot));
		A.set(pivot, tmp);
		
		quickSort(A,a,l-1);
		quickSort(A,l+1,b);
	}

}
