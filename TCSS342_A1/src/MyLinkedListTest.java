import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest
{
	private MyLinkedList<Integer> list;
	
	@BeforeEach
	public final void setup()
	{
		list = new MyLinkedList<Integer>();
	}

	@Test
	public final void add_before()
	{
		list.addBefore(1);
		list.addBefore(2);
		list.addBefore(3);
		list.addBefore(4);
		assertEquals("add_before fail", "[1, 2, 3, 4]", list.toString());
		assertEquals("add_before fail", null, list.current());
		assertEquals("add_before fail", Integer.valueOf(1), list.first());
		assertEquals("add_before fail", Integer.valueOf(1), list.current());
		assertEquals("add_before fail", Integer.valueOf(2), list.next());
		assertEquals("add_before fail", Integer.valueOf(2), list.current());
		assertEquals("add_before fail", 4, list.size());
	}
	
	@Test
	public final void add_after()
	{
		list.addAfter(1);
		list.addAfter(2);
		list.addAfter(3);
		list.addAfter(4);
		assertEquals("add_after fail", "[]", list.toString());
		assertEquals("add_after fail", 0, list.size());
	}
	
	@Test
	public final void add_after_1()
	{
		list.addBefore(1);
		list.first();
		list.addAfter(2);
		list.addAfter(3);
		list.addAfter(4);
		assertEquals("add_after_1 fail", "[1, 4, 3, 2]", list.toString());
		assertEquals("add_after_1 fail", 4, list.size());
	}
	
	@Test
	public final void remove()
	{
		insert_ten_items(list);
		assertEquals("remove fail", null, list.remove());
		assertEquals("remove fail", "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
		assertEquals("remove fail", Integer.valueOf(0), list.first());
		assertEquals("remove fail", Integer.valueOf(0), list.remove());
		assertEquals("remove fail", "[1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
		assertEquals("remove fail", Integer.valueOf(2), list.next());
		assertEquals("remove fail", Integer.valueOf(3), list.next());
		assertEquals("remove fail", Integer.valueOf(4), list.next());
		assertEquals("remove fail", Integer.valueOf(4), list.remove());
		assertEquals("remove fail", "[1, 2, 3, 5, 6, 7, 8, 9]", list.toString());
		assertEquals("remove fail", 8, list.size());
	}
	
	@Test
	public final void contains_and_not()
	{
		insert_ten_items(list);
		assertTrue("contains_and_not fail", list.contains(3));
		assertFalse("contains_and_not fail", list.contains(100));
		assertEquals("contains_and_not fail", Integer.valueOf(0), list.first());
		assertEquals("contains_and_not fail", Integer.valueOf(1), list.next());
		assertEquals("contains_and_not fail", Integer.valueOf(2), list.next());
		assertEquals("contains_and_not fail", Integer.valueOf(3), list.next());
		assertEquals("contains_and_not fail", Integer.valueOf(3), list.remove());
		assertFalse("contains_and_not fail", list.contains(3));
		assertEquals("contains_and_not fail", "[0, 1, 2, 4, 5, 6, 7, 8, 9]", list.toString());
	}
	
	@Test
	public final void empty()
	{
		assertTrue("empty fail", list.isEmpty());
		assertEquals("empty fail", "[]", list.toString());
	}
	
	@Test
	public final void not_empty()
	{
		insert_ten_items(list);
		assertFalse("not_empty fail", list.isEmpty());
		assertEquals("not_empty fail", "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
	}
	
	@Test
	public final void from_instruction()
	{
		assertEquals("from_instruction fail", "[]", list.toString());
		list.addBefore(1);
		assertEquals("from_instruction fail", "[1]", list.toString());
		list.addBefore(2);
		assertEquals("from_instruction fail", "[1, 2]", list.toString());
		list.addBefore(3);
		assertEquals("from_instruction fail", "[1, 2, 3]", list.toString());
		assertEquals("from_instruction fail", Integer.valueOf(1), list.first());
		list.addAfter(4);
		assertEquals("from_instruction fail", "[1, 4, 2, 3]", list.toString());
		assertEquals("from_instruction fail", Integer.valueOf(1), list.current());
		assertEquals("from_instruction fail", Integer.valueOf(4), list.next());
		assertEquals("from_instruction fail", "[1, 4, 2, 3]", list.toString());
		assertEquals("from_instruction fail", Integer.valueOf(4), list.current());
		assertEquals("from_instruction fail", "[1, 4, 2, 3]", list.toString());
		assertEquals("from_instruction fail", Integer.valueOf(2), list.next());
		assertEquals("from_instruction fail", "[1, 4, 2, 3]", list.toString());
		assertEquals("from_instruction fail", Integer.valueOf(2), list.current());
		list.addBefore(5);
		assertEquals("from_instruction fail", "[1, 4, 5, 2, 3]", list.toString());
		list.addBefore(6);
		assertEquals("from_instruction fail", "[1, 4, 5, 6, 2, 3]", list.toString());
		assertEquals("from_instruction fail", Integer.valueOf(2), list.remove());
		assertEquals("from_instruction fail", "[1, 4, 5, 6, 3]", list.toString());
	}
	
	// ---------- helper methods ---------
	
	public final void insert_ten_items(MyLinkedList<Integer> list)
	{
		for (int index = 0; index < 10; index++)
			list.addBefore(index);
	}
}


