package com.bridgelabz.myhashmap;

import com.bridgelabz.mylinkedlistjava.MyLinkedList;
import com.bridgelabz.mylinkedlistjava.NodeNotFoundException;

public class MyHashMap <K, V> 
{
	MyLinkedList<K> myLinkedList;
	
	public MyHashMap()
	{
		this.myLinkedList = new MyLinkedList<>();
	}

	public V get(K key) 
	{
		try {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.findNodeWithKey(key);
			return myMapNode.getValue();
		} catch (NodeNotFoundException e) {
			return null;
		}		
	}

	public void add(K key, V value) 
	{
		try {
			
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.findNodeWithKey(key);
			myMapNode.setValue(value);
			
		}
		catch (NodeNotFoundException e) 
		{
			MyMapNode<K, V> myMapNode = new MyMapNode<>(key, value);
			this.myLinkedList.addBottom(myMapNode);
		}
	}
	
	public String toString()
	{
		return "MyHashMapNodes{"+ myLinkedList +"}";
	}
}
