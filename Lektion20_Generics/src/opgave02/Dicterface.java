package opgave02;

public interface Dicterface<K, V> {

	public V get(K key);
	
	public boolean isEmpty();
	
	public V put (K key, V value);
	
	public V remove(K key);
	
	public int size();
	
}
