package adt.bst;

import java.util.LinkedList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		int result = 0;
		if(!isEmpty()) result = height(root);
		return result-1;
	}
	
	protected int height(BSTNode<T> node) {
		int result = 0;
		if(!node.isEmpty()) {
			result = 1;
			int left = height((BSTNode<T>) node.getLeft());
			int right = height((BSTNode<T>) node.getRight());
			if(left>right) result += left;
			else result += right;
		}
		return result;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> node = root;
		if(element == null || isEmpty()) node = new BSTNode<T>();
		
		else while(!node.isEmpty()) {
			if(node.getData().equals(element)) break;
			if(node.getData().compareTo(element) > 0) node = (BSTNode<T>) node.getLeft();
			else if(node.getData().compareTo(element) < 0) node = (BSTNode<T>) node.getRight();
		}
		
		return node;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insert(T element) {
		
		if(element != null) {
			
			BSTNode<T> node = root;
			
			while(!node.isEmpty()) {
				if(node.getData().compareTo(element) > 0) node = (BSTNode<T>) node.getLeft();
				else if(node.getData().compareTo(element) < 0) node = (BSTNode<T>) node.getRight();
			}
			
			node.setData(element);
			node.setLeft(new BSTNode.Builder()
										.parent(node)
										.build());
			node.setRight(new BSTNode.Builder()
										.parent(node)
										.build());
			
		}
		
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if(!isEmpty()) result = maximum(root);
		return result;
	}
	
	private BSTNode<T> maximum(BSTNode<T> node){
		while(!node.getRight().isEmpty()) node = (BSTNode<T>) node.getRight();
		return (BSTNode<T>) node;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;
		if(!isEmpty()) result = minimum(root);
		return result;
	}
	
	private BSTNode<T> minimum(BSTNode<T> node){
		while(!node.getLeft().isEmpty()) node = (BSTNode<T>) node.getLeft();
		return (BSTNode<T>) node;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if(node.isEmpty()) node = null;
		else if(!node.getRight().isEmpty()) {
			node = minimum((BSTNode<T>) node.getRight());
		}else {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			while(parent != null && node.equals(parent.getRight())) {
				node = parent;
				parent = (BSTNode<T>) parent.getParent();
			}
			node = parent;
		}
		return node;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if(node.isEmpty()) node = null;
		else if(!node.getLeft().isEmpty())
			node = maximum((BSTNode<T>) node.getLeft());
		else {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			while(parent != null && node.equals(parent.getLeft())) {
				node = parent;
				parent = (BSTNode<T>) parent.getParent();
			}
			node = parent;
		}
		return node;
	}

	@Override
	public void remove(T element) {
		remove(search(element));
	}
	
	private void remove(BSTNode<T> node) {
		if(!node.isEmpty()) {
			if(node.isLeaf()) {
				node.setData(null);
			}else if(xor(!node.getLeft().isEmpty(), !node.getRight().isEmpty())) {
				
				BSTNode<T> child = (BSTNode<T>) node.getLeft();
				if(child.isEmpty()) child = (BSTNode<T>) node.getRight();
				BSTNode<T> parent = (BSTNode<T>) node.getParent();
				
				if(!(node.equals(root) && node.getParent() == null)) {
					if(parent.getLeft().equals(node)) parent.setLeft(child);
					else parent.setRight(child);
					child.setParent(parent);
				}else {
					root = child;
					root.setParent(null);
				}
			}else {
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
				
				node.getLeft().setParent(node);
				node.getRight().setParent(node);
			}
		}
	}
	
	//an exclusive OR to make the code more readable
	protected boolean xor(boolean x, boolean y) {
		return (x || y) && !(x && y);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		T[] result = (T[]) new Comparable[0];
		if(!isEmpty()) result = (T[]) preOrder(root, new LinkedList<>()).toArray(new Comparable[size()]);
		return result;
	}
	
	private List<T> preOrder(BSTNode<T> node, List<T> list){
		
		list.add(node.getData());
		if(!node.getLeft().isEmpty()) preOrder((BSTNode<T>) node.getLeft(), list);
		if(!node.getRight().isEmpty()) preOrder((BSTNode<T>) node.getRight(), list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		T[] result = (T[]) new Comparable[0];
		if(!isEmpty()) result = (T[]) order(root, new LinkedList<>()).toArray(new Comparable[size()]);
		return result;
	}
	
	private List<T> order(BSTNode<T> node, List<T> list){
		if(!node.getLeft().isEmpty()) order((BSTNode<T>) node.getLeft(), list);
		list.add(node.getData());
		if(!node.getRight().isEmpty()) order((BSTNode<T>) node.getRight(), list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		T[] result = (T[]) new Comparable[0];
		if(!isEmpty()) result = (T[]) postOrder(root, new LinkedList<>()).toArray(new Comparable[size()]);
		return result;
	}
	
	private List<T> postOrder(BSTNode<T> node, List<T> list){
		if(!node.getLeft().isEmpty()) postOrder((BSTNode<T>) node.getLeft(), list);
		if(!node.getRight().isEmpty()) postOrder((BSTNode<T>) node.getRight(), list);
		list.add(node.getData());
		return list;
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
