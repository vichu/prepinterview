/*
Given a list of words, write a function which
# takes in the list, and groups the words together
# according to which ones are anagrams of each other
# e.g.
# input = ["art", "rat", "bats", "banana", "stab", "tar"]
# output = [["art", "rat", "tar], ["bats", "stab"], ["banana"]]
*/

import java.util.*;

class AnagramsGroup {
	
	public List<List<String>> getAnagramsGroup(String[] wordArray) {
		
		HashMap<String, List<String>> wordMap = new HashMap<>();
		if(wordArray == null)
			return null;
		for(String word : wordArray) {
			
			char[] charArray = word.toCharArray();
			Arrays.sort(charArray);
			String sortedWord = new String(charArray);
			
			if(wordMap.get(sortedWord) == null)
			{
				wordMap.put(sortedWord, new ArrayList<String>());
				wordMap.get(sortedWord).add(word);
			}
			else
			{
				wordMap.get(sortedWord).add(word);
			}
		}
		
		List<List<String>> resultMap = new ArrayList<List<String>>();
		for(String key : wordMap.keySet()) {
			resultMap.add(wordMap.get(key));
		}
		
		return resultMap;
	}
	
	
	public static void main(String[] args) {
		AnagramsGroup groupAnagrams = new AnagramsGroup();
		
		String[] str = {"art", "rat", "bats", "banana", "stab", "tar"};
		System.out.println(groupAnagrams.getAnagramsGroup(str));
	}
	
}