/**
 * 
 * @author Jack Mayrides
 *
 */

public class RecursiveLinkedCollection<T> implements CollectionInterface<T> {

	LLNode<T> front;
	int size;

	RecursiveLinkedCollection() {

		front = null;
		size = 0;

	}

	@Override
	//add element to real
	public boolean add(T element) {

		front = recAdd(front, element);
		size++;

		return true;

	}

	private LLNode<T> recAdd(LLNode<T> node, T element) {

		if(node != null) {

			node.setLink(recAdd(node.getLink(), element));

		} else {

			node = new LLNode<>(element);

		}

		return node;

	}

	@Override
	public T get(T target) {

		return recGet(front, target);

	}

	private T recGet(LLNode<T> node, T target) {

		if(node == null)
			return null;

		if(node.getInfo().equals(target))
			return node.getInfo();

		else
			return recGet(node.getLink(), target);

	}

	@Override
	public boolean remove(T element) {

		front = recRemove(front, element);

		if(size() < size) {

			size--;
			return true;

		}


		return false;


	}

	private LLNode<T> recRemove(LLNode<T> node, T element) {


		if(!node.getLink().getInfo().equals(element)) {

			recRemove(node.getLink(), element);

		} else {
			
			node.setLink((node.getLink()).getLink());
			
		}

		return node;

	}

	@Override
	public boolean contains(T target) {

		return recContains(front, target);

	}

	private boolean recContains(LLNode<T> node, T target) {

		if(node == null)
			return false;

		if(node.getInfo().equals(target))
			return true;

		return recContains(node.getLink(), target);

	}

	@Override
	public boolean isFull() {

		return false;

	}

	@Override
	public boolean isEmpty() {

		return (front == null);

	}

	@Override
	public int size() {

		return recSize(front);

	}

	private int recSize(LLNode<T> node) {

		if(node == null)
			return 0;

		return(1 + recSize(node.getLink()));

	}

	public String toString() {

		if(isEmpty())
			return "";

		String retStr = front.getInfo().toString() + ",";
		LLNode<T> temp = front.getLink();

		while(temp != null) {

			retStr += temp.getInfo().toString();

			if(temp.getLink() != null)
				retStr += ",";

			temp = temp.getLink();

		}

		return retStr;

	}

}
