package adt.bst.extended;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public T[] sort(T[] array) {
		emptyTree();
		for(T t : array) insert(t);
		return order();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insert(T element) {
		
		if(element != null) {
			
			BSTNode<T> node = root;
			
			while(!node.isEmpty()) {
				if(comparator.compare(node.getData(), element) > 0) node = (BSTNode<T>) node.getLeft();
				else if(comparator.compare(node.getData(), element) < 0) node = (BSTNode<T>) node.getRight();
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
	
	private void emptyTree() {
		while(size()>0) remove(root.getData());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] reverseOrder() {
		T[] result = (T[]) new Comparable[0];
		if(!isEmpty()) result = (T[]) reverseOrder(root, new LinkedList<>()).toArray(new Comparable[size()]);
		return result;
	}
	
	private List<T> reverseOrder(BSTNode<T> node, List<T> list){
		if(!node.getRight().isEmpty()) reverseOrder((BSTNode<T>) node.getRight(), list);
		list.add(node.getData());
		if(!node.getLeft().isEmpty()) reverseOrder((BSTNode<T>) node.getLeft(), list);
		return list;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
