package spelling;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should convert the 
	 * string to all lower case before you insert it. 
	 * 
	 * This method adds a word by creating and linking the necessary trie nodes 
	 * into the trie, as described outlined in the videos for this week. It 
	 * should appropriately use existing nodes in the trie, only creating new 
	 * nodes when necessary. E.g. If the word "no" is already in the trie, 
	 * then adding the word "now" would add only one additional node 
	 * (for the 'w').
	 * 
	 * @return true if the word was successfully added or false if it already exists
	 * in the dictionary.
	 */
   
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		
		 TrieNode temp=root;
		char[] ch=word.toLowerCase().toCharArray();
		int i=0;
		TrieNode newNode = null;
		int flag=0;
		while(i<word.length()){
			Character c=ch[i];
		 newNode=temp.insert(c);
		if(newNode!=null){
			temp=newNode;
			flag=1;
		}
		else{
			temp=temp.getChild(c);			
		}
		i++;
		}
		if(flag==0&&temp.endsWord()==true){
			return false;
		}
		
		temp.setEndsWord(true);
		 size++;
	    return true;
	   
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return size;
	}
	
	
	/** Returns whether the string is a word in the trie, using the algorithm
	 * described in the videos for this week. */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		char[] ch=s.toLowerCase().toCharArray();
		TrieNode temp=root;
		
		int i=0;
		while(i<s.length()){
			Set<Character> set=temp.getValidNextCharacters();
			if(set.contains(ch[i])){
				temp=temp.getChild(ch[i]);
			}
			else{
				return false;
			}
			i++;
		}
		
		return temp.endsWord();
	}

	/** 
     * Return a list, in order of increasing (non-decreasing) word length,
     * containing the numCompletions shortest legal completions 
     * of the prefix string. All legal completions must be valid words in the 
     * dictionary. If the prefix itself is a valid word, it is included 
     * in the list of returned words. 
     * 
     * The list of completions must contain 
     * all of the shortest completions, but when there are ties, it may break 
     * them in any order. For example, if there the prefix string is "ste" and 
     * only the words "step", "stem", "stew", "steer" and "steep" are in the 
     * dictionary, when the user asks for 4 completions, the list must include 
     * "step", "stem" and "stew", but may include either the word 
     * "steer" or "steep".
     * 
     * If this string prefix is not in the trie, it returns an empty list.
     * 
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to numCompletions best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 List<String> completions=new ArrayList<String>();
    	 char[] ch=prefix.toLowerCase().toCharArray();
 		TrieNode temp=root;
 		int i=0;
 		
 		while(i<prefix.length()){
 			temp=temp.getChild(ch[i]);
 			if(temp==null){
 				return completions;
 			}
 			i++;
 		}
 		if(temp!=null&&temp.getText().equals(prefix)){
 			Queue<TrieNode> q=new LinkedList<TrieNode>();
 			q.add(temp);
 			while((!q.isEmpty())&&completions.size()<numCompletions){
 				TrieNode removed=q.remove();
 				if(removed.endsWord()){
 					completions.add(removed.getText());
 				}
 				Set<Character> set=removed.getValidNextCharacters();
 				Iterator<Character> it=set.iterator();
 				while(it.hasNext()){
 					Character chr = (Character) it.next();
 					q.add(removed.getChild(chr));
 				}
 			}
 			return completions;
 		}
 		else{
 			return completions;
 		}
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}