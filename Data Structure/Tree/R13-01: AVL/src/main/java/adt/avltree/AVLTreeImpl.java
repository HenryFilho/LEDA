package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.
	@Override
	public void insert(T element) {
		if(element != null) insertRecursive(root,element);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void insertRecursive(BSTNode<T> node, T element) {
		if(node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder()
										.parent(node)
									    .build());
			node.setRight(new BSTNode.Builder()
										.parent(node)
										.build());
		}else {
			if(element.compareTo(node.getData()) < 0) insertRecursive((BSTNode<T>) node.getLeft(), element);
			else if(element.compareTo(node.getData()) > 0) insertRecursive((BSTNode<T>) node.getRight(), element);
		}
		rebalance(node);
	}

	@Override
	public void remove(T element) {
		removeRecursive(search(element));
	}

	private void removeRecursive(BSTNode<T> node) {
		if(!node.isEmpty()) {
			if(node.isLeaf()) {
				node.setData(null);
				rebalanceUp((BSTNode<T>) node.getParent());
			}else if(xor(!node.getLeft().isEmpty(), !node.getRight().isEmpty())) {
				BTNode<T> child = node.getLeft();
				if(child.isEmpty()) child = node.getRight();
				BTNode<T> parent = node.getParent();
				
				if(!(node.equals(root) && node.getParent() == null)) {
					if(parent.getLeft().equals(node)) parent.setLeft(child);
					else parent.setRight(child);
				}else {
					root = (BSTNode<T>) child;
					root.setParent(null);
				}
				rebalanceUp(node);
			}else {
				BTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				removeRecursive((BSTNode<T>) sucessor);
				
				node.getLeft().setParent(node);
				node.getRight().setParent(node);
			}
		}
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int result = 0;
		if(!node.isEmpty()) result = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		return result;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		if(Math.abs(balance)>1) {
			if(balance < -1) {
				int rightBalance = calculateBalance((BSTNode<T>) node.getRight());
				if(rightBalance > 0)
					Util.rightRotation((BSTNode<T>) node.getRight());
				Util.leftRotation(node);
			}else {
				int leftBalance = calculateBalance((BSTNode<T>) node.getLeft());
				if(leftBalance < 0)
					Util.leftRotation((BSTNode<T>) node.getLeft());
				Util.rightRotation(node);
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BTNode<T> parent = node.getParent();
		while(parent != null) {
			rebalance((BSTNode<T>) parent);
			parent = parent.getParent();
		}
	}
}
