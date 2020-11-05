package com.bridgelabz.myhashmaptest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.myhashmap.MyLinkedHashMap;

public class MyLinkedHashMapTest 
{
	@Test
	public void givenASenetenceWtihWordParanoid_ShouldreturnParaniodFrequency()
	{
		String sentence = "Paranoids are not paranoid because they are paranoid but "
				+ "because they keep putting themselves deliberatily into "
				+ "paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		
		String [] words = sentence.toLowerCase().split(" ");
		
		//Below creating node of type MyLinkedHashMap and adding it into one of the bucket's linked node list.
		//Bucket is chosen based on hashCode of key object and in that bucket's linked list, corresponding 
		//node is found based on key. value of node is incremented if the node is already present in that bucket. 
		for (String word: words)
		{
			Integer value = myLinkedHashMap.get(word);
			if( value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		
		System.out.println(myLinkedHashMap);
		int frequency = myLinkedHashMap.get("paranoid");
		Assert.assertEquals(3, frequency);
	}
	
	@Test
	public void givenASenetence_shouldRemoveWordAvoidalbe()
	{
		String sentence = "Paranoids are not paranoid because they are paranoid but "
				+ "because they keep putting themselves deliberatily into "
				+ "paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		
		String [] words = sentence.toLowerCase().split(" ");
		
		for (String word: words)
		{
			Integer value = myLinkedHashMap.get(word);
			if( value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		
		System.out.println(myLinkedHashMap);
		myLinkedHashMap.removeKey("avoidable");
		System.out.println(myLinkedHashMap);
		Assert.assertEquals(null, myLinkedHashMap.get("avoidable"));
	}
}
