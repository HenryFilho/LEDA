package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		
		int size = 0;
		SingleLinkedListNode<T> temp = head;
		while(!temp.isNIL()) {
			size++;
			temp = temp.next;
		}
		
		return size;
	}

	@Override
	public T search(T element) {
		
		T result = null;
		SingleLinkedListNode<T> temp = head;
		while(!temp.isNIL()) {
			if(element.equals(temp.data)) result = temp.data;
			temp = temp.next;
		}
		
		return result;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			
			SingleLinkedListNode<T> temp = head;
			while(!temp.isNIL())
				temp = temp.next;
			temp.data = element;
			temp.next = new SingleLinkedListNode<T>();
			
		}
	}

	@Override
	public void remove(T element) {
		
		boolean removed = false;
		SingleLinkedListNode<T> temp = head;
		while(!temp.isNIL() || !removed) {
			if(element.equals(temp.data)) {
				temp.data = temp.next.data;
				temp.next = temp.next.next;
				removed = true;
			}else temp = temp.next;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Object[size()];
		
		SingleLinkedListNode<T> temp = head;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = temp.data;
			temp = temp.next;
		}
		
		return arr;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
