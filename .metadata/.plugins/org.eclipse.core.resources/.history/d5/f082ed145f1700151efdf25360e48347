/**
 * 
 */
package com.here.challenge.iceland;

/**
 * @author Lali
 *
 */
public class Stack<E> {
	E e;
	int MAX_SIZE = 100;
	Object[] items = new Object[MAX_SIZE];
	int top =-1;
	public void push(E e){
		items[++top] = e;
	}
	public E pop(){
		if (top == -1){
			return null;
		}
		E e = (E) items[top];
		items[top] = null;
		top--;
		return e;
	}
	/**
	 * @return the e
	 */
	public E getE() {
		return e;
	}
	/**
	 * @param e the e to set
	 */
	public void setE(E e) {
		this.e = e;
	}
	/**
	 * @return the items
	 */
	public Object[] getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(Object[] items) {
		this.items = items;
	}
	/**
	 * @return the top
	 */
	public int getTop() {
		return top;
	}
	/**
	 * @param top the top to set
	 */
	public void setTop(int top) {
		this.top = top;
	}
	/**
	 * 
	 */
	public Stack() {
		// TODO Auto-generated constructor stub
	}

}
