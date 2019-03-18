package opgave02;

import java.util.ArrayList;

public class HashDictionary<K, V> implements Dicterface<K, V> {
	
	private ArrayList<Node>[] buckets;
	private int size;
	
	@SuppressWarnings("unchecked")
	public HashDictionary() {
		buckets = new ArrayList[20];
		size = 0;
	}
	
	private int hash(K key) {
		int hash = key.hashCode();
		
		if (hash < 0) {
			hash = -hash;
		}
		
		return hash % buckets.length;
	}
	
	public V get(K key) {
		for (Node node : buckets[hash(key)]) {
			if (node.key.equals(key)) {
				return node.value;
			}
		}
		
		return null;
	}
	
	public V put(K key, V value) {
		int hash = hash(key);
		
		if (buckets[hash] == null) {
			buckets[hash] = new ArrayList<>();
		}
				
		for (Node node : buckets[hash]) {
			if (node.key.equals(key)) {
				V old = node.value;
				node.value = value;
				return old;
			}
		}
		
		size++;
		
		buckets[hash].add(new Node(key, value));
			
		return null;
	}
	
	public V remove(K key) {
		int hash = hash(key);
		
		if (buckets[hash] != null) {
			for (Node n : buckets[hash]) {
				if (n.key.equals(key)) {
					V removed = n.value;
					buckets[hash].remove(n);
					size--;
					return removed;
				}
			}
		}
		
		return null;
	}
	
	public ArrayList<K> getKeys() {
		ArrayList<K> keys = new ArrayList<>();
		
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null && !buckets[i].isEmpty()) {
				for (Node node : buckets[i]) {
					keys.add(node.key);
				}				
			}
		}
		
		return keys;
	}
	
	public boolean containsKey(K key) {
		int hash = hash(key);
		
		return buckets[hash] != null && !buckets[hash].isEmpty();
	}
	
	public ArrayList<V> values() {
		ArrayList<V> result = new ArrayList<>();
		
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				for (Node n : buckets[i]) {
					result.add(n.value);
				}
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[\n");
		
		int keys = getKeys().size();
		for (K key : getKeys()) {
			sb.append(key + " = " + get(key));
			if (keys > 1) {
				sb.append(",");
			}
			sb.append("\n");
			
			keys--;
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	private class Node {
		K key;
		V value;
		
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	@Override
	public boolean isEmpty() {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null && !buckets[i].isEmpty()) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public int size() {
		return this.size;
	}

}
