package RA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class GroupAnagrams {
	//Input:{"eat","tea","tan","ate","nat","bat"}; Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	//Initialize hashmap
	//Traverse each string in the input array using a loop
	//Traverse each letter in string with another loop and find sum of the ascii of letters
	//Store in hashmap key as the unique sum of ascii
	//Store list of string to unique keys using set for checking dupliactes
	//sort the result if possible(or any order is fine)
	
	//Notes://Arrays.asList: Returns a fixed-size list backed by the specified array. cannot add/remove element  //unstructured exception
	//https://stackoverflow.com/questions/1206073/sorting-a-collection-of-objects
    
	//Time complexity:: o(n*m)
	//Space compexity: o(n)
	
    @Test
	private void TestData1() {
		// TODO Auto-generated method stub
    	
    	//String[] inputStr = {"eat","tea","tan","ate","nat","bat"};
    	String[] inputStr = {"bat","eat","tea","tan","ate","nat"};
        System.out.println(groupAnagrams(inputStr));

	}
	private Collection<List<String>> groupAnagrams(String[] inputStr) {
		HashMap<Integer, List<String>>  hmap=new HashMap<Integer, List<String>>();
		 Set<Integer> set=new HashSet<Integer>();
		for (int i = 0; i < inputStr.length; i++) {
			    char[] charArray = inputStr[i].toCharArray();
			    int sum=0;
			    for (int j = 0; j < charArray.length; j++) {
			    	int ascii=charArray[j];
			    	sum=sum+ascii;
			    }
			    if(set.add(sum)){
			    	List<String> list1=new ArrayList<String>(Arrays.asList(inputStr[i]));
			    	hmap.put(sum, list1);
			    }
			    else {
			    	List<String> listeach = hmap.get(sum);
			    	listeach.add(inputStr[i]);
			    	hmap.put(sum, listeach);
			    }
		}
	
		return hmap.values();
		// TODO Auto-generated method stub
    
	}
}
