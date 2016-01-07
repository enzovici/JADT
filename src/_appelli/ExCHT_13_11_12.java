package _appelli;

import java.util.Iterator;

import dictionary.ChainingHashTable;
import dictionary.LogFile;

import nodeList.NodePositionList;
import nodeList.PositionList;

import entry.Entry;

/**
 Aggiungere il metodo
public void shrinkTable()
alla classe ExamChainingHashTable fornita dalla docente all’interno della classe
ExCHT_13_11_12.
Istruzioni per lo svolgimento dell’esercizio:
• La funzione conta quante locazioni del bucket array fanno riferimento ad un LogFile
contenente almeno una entry e sostituisce il bucket array con un nuovo bucket array di
lunghezza pari al numero di queste locazioni. Al termine dell’esecuzione, le entrate del
dizionario dovranno risultare identiche a quelle presenti inizialmente. Si noti che le entrate
dovranno essere inserite opportunamente nei LogFile del nuovo bucket array.
• La variabile che fa riferimento al bucket array e quella che tiene traccia della capacità della
tabella in ChainingHashTable devono essere protected.
• Suggerimento: aggiornare il valore della variabile capacity di ChainingHashTable per
poter calcolare i nuovi valori hash delle chiavi (dopo aver salvato il vecchio in un'altra
variabile).
La classe di test ExCHT_13_11_12 deve essere inserita nel pacchetto in cui si trova la classe
Dictionary.
 */


//importare le classi necessarie

/*Il programma deve stampare:
 
La capacita` del bucket array inizialmente e` 100  e  il dizionario contiene le entrate:

(33,1) 
(66,1) 
(99,1) (99,81) 
(132,1) (132,81) 
(165,1) (165,81) (165,161) 
(198,1) (198,81) (198,161) 
(231,1) (231,81) (231,161) 
(264,1) (264,81) (264,161) (264,241) 
(297,1) (297,81) (297,161) (297,241) 
(330,1) (330,81) (330,161) (330,241) (330,321) 
(363,1) (363,81) (363,161) (363,241) (363,321) 
(396,1) (396,81) (396,161) (396,241) (396,321) 


Dopo l'invocazione di shrinkTable() la capacita` della tabella e` 12 e si ha che
bucket[0] contiene le entrate: (132,1) (132,81) (264,1) (264,81) (264,161) (264,241) (396,1) (396,81) (396,161) (396,241) (396,321) 
bucket[1] contiene le entrate: 
bucket[2] contiene le entrate: 
bucket[3] contiene le entrate: (231,1) (231,81) (231,161) (363,1) (363,81) (363,161) (363,241) (363,321) (99,1) (99,81) 
bucket[4] contiene le entrate: 
bucket[5] contiene le entrate: 
bucket[6] contiene le entrate: (330,1) (330,81) (330,161) (330,241) (330,321) (66,1) (198,1) (198,81) (198,161) 
bucket[7] contiene le entrate: 
bucket[8] contiene le entrate: 
bucket[9] contiene le entrate: (33,1) (165,1) (165,81) (165,161) (297,1) (297,81) (297,161) (297,241) 
bucket[10] contiene le entrate: 
bucket[11] contiene le entrate: 
*/

	public class ExCHT_13_11_12 {
		
		
		public static void main(String[] args) {
			
		
			ExamChainingHashTable<Integer,Integer> D = new ExamChainingHashTable<Integer,Integer>(100);
			for(int i=0;i<400;i=i+33)
				for(int j=1;j<=i;j=j+80)
					D.insert(i,j);
			   
			System.out.println("La capacita` del bucket array inizialmente e` " + D.getCapacity()+"  e  il dizionario contiene le entrate:");
		   		
			  for(int i=0;i<400;i=i+33){
			    Iterator <Entry<Integer,Integer>> it = D.findAll(i).iterator();
				 while(it.hasNext()){
					Entry<Integer,Integer> current =it.next();
					System.out.print("("+ current.getKey()+","+current.getValue()+")"+" ");
				 }
				  System.out.println();
				}	
				
			
				    
		    D.shrinkTable();
			System.out.print("\n\nDopo l'invocazione di shrinkTable() " +	"la capacita` della tabella e` "+ D.getCapacity() +" e si ha che" );
					  
			

					  
						 
			
		
			for(int i=0;i<D.getCapacity(); i++){
			  System.out.print("\nbucket["+ i+"] contiene le entrate: " ); 
				for(Entry<Integer,Integer>e:D.getBucket(i).entries()){
			      System.out.print("("+ e.getKey()+","+ e.getValue()+")"+" ");
			
				}  
			   }
			 }
		
          
			public  static  class ExamChainingHashTable<K,V> extends ChainingHashTable<K,V> {
				
				public ExamChainingHashTable(int cap){
					super(cap);
					}
					
				public int getCapacity(){return (capacity);}
				
				public LogFile<K,V> getBucket(int i){return bucket[i];}
				
				
				public int hashValue(K key){
					 return (Integer)key%capacity;
				 }
						
                               //scrivere qui la funzione
				public void  shrinkTable(){
					int oldCap = this.getCapacity();
					int numLoc = 0;
					for(int i = 0; i < this.getCapacity(); i++){
						if(!(this.getBucket(i).isEmpty()))numLoc++;
					}
					
					System.out.println("cap:" + this.capacity + " loc: " + numLoc);
					this.capacity = numLoc;
					System.out.println("cap nuova:" + this.capacity);
					LogFile<K,V>[] tmp = (LogFile<K,V>[]) new LogFile[numLoc];
					for(int i = 0; i < numLoc; i++){
						tmp[i] = new LogFile<K,V>();
					}
					
					for(int i = 0; i < oldCap; i++){
						if(!(this.getBucket(i).isEmpty())){
							for(Entry<K,V> e : this.getBucket(i).entries()){
								System.out.println("funzone: " + e.getKey() + " - " + e.getValue());
								int index = hashValue(e.getKey());
								tmp[index].insert(e.getKey(),e.getValue());
							}
							
						}
						
					}
					
					
					this.bucket = tmp;
					
				}
					 
		
				 
					
			
			}
			
			
		

}
