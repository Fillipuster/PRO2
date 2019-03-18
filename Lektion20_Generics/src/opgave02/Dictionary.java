package opgave02;

import java.util.ArrayList;

public class Dictionary<K, V> implements Dicterface<K, V> {

	ArrayList<Node> nodes;
	
	public Dictionary() {
		nodes = new ArrayList<>();
	}
	
	@Override
	public V get(K key) {
		for (Node node : nodes) {
			if (node.key.equals(key)) {
				return node.value;
			}
		}
		
		return null;
	}

	@Override
	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	@Override
	public V put(K key, V value) {
		for (Node node : nodes) {
			if (node.key.equals(key)) {
				V old = node.value;
				node.value = value;
				return old;
			}
		}
		
		Node node = new Node(key, value);
		nodes.add(node);
		
		return null;
	}

	@Override
	public V remove(K key) {
		for (Node node : nodes) {
			if (node.key.equals(key)) {
				nodes.remove(node);
				return node.value;
			}
		}
		
		return null;
	}

	@Override
	public int size() {
		return nodes.size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[\n");
		
		for (Node node : nodes) {
			sb.append(node.key + " = " + node.value + ",");
			sb.append("\n");
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

}
