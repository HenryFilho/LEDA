package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(top.size() == size) throw new StackOverflowException();
		
		top.insert(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(top.size() == 0) throw new StackUnderflowException();
		
		T result = top.toArray()[top.size()-1];
		top.removeLast();
		return result;
	}

	@Override
	public T top() {
		return top.toArray()[top.size()-1];
	}

	@Override
	public boolean isEmpty() {
		return top.size() == 0;
	}

	@Override
	public boolean isFull() {
		return top.size() == size;
	}

}
