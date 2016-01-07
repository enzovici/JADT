package _appelli;

import nodeList.PositionList;
import map.HashTableMap;
import map.ListMap;
import map.Map;
import dictionary.Dictionary;
import dictionary.LogFile;
import entry.Entry;

/**
 Scrivere il metodo
public static<K,V> Map<K,Integer>numOfOccurrences(Map<K,V>M, Dictionary <K,V>D )
nella classe ExDictionary_7_6_12.
Istruzioni per lo svolgimento dell’esercizio:
• La funzione prende in input una mappa M e un dizionario D e restituisce una mappa che per
ciascuna chiave k di M contiene un’entrata con chiave k e valore uguale al numero di
entrate di D che hanno chiave k.
La classe di test ExDictionary_7_6_12 deve essere inserita nel pacchetto in cui si trova
l’interfaccia Dictionary.
 */


/*
 Il programma deve stampare:
  
Il dizionario D contiene le entrate: 
(a,z) (ab,z) (a,zy) (ab,zy) (a,z) (ab,z) (abc,z) 
(a,zw) (ab,zw) (abc,zw) (a,zwv) (ab,zwv) (abc,zwv) (a,z) (ab,z) 
(abc,z) (abcd,z) (a,zt) (ab,zt) (abc,zt) (abcd,zt) (a,zts) (ab,zts) 
(abc,zts) (abcd,zts) (a,ztsr) (ab,ztsr) (abc,ztsr) (abcd,ztsr) (a,z) (ab,z) 
(abc,z) (abcd,z) (abcde,z) (a,zp) (ab,zp) (abc,zp) (abcd,zp) (abcde,zp) 
(a,zpo) (ab,zpo) (abc,zpo) (abcd,zpo) (abcde,zpo) (a,zpon) (ab,zpon) (abc,zpon) 
(abcd,zpon) (abcde,zpon) (a,zponm) (ab,zponm) (abc,zponm) (abcd,zponm) (abcde,zponm) 

La mappa M contiene le entrate: 
(a,zjih) (ab,zjih) (abc,zjih) (abcd,zjih) (rana,topo) 

La mappa restituita da numOfOcurrences contiene le entrate: 
(a,14) (ab,14) (abc,12) (abcd,9) (rana,0) 

 */


public class ExDictionary_7_6_12 {
	public static void main(String[] args){
		Dictionary<String, String> d = new LogFile<String,String>();
		Map <String, String> m= new ListMap<String,String>();
		Character ck;
		Character cv='y';
		for(int l=3;l<7;l++){
		  for(String sv= "z"; sv.length()<l; sv=sv+  String.valueOf(cv--)){
			    ck='b';
				for(String sk= "a"; sk.length()<l; sk=sk+ String.valueOf(ck++)){
			      d.insert(sk, sv);
	     	}
     	  }
		}
		cv='o';
		for(int l=3;l<6;l++){
			  for(String sv= "z"; sv.length()<l; sv=sv+  String.valueOf(cv--)){
				    ck='b';
					for(String sk= "a"; sk.length()<l; sk=sk+ String.valueOf(ck++)){
				      m.put(sk, sv);
			    }
			  }
		}
		m.put("rana", "topo");
		System.out.println("Il dizionario D contiene le entrate: ");
		 int count=0;
		 for(Entry<String,String> ent: d.entries()){
			 if(count++>6) {count=0;System.out.println();}
		     System.out.print("("+ent.getKey() + ","+ ent.getValue()+") ");
		 }
		 System.out.println("\n\nLa mappa M contiene le entrate: ");
		 count=0;
		 for(Entry<String,String> ent: m.entries()){
			 if(count++>6) {count=0;System.out.println();}
		     System.out.print("("+ent.getKey() + ","+ ent.getValue()+") ");
		 }
	    System.out.println("\n\nLa mappa restituita da numOfOcurrences contiene le entrate: ");
		  for(Entry<String,Integer> ent: numOfOccurrences(m,d).entries())
			 System.out.print("("+ent.getKey()+","+ent.getValue()+") ");
	    
	
	
	
	}
		
		
		
	public static<K,V> Map<K,Integer> numOfOccurrences(Map<K,V> M,Dictionary <K,V>D ){
		Map<K,Integer> toReturn = new ListMap<K,Integer>();
		
		for(K Mkey : M.keys()){
			int count = 0;
			for(Entry<K,V> ent: D.findAll(Mkey)){
				count++;
			}
			toReturn.put(Mkey, count);
			
		}
		
		return toReturn;
		
			}
}
