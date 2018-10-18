package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}


	@Override
	public void insert(T element) {
		if(element != null) {
			if(isEmpty()) data = element;
			else {
				if(next == null) { 
					next = new RecursiveDoubleLinkedListImpl<T>();
					((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
				}
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null) {
			if(!isEmpty()) {
				if(element.equals(data)) {
					if(next == null) { 
						next = new RecursiveDoubleLinkedListImpl<T>();
						((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
					}
					data = next.data;
					next = next.next;
					if(next != null) ((RecursiveDoubleLinkedListImpl<T>) next).previous = this;
				}else if(next != null) next.remove(element);
			}
		}
	}
	
	@Override
	public void insertFirst(T element) {
		
		if(element != null) {
			T temp = data;
			data = element;
			if(next == null && temp != null) next = new RecursiveDoubleLinkedListImpl<T>(temp, null, this);
			else ((RecursiveDoubleLinkedListImpl<T>) next).insertFirst(temp);
		}
		
	}

	@Override
	public void removeFirst() {
		
		data = next.data;
		next = next.next;
		
	}

	@Override
	public void removeLast() {
		
		if(next == null) {
			if(previous == null) data = null;
			else previous.next = null;
		}
		else ((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
