
public class LLNode<T> {
	
	protected T info; //holds the data
	protected LLNode<T> link; //holds memory address of next node in list
	
	public LLNode(T info) {
		super();
		this.info = info;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public LLNode<T> getLink() {
		return link;
	}
	public void setLink(LLNode<T> link) {
		this.link = link;
	}
}
