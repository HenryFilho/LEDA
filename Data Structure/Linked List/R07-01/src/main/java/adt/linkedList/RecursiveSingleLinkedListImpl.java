package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		int size = 0;
		if(!isEmpty()) {
			size++;
			if(next != null) size += next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T result = null;
		if(element != null) {
			if(!isEmpty()) {
				if(element.equals(data)) result = data;
				else if(next != null) result = next.search(element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if(isEmpty()) data = element;
			else {
				if(next == null) next = new RecursiveSingleLinkedListImpl<T>();
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null) {
			if(!isEmpty()) {
				if(element.equals(data)) {
					if(next == null) next = new RecursiveSingleLinkedListImpl<T>();
					data = next.data;
					next = next.next;
				}else if(next != null) next.remove(element);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Object[size()];
		if(arr.length > 0) arr[0] = data;
		
		if(next != null) {
			T[] nextArr = next.toArray();
			for(int i = 0; i < nextArr.length; i++)
				arr[i+1] = nextArr[i];
		}
		
		return arr;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
