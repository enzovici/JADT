package _utility;
import queue.*;
import position.*;
import deque.*;
import stack.*;
import exception.*;
import arrayList.*;
import nodeList.*;
import sequence.*;

import java.util.Scanner;

public class Test {
	//restituisce true se esiste in S l elemento x, false altrimenti
	public static <E>boolean ricerca(Sequence<E> S, E x){
		boolean flag = false;
		if(S.size()==0)
			return flag;
		else{
			E elem=S.removeFirst();
			if(elem.equals(x)){
				flag=true;
				flag= flag || ricerca(S, x);
			}
			else
				flag=ricerca(S, x);
			S.addFirst(elem);
			return flag;
		}
	}
	
	public static <E>boolean search(Sequence<E> S, E x){
		return search(S, 0, x);
	}
	public static <E>boolean search(Sequence<E> S, int i, E x){
		if(S.size()==i)
			return false;
		else{
			if(S.get(i).equals(x))
				return true;
			else
				return search(S, i+1, x);
		}
		
	}

	
	//restituisce l'elemento in posiszione k della coda Q
	public static <E>E extract(Queue<E>Q,int k){
		if(Q.size()<=k) throw new NotEnoughElements("non ci sono abbastanza elementi");
		E elem;
		for(int i=0;i<k;i++)
			Q.enqueue(Q.dequeue());
		elem = Q.dequeue();
		Q.enqueue(elem);
		for(int i=0;i<(Q.size()-k-1);i++)
			Q.enqueue(Q.dequeue());
		return elem;
	}
	
	//inverte una coda ricorsivamente
	public static <E> void recReverse(Queue<E> Q){
		if(Q.size()<=1) 
			return;
		E tmp = Q.dequeue(); 
		recReverse(Q);
		Q.enqueue(tmp);
	}
	
	//rimuove l'elemento x nella sequenza L
	public static <E> void remove(Sequence<E> L, E x){
		int i=0;
		for(E e : L){
			if(e.equals(x)){
				L.remove(i);
				return;
			}
			i++;
		}
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String ex="N", exit="N";
		int n,m,cap;

		while(ex.equals("n")||ex.equals("N")||ex.equals("no")||ex.equals("NO")||ex.equals("No")){
			exit="N";
			System.out.println("\n**** TESTING STRUTTURE DATI *****\n*\t\t\t\t*");
			System.out.println("* 0: exit;\t\t\t*\n* 1: arrayStack;\t\t*\n* 2: nodeStack;\t\t\t*\n* 3: arrayQueue;\t\t*\n* 4: nodeQueue;\t\t\t*\n* 5: deque;\t\t\t*\n* 6: arrayList;\t\t\t*\n* 7: nodeList;\t\t\t*\n* 8: nodeSequence;\t\t*\n* 9: arraySequence;\t\t*");
			System.out.println("*********************************");
			System.out.println("\nin attesa di input: ");
			n=in.nextInt();
			
			if(n==0){
				System.out.println("uscire definitivamente? (S)i (N)o");
				ex=(String)in.next();	
			}	
			else if(n==1){
				ArrayStack<Integer> arrayStack;
				System.out.println("inserisci la capacità dello stack (0 = default): ");
				cap=in.nextInt();
				if(cap==0) 
					arrayStack = new ArrayStack<Integer>();
				else
					arrayStack = new ArrayStack<Integer>(cap);
				while(exit.equals("n")||exit.equals("N")||exit.equals("no")||exit.equals("NO")||exit.equals("No")){	
					System.out.println("\n************************************* ARRAY STACK ************************************************");
					System.out.println("* 0: exit; | 1: push; | 2: top; | 3: pop; | 4: size; | 5: capacità; | 6: isEmpty; | 7: toString. *");
					System.out.println("**************************************************************************************************\n");
					System.out.println("capacità: "+arrayStack.getCapacity()+";\t size: "+arrayStack.size()+";\t isEmpty: "+arrayStack.isEmpty());
					System.out.println("\nstack: "+arrayStack.toString());
					System.out.println("\nin attesa di input: ");
					m=in.nextInt();
					switch(m){
							case 0:
								System.out.println("sei sicuro di voler uscire? (S)i (N)o");
								exit=(String)in.next();
								break;
							case 1:
								System.out.println("digita il numero da inserire:");
								arrayStack.push(in.nextInt());
								break;
							case 2:
								System.out.println("risultato di top: "+arrayStack.top());
								break;
							case 3:
								System.out.println("risultato di pop: "+arrayStack.pop());
								break;
							case 4:
								System.out.println("nello stack ci sono: "+arrayStack.size()+" elementi");
								break;
							case 5:
								System.out.println("la capacità dello stack è: "+arrayStack.getCapacity());
								break;
							case 6:
								System.out.println("isEmpty: "+arrayStack.isEmpty());
								break;
							case 7:
								System.out.println("toString: "+arrayStack.toString());
								break;
						}//chiusura switch array stack
					}//chiusura while array stack
			}//chiusura if n==1
			else if(n==2){
					NodeStack <Integer>nodeStack= new NodeStack<Integer>();
					while(exit.equals("n")||exit.equals("N")||exit.equals("no")||exit.equals("NO")||exit.equals("No")){
						System.out.println("\n********************************* NODE STACK **************************************");
						System.out.println("* 0: exit; | 1: push; | 2: top; | 3: pop; | 4: size; | 5: isEmpty; | 6: toString. *");
						System.out.println("***********************************************************************************\n");						
						System.out.println("size: "+nodeStack.size()+";\t isEmpty: "+nodeStack.isEmpty());
						System.out.println("\nstack: "+nodeStack.toString());
						System.out.println("\nin attesa di input: ");
						m=in.nextInt();
						switch(m){
							case 0:
								System.out.println("sei sicuro di voler uscire? (S)i (N)o");
								exit=(String)in.next();
								break;
							case 1:
								System.out.println("digita il numero da inserire:");
								nodeStack.push(in.nextInt());
								break;
							case 2:
								System.out.println("risultato di top: "+nodeStack.top());
								break;
							case 3:
								System.out.println("risultato di pop: "+nodeStack.pop());
								break;
							case 4:
								System.out.println("nello stack ci sono: "+nodeStack.size()+" elementi");
								break;
							case 5:
								System.out.println("isEmpty: "+nodeStack.isEmpty());
								break;
							case 6:
								System.out.println("toString: "+nodeStack.toString());
								break;
						}//chiusura switch node stack
					}//chiusura while node stack
			}//chiusura if n==2
			else if(n==3){	
				ArrayQueue<Integer> arrayQueue; 
				System.out.println("inserisci la capacità della coda (0 = default): ");
				cap=in.nextInt();
				if(cap==0) 
					arrayQueue = new ArrayQueue<Integer>();
				else
					arrayQueue= new ArrayQueue<Integer>(cap);
				while(exit.equals("n")||exit.equals("N")||exit.equals("no")||exit.equals("NO")||exit.equals("No")){
					System.out.println("\n************************************************************ ARRAY QUEUE **********************************************************************************");
					System.out.println("* 0: exit; | 1: enqueue; | 2: dequeue; | 3: front; | 4: size; | 5: capacity; | 6: isEmpty; | 7: toString; | 8: toString2; | 9: extract; | 10: recReverse. *");
					System.out.println("***********************************************************************************************************************************************************\n");
					System.out.println("capacità: "+arrayQueue.getCapacity()+";\t size: "+arrayQueue.size()+";\t isEmpty: "+arrayQueue.isEmpty());
					System.out.println("\nqueue: "+arrayQueue.toString());
					System.out.println("\nin attesa di input: ");
					m=in.nextInt();
						switch(m){
							case 0:
								System.out.println("sei sicuro di voler uscire? (S)i (N)o");
								exit=(String)in.next();
								break;
							case 1:
								System.out.println("digita il numero da inserire:");
								arrayQueue.enqueue(in.nextInt());
								break;
							case 2:
								System.out.println("risultato di dequeue: "+arrayQueue.dequeue());
								break;
							case 3:
								System.out.println("risultato di front: "+arrayQueue.front());
								break;
							case 4:
								System.out.println("nella queue ci sono : "+arrayQueue.size()+" elementi");
								break;
							case 5:
								System.out.println("la capacità della queue è: "+arrayQueue.getCapacity());
								break;
							case 6:
								System.out.println("isEmpty: "+arrayQueue.isEmpty());
								break;
							case 7:
								System.out.println("toString: "+arrayQueue.toString());
								break;
							case 8:
								System.out.println("toString2: "+arrayQueue.toString2());
								break;
							case 9:
								System.out.println("digita la posizione dell'elemento da estrarre: ");
								int b = in.nextInt();
								int c = extract(arrayQueue,b);
								System.out.println("l'elemento in posizione "+b+" è: "+c);
								break;
							case 10:
								recReverse(arrayQueue);
								System.out.println("la coda è stata invertita");
								break;
						}//chiusura switch array queue
					}//chiusura while array queue
			}//chiusura if n==3
			else if(n==4){	
				NodeQueue<Integer> nodeQueue= new NodeQueue<Integer>();
				while(exit.equals("n")||exit.equals("N")||exit.equals("no")||exit.equals("NO")||exit.equals("No")){
				System.out.println("\n**************************************************** NODE QUEUE ***********************************************************");
				System.out.println("* 0: exit; | 1: enqueue; | 2: dequeue; | 3: front; | 4: size; | 5: isEmpty; | 6: toString; | 7: extract; | 8: recReverse. *");
				System.out.println("***************************************************************************************************************************\n");
				System.out.println("size: "+nodeQueue.size()+";\t isEmpty: "+nodeQueue.isEmpty());
				System.out.println("\nqueue: "+nodeQueue.toString());
				System.out.println("\nin attesa di input: ");
				m=in.nextInt();
						switch(m){
							case 0:
								System.out.println("sei sicuro di voler uscire? (S)i (N)o");
								exit=(String)in.next();
								break;
							case 1:
								System.out.println("digita il numero da inserire:");
								nodeQueue.enqueue(in.nextInt());
								break;
							case 2:
								System.out.println("risultato di dequeue: "+nodeQueue.dequeue());
								break;
							case 3:
								System.out.println("risultato di front: "+nodeQueue.front());
								break;
							case 4:
								System.out.println("nella queue ci sono : "+nodeQueue.size()+" elementi");
								break;
							case 5:
								System.out.println("isEmpty: "+nodeQueue.isEmpty());
								break;
							case 6:
								System.out.println("toString: "+nodeQueue.toString());
								break;
							case 7:
								System.out.println("digita la posizione dell'elemento da estrarre: ");
								int b = in.nextInt();
								int c = extract(nodeQueue,b);
								System.out.println("l'elemento in posizione "+b+" è: "+c);
								break;
							case 8:
								recReverse(nodeQueue);
								System.out.println("la coda è stata invertita");
								break;
						}//chiusura switch node queue
					}//chiusura while node queue
			}//chiusura if n==4
			else if(n==5){
				NodeDeque<Integer> nodeDeque= new NodeDeque<Integer>();
				while(exit.equals("n")||exit.equals("N")||exit.equals("no")||exit.equals("NO")||exit.equals("No")){
					System.out.println("\n******************************************************************* NODE DEQUE ************************************************************************");
					System.out.println("* 0: exit; | 1: add first; | 2: add last; | 3: get first; | 4: get last; | 5: remove first; | 6: remove last; | 7: size; | 8: isEmpty; | 9: toString. *");
					System.out.println("*******************************************************************************************************************************************************\n");
					System.out.println("size: "+nodeDeque.size()+";\t isEmpty: "+nodeDeque.isEmpty());
					System.out.println("\ndeque: "+nodeDeque.toString());
					System.out.println("\nin attesa di input: ");
					m=in.nextInt();
						switch(m){
							default:
								System.out.println("input non valido");
								break;
							case 0:
								System.out.println("sei sicuro di voler uscire? (S)i (N)o");
								exit=(String)in.next();
								break;
							case 1:
								System.out.println("digita il numero da inserire in testa: ");
								nodeDeque.addFirst(in.nextInt());
								break;
							case 2:
								System.out.println("digita il numero da inserire in coda:");
								nodeDeque.addLast(in.nextInt());
								break;
							case 3:
								System.out.println("il primo elemento è: "+nodeDeque.getFirst());
								break;
							case 4:
								System.out.println("l'ultimo elemento è: "+nodeDeque.getLast());
								break;
							case 5:
								System.out.println("l' elemento in testa ["+nodeDeque.removeFirst()+"] è stato rimosso");
								break;
							case 6:
								System.out.println("l' elemento in coda ["+nodeDeque.removeLast()+"] è stato rimosso");
								break;
							case 7:
								System.out.println("nel deque ci sono "+nodeDeque.size()+" elementi");
								break;
							case 8:
								System.out.println("isEmpty: "+nodeDeque.isEmpty());
								break;
							case 9:
								System.out.println("toString: "+nodeDeque.toString());
								break;			
						}//chiusura switch node deque	
					}//chiusura while node deque		
			}//chiusura if n==5
			else if(n==6){
				int n1,n2,p;
				ArrayIndexList<Integer> arrayList; 
				System.out.println("inserisci la capacità del vettore (0 = default): ");
				cap=in.nextInt();
				if(cap==0) 
					arrayList = new ArrayIndexList<Integer>();
				else
					arrayList= new ArrayIndexList<Integer>(cap);
				while(exit.equals("n")||exit.equals("N")||exit.equals("no")||exit.equals("NO")||exit.equals("No")){
					System.out.println("\n********************************************* ARRAY LIST *****************************************************");
					System.out.println("* 0: exit; | 1: add; | 2: remove; | 3: set; | 4: get; | 5: size; | 6: capacity; | 7: isEmpty; | 8: toString; *");
					System.out.println("**************************************************************************************************************\n");
					System.out.println("capacità: "+arrayList.capacity()+";\t size: "+arrayList.size()+";\t isEmpty: "+arrayList.isEmpty());
					System.out.println("\nlist: "+arrayList.toString());
					System.out.println("\nin attesa di input: ");
					m=in.nextInt();
						switch(m){
							case 0:
								System.out.println("sei sicuro di voler uscire? (S)i (N)o");
								exit=(String)in.next();
								break;
							case 1:
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								arrayList.add(p,n1);
								System.out.println(n1+" è stato inserito in posizione "+p);
								break;
							case 2:
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								n1=arrayList.remove(p);
								System.out.println(n1+" è stato rimosso dalla posizione "+p);								
								break;
							case 3:
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								n2=arrayList.set(p,n1);
								System.out.println(n2+" in posizione "+p+" è stato sostituito con "+n1);
								break;
							case 4:
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								n1=arrayList.get(p);
								System.out.println("in posizione "+p+" c'è il numero "+n1);
								break;
							case 5:
								System.out.println("nel vettore ci sono "+arrayList.size()+" elementi");
								break;
							case 6:
								System.out.println("la capacità del vettore è: "+arrayList.capacity());
								break;
							case 7:
								System.out.println("isEmpty: "+arrayList.isEmpty());
								break;
							case 8:
								System.out.println("toString: "+arrayList.toString());
								break;
						}//chiusura switch array list
					}//chiusura while array list
			}//chiusura if n==6
			else if(n==7){
				int n1,n2,p;
				NodePositionList<Integer> nodeList= new NodePositionList<Integer>(); 
				Position<Integer> nodo;
				while(exit.equals("n")||exit.equals("N")||exit.equals("no")||exit.equals("NO")||exit.equals("No")){
					System.out.println("\n*************************************************************************** NODE LIST *****************************************************************************************************************");
					System.out.println("* 0: exit; | 1: addFirst; | 2: addLast; | 3: addBefore; | 4: addAfter; | 5: set; | 6: first; | 7: last; | 8: prev; | 9: next; | 10: remove; | 11: size; | 12: isEmpty; | 13: toString; | 14: reverse; *");
					System.out.println("*******************************************************************************************************************************************************************************************************\n");
					System.out.println("size: "+nodeList.size()+";\t isEmpty: "+nodeList.isEmpty());
					System.out.println("\nlist: "+nodeList.toString());
					System.out.println("\nin attesa di input: ");
					m=in.nextInt();
						switch(m){
							case 0:
								System.out.println("sei sicuro di voler uscire? (S)i (N)o");
								exit=(String)in.next();
								break;
							case 1:
								System.out.println("digita il numero da inserire in prima posizione:");
								n1=in.nextInt();
								nodeList.addFirst(n1);
								System.out.println(n1+" è stato inserito in prima posizione ");
								break;
							case 2:
								System.out.println("digita il numero da inserire in ultima posizione:");
								n1=in.nextInt();
								nodeList.addLast(n1);
								System.out.println(n1+" è stato inserito in ultima posizione ");
								break;
							case 3:
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeList.first();
								for(int i=0;i<p;i++)
									nodo=nodeList.next(nodo);							
								nodeList.addBefore(nodo,n1);
								System.out.println("in posizione "+p+" è stato aggiunto "+n1);
								break;
							case 4:
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeList.first();
								for(int i=0;i<p;i++){
									nodo=nodeList.next(nodo);
								}
								nodeList.addAfter(nodo,n1);
								System.out.println("in posizione successiva alla "+p+" è stato aggiunto "+n1);
								break;
							case 5:
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeList.first();
								for(int i=0;i<p;i++)
									nodo=nodeList.next(nodo);
								nodeList.set(nodo, n1);
								System.out.println("in posizione "+p+" è stato settato "+n1);
								break;
							case 6:
								n1=nodeList.first().element();
								System.out.println("il primo elemento è "+n1);
								break;
							case 7:
								n1=nodeList.last().element();
								System.out.println("l'ultimo elemento è "+n1);
								break;
							case 8:
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeList.first();
								for(int i=0;i<p;i++)
									nodo=nodeList.next(nodo);
								n1= nodeList.prev(nodo).element();
								System.out.println("nella posizione che precede la "+p+" c'è "+n1);
								break;
							case 9:
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeList.first();
								for(int i=0;i<p;i++)
									nodo=nodeList.next(nodo);	
								n1= nodeList.next(nodo).element();
								System.out.println("nella posizione che segue la "+p+" c'è "+n1);
								break;
							case 10:
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeList.first();
								for(int i=0;i<p;i++)
									nodo=nodeList.next(nodo);	
								n1= nodeList.remove(nodo);
								System.out.println("l'elemento "+n1+" in posizione "+p+" è stato rimosso");
								break;
							case 11:
								System.out.println("nel vettore ci sono "+nodeList.size()+" elementi");
								break;
							case 12:
								System.out.println("isEmpty: "+nodeList.isEmpty());
								break;
							case 13:
								System.out.println("toString: "+nodeList.toString());
								break;
							case 14://reverselist
								nodeList.reverse();
								System.out.println("la lista è stata invertita: "+nodeList.toString() );
								break;
						}//chiusura switch node list
					}//chiusura while node list
			}//chiusura if n==7
			else if(n==8){
				int n1,n2,p;
				NodeSequence<Integer> nodeSequence= new NodeSequence<Integer>(); 
				Position<Integer> nodo;
				while(exit.equals("n")||exit.equals("N")||exit.equals("no")||exit.equals("NO")||exit.equals("No")){
					System.out.println("\n********************************************************************************************* NODE SEQUENCE *****************************************************************************************************************************************");
					System.out.println("* 0: exit; | 1: add; | 2: addFirst; | 3: addLast; | 4: addBefore; | 5: addAfter; | 6: set; | 7: get; | 8: first; | 9: last; | 10: prev; | 11: next; | 12: remove; | 13: size; | 14: isEmpty; | 15: toString; | 16: ricerca | 17: search; | 18: rmv; *");
					System.out.println("*****************************************************************************************************************************************************************************************************************************************************\n");
					System.out.println("size: "+nodeSequence.size()+";\t isEmpty: "+nodeSequence.isEmpty());
					System.out.println("\nsequence: "+nodeSequence.toString());
					System.out.println("\nin attesa di input: ");
					m=in.nextInt();
						switch(m){
							case 0:
								System.out.println("sei sicuro di voler uscire? (S)i (N)o");
								exit=(String)in.next();
								break;
							case 1://add
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();						
								nodeSequence.add(p,n1);
								System.out.println("in posizione "+p+" è stato aggiunto "+n1);
								break;
							case 2://addFirst
								System.out.println("digita il numero da inserire in prima posizione:");
								n1=in.nextInt();
								nodeSequence.addFirst(n1);
								System.out.println(n1+" è stato inserito in prima posizione ");
								break;
							case 3://addLast
								System.out.println("digita il numero da inserire in ultima posizione:");
								n1=in.nextInt();
								nodeSequence.addLast(n1);
								System.out.println(n1+" è stato inserito in ultima posizione ");
								break;
							case 4://addBefore
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeSequence.atIndex(p);						
								nodeSequence.addBefore(nodo,n1);
								System.out.println("in posizione "+p+" è stato aggiunto "+n1);
								break;
							case 5://addAfter
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeSequence.atIndex(p);
								nodeSequence.addAfter(nodo,n1);
								System.out.println("in posizione successiva alla "+p+" è stato aggiunto "+n1);
								break;
							case 6://set
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodeSequence.set(p, n1);
								System.out.println("in posizione "+p+" è stato settato "+n1);
								break;
							case 7://get
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								n1=nodeSequence.get(p);
								System.out.println("in posizione "+p+" c'è "+n1);
								break;
							case 8://first
								n1=nodeSequence.first().element();
								System.out.println("il primo elemento è "+n1);
								break;
							case 9://last
								n1=nodeSequence.last().element();
								System.out.println("l'ultimo elemento è "+n1);
								break;
							case 10://prev
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeSequence.atIndex(p);
								n1= nodeSequence.prev(nodo).element();
								System.out.println("nella posizione che precede la "+p+" c'è "+n1);
								break;
							case 11://next
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=nodeSequence.atIndex(p);
								n1= nodeSequence.next(nodo).element();
								System.out.println("nella posizione che segue la "+p+" c'è "+n1);
								break;
							case 12://remove
								System.out.println("digita la posizione: ");
								p=in.nextInt();	
								n1= nodeSequence.remove(p);
								System.out.println(n1+" è stato rimosso dalla posizione "+p);
								break;	
							case 13://size
								System.out.println("nel vettore ci sono "+nodeSequence.size()+" elementi");
								break;
							case 14://isEmpty
								System.out.println("isEmpty: "+nodeSequence.isEmpty());
								break;
							case 15://toString
								System.out.println("toString: "+nodeSequence.toString());
								break;
							case 16://ricerca
								System.out.println("inserisci il numero da cercare");
								p= in.nextInt();
								System.out.println("risultato di ricerca: "+ricerca(nodeSequence,p));
								break;	
							case 17://search
								System.out.println("inserisci il numero da cercare");
								p= in.nextInt();
								System.out.println("risultato di ricerca: "+search(nodeSequence,p));
								break;
							case 18://remove
								System.out.println("inserisci il numero da eliminare");
								p= in.nextInt();
								remove(nodeSequence,p);
								break;
						}//chiusura switch nodesequence
					}//chiusura while nodesequence
			}//chiusura if n==8
			else if(n==9){
				int n1,n2,p;
				ArraySequence<Integer> arraySequence;
				System.out.println("inserisci la capacità del vettore (0 = default): ");
				cap=in.nextInt();
				if(cap==0) 
					arraySequence = new ArraySequence<Integer>();
				else
					arraySequence= new ArraySequence<Integer>(cap);
				Position<Integer> nodo;
				while(exit.equals("n")||exit.equals("N")||exit.equals("no")||exit.equals("NO")||exit.equals("No")){
					System.out.println("\n******************************************************************************************** ARRAY SEQUENCE *********************************************************************************************************************************************************");
					System.out.println("* 0: exit; | 1: add; | 2: addFirst; | 3: addLast; | 4: addBefore; | 5: addAfter; | 6: set; | 7: get; | 8: first; | 9: last; | 10: prev; | 11: next; | 12: remove; | 13: size; | 14: isEmpty; | 15: toString; | 16: ricerca; | 17: search; | 18: capacity | 19: rmv; *");
					System.out.println("*********************************************************************************************************************************************************************************************************************************************************************\n");
					System.out.println("capacità: "+arraySequence.capacity()+";\t size: "+arraySequence.size()+";\t isEmpty: "+arraySequence.isEmpty());
					System.out.println("\nsequence: "+arraySequence.toString());
					System.out.println("\nin attesa di input: ");
					m=in.nextInt();
						switch(m){
							case 0:
								System.out.println("sei sicuro di voler uscire? (S)i (N)o");
								exit=(String)in.next();
								break;
							case 1://add
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();						
								arraySequence.add(p,n1);
								System.out.println("in posizione "+p+" è stato aggiunto "+n1);
								break;
							case 2://addFirst
								System.out.println("digita il numero da inserire in prima posizione:");
								n1=in.nextInt();
								arraySequence.addFirst(n1);
								System.out.println(n1+" è stato inserito in prima posizione ");
								break;
							case 3://addLast
								System.out.println("digita il numero da inserire in ultima posizione:");
								n1=in.nextInt();
								arraySequence.addLast(n1);
								System.out.println(n1+" è stato inserito in ultima posizione ");
								break;
							case 4://addBefore
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=arraySequence.atIndex(p);						
								arraySequence.addBefore(nodo,n1);
								System.out.println("in posizione "+p+" è stato aggiunto "+n1);
								break;
							case 5://addAfter
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=arraySequence.atIndex(p);
								arraySequence.addAfter(nodo,n1);
								System.out.println("in posizione successiva alla "+p+" è stato aggiunto "+n1);
								break;
							case 6://set
								System.out.println("digita il numero da inserire:");
								n1=in.nextInt();
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								arraySequence.set(p, n1);
								System.out.println("in posizione "+p+" è stato settato "+n1);
								break;
							case 7://get
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								n1=arraySequence.get(p);
								System.out.println("in posizione "+p+" c'è "+n1);
								break;
							case 8://first
								n1=arraySequence.first().element();
								System.out.println("il primo elemento è "+n1);
								break;
							case 9://last
								n1=arraySequence.last().element();
								System.out.println("l'ultimo elemento è "+n1);
								break;
							case 10://prev
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=arraySequence.atIndex(p);
								n1= arraySequence.prev(nodo).element();
								System.out.println("nella posizione che precede la "+p+" c'è "+n1);
								break;
							case 11://next
								System.out.println("digita la posizione: ");
								p=in.nextInt();
								nodo=arraySequence.atIndex(p);
								n1= arraySequence.next(nodo).element();
								System.out.println("nella posizione che segue la "+p+" c'è "+n1);
								break;
							case 12://remove
								System.out.println("digita la posizione: ");
								p=in.nextInt();	
								n1= arraySequence.remove(p);
								System.out.println(n1+" è stato rimosso dalla posizione "+p);
								break;	
							case 13://size
								System.out.println("nel vettore ci sono "+arraySequence.size()+" elementi");
								break;
							case 14://isEmpty
								System.out.println("isEmpty: "+arraySequence.isEmpty());
								break;
							case 15://toString
								System.out.println("toString: "+arraySequence.toString());
								break;
							case 16://ricerca
								System.out.println("inserisci il numero da cercare");
								p= in.nextInt();
								System.out.println("risultato di ricerca: "+ricerca(arraySequence,p));
								break;	
							case 17://search
								System.out.println("inserisci il numero da cercare");
								p= in.nextInt();
								System.out.println("risultato di ricerca: "+search(arraySequence,p));
								break;
							case 18://capacity
								System.out.println("capacità: "+arraySequence.capacity());
								break;
							case 19://remove
								System.out.println("inserisci il numero da eliminare");
								p= in.nextInt();
								remove(arraySequence,p);
								break;
						}//chiusura switch arraysequence
					}//chiusura while arraysequence
			}//chiusura if n==9
			else
				System.out.println("scelta non valida");
		}//chiusura while generale
	}//chiusura main
}//chiusura classe