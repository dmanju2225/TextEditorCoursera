/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		assertEquals("Remove: check size is correct ", 2, shortList.size);
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		String b=shortList.remove(1);
		assertEquals("Remove: check b is correct ","B", b);
		assertEquals("Remove: check element 0 is correct ", "A", shortList.get(0));
		assertEquals("Remove: check shortList size is correct ", 1, shortList.size());
		String c=shortList.remove(0);
		assertEquals("Remove: check shortList size is correct ", 0, shortList.size());
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.remove(1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		int l=longerList.remove(5);
		assertEquals("Remove: check l is correct ",5, l);
		assertEquals("Remove: check element 0 is correct ", (Integer)9, longerList.get(8));
		assertEquals("Remove: check shortList size is correct ", 9, longerList.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		assertEquals("addend :check size is correct ", 2, shortList.size());
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		try {
			list1.add(null);
			fail("cannot add null");
		}
		catch (NullPointerException e) {
		
		}
		
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals(" check shortList size is correct ", 2, shortList.size());
		assertEquals(" check emptyList size is correct ", 0, emptyList.size());
		assertEquals(" check longList size is correct ", 10, longerList.size());
		assertEquals(" check List1 size is correct ", 3, list1.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex ()
	{
        // TODO: implement this test
		shortList.add(1,"C");
		list1.add(0,23);
		longerList.add(9,10);
		assertEquals("Check shortlist index 1 element", "C", shortList.get(1));
		assertEquals("Check shortlist index 2 element", "B", shortList.get(2));
		assertEquals(" check shortList size is correct ", 3, shortList.size());
		assertEquals("Check list1 index 0 element", (Integer)23, list1.get(0));
		assertEquals("Check list1 index 1 element", (Integer)65, list1.get(1));
		assertEquals(" check List1 size is correct ", 4, list1.size());
		assertEquals("Check longer1ist index 9 element", (Integer)10, longerList.get(9));
		assertEquals("Check longerlist index 10 element", (Integer)9, longerList.get(10));
		assertEquals(" check longerList size is correct ", 11, longerList.size());
		
		try {
			list1.add(3,null);
			fail("cannot add null");
		}
		catch (NullPointerException e) {
		
		}
		
		try {
			list1.add(5,33);
			fail("check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		assertEquals(" check List1 size is correct ", 4, list1.size());
		
		try {
			list1.add(-1,33);
			fail("check out of bounds:Lower bound");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		assertEquals(" check List1 size is correct ", 4, list1.size());
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		String sreplaced = shortList.set(1,"D");
		int longReplaced=longerList.set(9,12);
		int list1Replaced=list1.set(2,81);
		assertEquals("Check shortlist index 1 element", "D", shortList.get(1));
		assertEquals("Check shortlist index 0 element", "A", shortList.get(0));
		assertEquals(" check shortList size is correct ", 2, shortList.size());
		assertEquals("Check list1 index 0 element", (Integer)81, list1.get(2));
		assertEquals("Check shortlist index 2 element", (Integer)21, list1.get(1));
		assertEquals(" check shortList size is correct ", 3, list1.size());
		assertEquals("Check longer1ist index 9 element", (Integer)12, longerList.get(9));
		assertEquals("Check longerlist index 10 element", (Integer)8, longerList.get(8));
		assertEquals(" check longerList size is correct ", 10, longerList.size());
		try {
			shortList.set(-1,"F");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(2,"E");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(1,null);
			fail("cannot set null");
		}
		catch (NullPointerException e) {
		
		}
		try {
			emptyList.set(0,1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		
		
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
