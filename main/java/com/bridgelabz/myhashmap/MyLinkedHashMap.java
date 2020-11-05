package com.bridgelabz.myhashmap;

import java.util.ArrayList;

import com.bridgelabz.mylinkedlistjava.MyLinkedList;
import com.bridgelabz.mylinkedlistjava.NodeNotFoundException;

public class MyLinkedHashMap<K, V>
{
	private final int numberOfBuckets;
	ArrayList <MyLinkedList<K>> myBucketArray;

	public MyLinkedHashMap()
	{
		this.numberOfBuckets = 10;
		this.myBucketArray = new ArrayList<>(numberOfBuckets);
		
		//Initializing empty buckets in bucket array
		for (int i = 0; i < numberOfBuckets; i++)
		{
			this.myBucketArray.add(null);
		}
	}
	
	/**
	 * Calculates and returns the index of bucket array for a node based on the hashCode of it's key.
	 * @param key
	 * @return
	 */
	private int getBucketIndex(K key) 
	{
		if(key == null)
			return (Integer) null;
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % this.numberOfBuckets;
		return index;
	}
	
	/**
	 * @return Number of indices in the bucket array list.
	 */
	public int getNumberOfBuckets() 
	{
		return this.numberOfBuckets;
	}
	
	/**
	 * To get a node value by passing key.
	 * @param key
	 * @return
	 */
	public V get(K key) 
	{
		int index = this.getBucketIndex(key);
		MyLinkedList <K> myLinkedList = this.myBucketArray.get(index);
		if(myLinkedList == null)
			return null;
		
		try {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.findNodeWithKey(key);
			return myMapNode.getValue();
		} catch (NodeNotFoundException e) 
		{
			return null;
		}
	}

	/**
	 * Adds a map node at the bottom of a MapNode List. If bucket that should contain the Map node list is empty
	 * then a new empty MapNode list will be created in that bucket and then Map node is added to it. Idea behind choosing
	 * bucket for a node is that the remainder of the division of hashCode of node's key with 10 will give number from 0 to 9.
	 * And this number will be chosen to pick one of the index in ArrayList of buckets. If the chosen bucket(index) is empty then
	 * we initialize a new empty Node list of type MyLinkedList and add the node list in that bucket to populate it with it's
	 * first element. If the bucket is not empty and already contains some linked node list then we add our new map node at
	 * the last of this node list.
	 * @param key index of the bucket
	 * @param value
	 */
	public void add(K key, V value) 
	{
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		
		if(myLinkedList == null)
		{
			myLinkedList = new MyLinkedList<>();
			this.myBucketArray.set(index, myLinkedList);
		}
		
		try {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.findNodeWithKey(key);
			myMapNode.setValue(value);
		} catch (NodeNotFoundException e) {
			MyMapNode<K, V> myMapNode = new MyMapNode<>(key, value);
			myLinkedList.addBottom(myMapNode);
		}
	}
	
	/**
	 * Removes a node with a given key
	 * @param key
	 */
	public void removeKey(K key)
	{
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		myLinkedList.removeNodeWithKey(key);
		
	}
	
	/**
	 *myBucketArray is of type array list, and contents of it is of type myLinkedList, which has it's own toString() defined.
	 *Hence to convert this to array, MyLinkedList's toString() method is called.
	 */
	public String toString()
	{
		return "MyLinkedHashMap list{"+myBucketArray+"}";
	}
}
