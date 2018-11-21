package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode<T>(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode<T>(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void insert(int key, T newValue, int height) {
		if(newValue != null && height > -1 && height <= this.maxHeight) {
			SkipListNode<T>[] update = new SkipListNode[maxHeight];
			SkipListNode<T> node = root;
			for(int i = maxHeight-1; i > -1; i--) {
				while(node.forward[i].key < key)
					node = node.forward[i];
				update[i] = node;
			}
			node = node.forward[0];
			if(node.key == key) node.value = newValue;
			else {
				node = new SkipListNode<>(key, height, newValue);
				for(int i = 0; i < height; i++) {
					node.forward[i] = update[i].forward[i];
					update[i].forward[i] = node;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(int key) {
		SkipListNode<T>[] update = new SkipListNode[maxHeight];
		SkipListNode<T> node = root;
		for(int i = maxHeight-1; i > -1; i--) {
			while(node.forward[i].key < key)
				node = node.forward[i];
			update[i] = node;
		}
		node = node.forward[0];
		if(node.key == key) {
			for(int i = 0; i < node.height(); i++) {
				update[i].forward[i] = node.forward[i];
			}
		}
	}

	@Override
	public int height() {
		return maxHeight;
	}

	@Override
	public SkipListNode<T> search(int key) {
		
		SkipListNode<T> result = root;
		
		for(int i = maxHeight-1; i > -1; i--)
			while(result.forward[i].key < key)
				result = result.forward[i];
		result = result.forward[0];
		
		if(result.key != key) result = null;
		return result;
	}

	@Override
	public int size() {
		int result = 0;
		
		SkipListNode<T> node = root;
		while(node.forward[0].value != null) {
			result++;
			node = node.forward[0];
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SkipListNode<T>[] toArray() {
		SkipListNode<T>[] result = new SkipListNode[size()+2];
		SkipListNode<T> node = root;
		for(int i = 0; i < result.length; i++) {
			result[i] = node;
			node = node.forward[0];
		}
		return result;
	}

}
