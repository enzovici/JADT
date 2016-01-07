package map;

import entry.Entry;
import exception.InvalidKeyException;

public interface Map<K,V> { 
 
 public int size(); 
 
 public boolean isEmpty(); 
 
 /* Se la chiave key è già presente rimpiazza il vecchio 
 valore con value restituendo in output il vecchio valore. Se 
 la chiave non è già presente inserisce la nuova entry 
 (key,value) e restituisce null*/ 
 public V put(K key, V value) throws InvalidKeyException; 
 
 /** Restituisce il valore associato alla chiave. */ 
 public V get(K key) throws InvalidKeyException; 
 /** Rimuove l’entrata con chiave key restituendone in 
 output il valore. Restituisce null se key non è nella mappa. */ 
 public V remove(K key) throws InvalidKeyException; 
 
 /** Restituisce una collezione iterabile delle chiavi 
 presenti nella mappa. */ 
 public Iterable<K> keys(); 
 
 /** Restituisce una collezione iterabile dei valori
 presenti nella mappa. */ 
 public Iterable<V> values(); 
 
 /** Restituisce una collezione iterabile delle entrate 
 presenti nella mappa. */ 
 public Iterable<Entry<K,V>> entries(); 
 }