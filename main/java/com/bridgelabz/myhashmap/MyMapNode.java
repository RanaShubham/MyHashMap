package com.bridgelabz.myhashmap;

import com.bridgelabz.mylinkedlistjava.Node;

public class MyMapNode<K, V> implements Node<K> 
{
	K key;
	V value;
	MyMapNode<K, V> next;
	
	public MyMapNode(K key, V value) {
		this.key = key;
		this.value = value;
		next = null;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public void setKey(K key) {
		// TODO Auto-generated method stub
		this.key = key;
	}

	@Override
	public Node<K> getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public void setNext(Node<K> next) {
		// TODO Auto-generated method stub
		this.next = (MyMapNode<K, V>) next;
	}
	
	public V getValue()
	{
		return this.value;
	}
	
	public void setValue (V value)
	{
		this.value = value;
	}
	
	public String toString()
	{
		StringBuffer myNodeString = new StringBuffer();
		myNodeString.append("{"+"K=")
			.append(this.key).append(":V=").append(this.value).append("}");
		
		if (this.next != null)
			myNodeString.append("->").append(this.next);
		return myNodeString.toString();
	}
}
