package _ex;

import java.util.Random;

import arrayList.ArrayIndexList;

public class TestSort {
	
	public static void main(String[] args) {
		
		ArrayIndexList array = new ArrayIndexList(20);
		
		for(int i = 0;i<10;i++){
			Random rand = new Random();
			array.add(i, rand.nextInt(20)+1);
			System.out.print(array.get(i)+ " ");
		}
		Sort sort=new Sort();
		sort.quickSort(array,0,array.size()-1);
		System.out.print("\n");
		for(int i = 0;i<array.size();i++ ){
			System.out.print(array.get(i)+ " ");
		}
	}

}
