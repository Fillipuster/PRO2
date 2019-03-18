package hashing;

/**
 * This class implements a hash set using an array and linear probing to handle collisions.
 */
public class HashSetLinearProbing {
	private Object[] buckets;
	private int currentSize;
	private enum State { DELETED }

	/**
	 * Constructs a hash table.
	 * @param bucketsLength the length of the buckets array
	 */
	public HashSetLinearProbing(int bucketsLength) {
		buckets = new Object[bucketsLength];
		currentSize = 0;
	}

	/**
	 * Tests for set membership.
	 * @param x an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {
		int h = hashValue(x);
		if (buckets[h] != null && buckets[h].equals(x)) {
			return true;
		}
		
		int i = h + 1;
		while (i != h) {
			if (i >= buckets.length) {
				i = 0;
			}
			
			if (buckets[i] != null && buckets[i].equals(x)) {
				return true;
			}
			
			i++;
		}
		
		return false;
	}

	/**
	 * Adds an element to this set.
	 * @param x an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
	    int h = hashValue(x);
	    
	    boolean done = false;
	    int i = h;
	    while (!done) {
	    	if (i >= buckets.length) {
	    		i = 0;
	    	}
	    	
	    	if (buckets[i] == null) {
	    		done = true;
	    		buckets[i] = x;
	    		currentSize++;
	    		return true;
	    	}
	    	
	    	if (buckets[i].equals(x)) {
	    		done = true;
	    		return false;
	    	}
	    	
	    	i++;
	    }
	    
	    throw new ArrayIndexOutOfBoundsException();
	}

	/**
	 * Removes an object from this set.
	 * @param x an object
	 * @return true if x was removed from this set, false if x was not an element of this set
	 */
	public boolean remove(Object x) {
		int h = hashValue(x);
		if (buckets[h].equals(x)) {
			buckets[h] = null;
			currentSize--;
			return true;
		}
		
		int i = h + 1;
		while (i != h) {
			if (i >= buckets.length) {
				i = 0;
			}
			
			if (buckets[i].equals(x)) {
				buckets[i] = null;
				currentSize--;
				return true;
			}
			
			i++;
		}
		
		return false;
	}

	/**
	 * Gets the number of elements in this set.
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	private int hashValue(Object x) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;
		return h;
	}

	@Override
	public String toString() {
		String result = "";
	    for (int i = 0; i < buckets.length; i++) {
	        int value = buckets[i] != null && !buckets[i].equals(State.DELETED) ? 
	                hashValue(buckets[i]) : -1;
			result += i + "\t" + buckets[i] + "(h:" + value + ")\n";
		}
	    return result;
	}

}
