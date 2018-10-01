package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(list.size() == size) throw new QueueOverflowException();
		
		list.insert(element);
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(list.size() == 0) throw new QueueUnderflowException();
		
		T result = list.toArray()[0];
		list.removeFirst();
		return result;
	}

	@Override
	public T head() {
		return list.toArray()[0];
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	public boolean isFull() {
		return list.size() == size;
	}

}
