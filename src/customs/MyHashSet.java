package customs;

public class MyHashSet<T> {

	private static final int INITIAL_CAPACITY = 16;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private MyLinkedList<T>[] cells;
	private int size = 0;
	private float loadFactor;
	
	public MyHashSet(){
		this.cells = new MyLinkedList[INITIAL_CAPACITY];
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		fillCells();
	}
	
	public MyHashSet(int capacity, float loadFactor){
		this.cells = new MyLinkedList[capacity];
		this.loadFactor = loadFactor;
		fillCells();
	}
	
	private void fillCells(){
		for (int i = 0; i < cells.length; i++) {
			cells[i] = new MyLinkedList<>();
		}
	}

	public boolean add(T item){
		int index = item.hashCode()%cells.length;
		MyLinkedList list = cells[index];
		if(list.isEmplty()){
			list.add(item);
			size++;
			return true;
		}
		else{
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).equals(item)){
					return false;
				}
			}
			list.add(item);
			size++;
			return true;
		}
	}

	public int size(){
		return size;
	}

}
