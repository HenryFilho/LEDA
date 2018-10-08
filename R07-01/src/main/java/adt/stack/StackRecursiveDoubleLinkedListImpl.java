package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) throw new StackOverflowException();
		
		if(element != null) top.insert(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()) throw new StackUnderflowException();
		
		T result = top.toArray()[top.size()-1];
		top.removeLast();
		return result;
	}

	@Override
	public T top() {
		T result = null;
		if(!isEmpty()) result = top.toArray()[top.size()-1];
		return result;
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return top.size() == size;
	}

}
