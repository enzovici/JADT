package position;

public interface Position<E> { //fornisce una visione astratta e unificante dei diversi modi di 
							   //memorizzare un dato nelle varie implementazioni del tda NodeList (es. una cella
							   //di un array, un nodo di una lista a puntatori
	public int index=0;
	public E element();// Restituisce l’elemento memorizzato
}