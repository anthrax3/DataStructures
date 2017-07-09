package singlylinkedlist;

//@autor mcanv

public class SinglyLinkedList<E> {

	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	public SinglyLinkedList() {

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {

		if (isEmpty())
			return null;
		return head.getElement();

	}
	public E last(){
		if(isEmpty())
			return null;
		return tail.getElement();
	}
	public void addFirst(E e){
		head = new Node<>(e,head);// 'e' adında gelecek olan yeni node'u nexti head'e atanıyor
		if(size==0)//liste boşmu
			tail = head; //boş ise head tail olur
		size++;//eleman eklendiğinden size arttırılır
	}
	public void addLast(E e){
		Node<E> newest = new Node<>(e,null);//yeni gelecek node,next'i null'ı işaret ediyor
		if(isEmpty())//eğer liste boşssa elemanın headi kendisi olur
			head=newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	public E removeFirst(){
		if(isEmpty()) return null;
		E answer =head.getElement();
		head = head.getNext();
		size--;
		if(size==0)
			tail=null;
		return answer;
	}

}
