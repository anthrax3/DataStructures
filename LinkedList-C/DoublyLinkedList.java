package singlylinkedlist;


//@autor mcanv

public class DoublyLinkedList<E> {

	private static class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;

		public Node(E e, Node<E> n,Node<E> p) {
			element = e;
			next = n;
			prev = p;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}
		public Node<E> getPrev(){
			return prev;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
		public void setPrev(Node<E> p){
			prev = p;
		}
	}
	
	private Node<E> header;
	private Node<E> trailer;
	private int size =0;
	
	public DoublyLinkedList(){
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	public int size(){
		return size;
	}
	public boolean isEmty(){
		return size==0;
	}
	public E first(){
		if (isEmty())
			return null;
		return header.getNext().getElement();
	}
	public E last(){
		if(isEmty())
			return null;
		return trailer.getPrev().getElement();
	}
	public void addFirst(E e){
		addBetween(e,header,header.getNext());
	}
	public void addLast(E e){
		addBetween(e,trailer.getPrev(),trailer);
	}
	public E removeFirst(){
		if(isEmty())
			return null;
		return remove(header.getNext());
	}
	public E removeLast(){
		if(isEmty())
			return null;
		return remove(trailer.getPrev());
	}
	private void addBetween(E e,Node<E> pred,Node<E> succ){
		Node<E> newest = new Node<E>(e,pred,succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
	}
	private E remove(Node<E> node){
		Node<E> pred = node.getPrev();
		Node<E> succ = node.getNext();
		pred.setNext(succ);
		succ.setPrev(pred);
		size--;
		return node.getElement();
	}
	
	
	
	
	
	
}
