package customs;

public class MyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	class Node<T>{
		
		Node(T value){
			this.value = value;
		}
		
		private Node<T> prev;
		private Node<T> next;
		private T value;
		
	}
	
	public void add(T item){
		Node newNode = new Node<>(item);
		if(isEmplty()){
			this.head = newNode;
			this.tail = newNode;
		}
		else{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}
	
	public T get(int index){
		if(index >= size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		else{
			Node<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.value;
		}
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmplty(){
		return this.size == 0;
	}
	
}
