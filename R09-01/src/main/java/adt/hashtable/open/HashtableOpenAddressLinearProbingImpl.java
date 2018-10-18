package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		
		if(isFull()) throw new HashtableOverflowException();
		
		if(search(element) == null) {
			int i = 0,
				j = 0;
			while(i < capacity()) {
				j = hash(element, i);
				if(table[j] == null || table[j] instanceof DELETED) {
					table[j] = element;
					elements++;
					break;
				}else {
					COLLISIONS++;
					i++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		int index = indexOf(element);
		if(index > -1) {
			table[index] = new DELETED();
			elements--;
		}
	}

	@Override
	public T search(T element) {
		T result = null;
		if(indexOf(element) > -1) result = element;
		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;
		if(element != null) {
			int i = 0,
				j = 0;
			while(i < capacity()) {
				j = hash(element, i);
				if(table[j] == null) break;
				if(table[j].equals(element)) {
					result = j;
					break;
				}i++;
			}
		}
		return result;
	}
	
	/**
	 * Auxiliary method made for the purpose of making the code more readable
	 * and clean.
	 */
	private int hash(T element, int probe) {
		return ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
	}

}
