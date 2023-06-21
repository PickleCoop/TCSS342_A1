import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class MyArrayListTest
{
	private MyArrayList<Integer> list;
	
	@BeforeEach
	public final void setup()
	{
		list = new MyArrayList<Integer>();
	}
	
	@Test
	public final void size_0()
	{
		assertEquals("size_0 fail", 0, list.size());	
	}
	
	@Test
	public final void size_1()
	{
		list.insert(1, 0);
		assertEquals("size_1 failed", 1, list.size());
	}
	
	@Test
	public final void insert_1()
	{
		list.insert(0, 0);
		list.insert(1, 1);
		list.insert(2, 2);
		assertEquals("insert failed", "[0, 1, 2]", list.toString());	
	}
	
	@Test
	public final void insert_2()
	{
		list.insert(0, 2);
		list.insert(1, 1);
		list.insert(2, 0);
		assertEquals("insert failed", "[2]", list.toString());	
	}
	
	@Test
	public final void index_in_bound()
	{
		list.insert(1, 0);
		assertEquals("index_in_bound failed", 1, list.size());	
	}
	
	@Test
	public final void index_out_of_bound_positive()
	{
		list.insert(1, 1);
		assertEquals("index_out_of_bound_positive failed", 0, list.size());	
	}
	
	@Test
	public final void index_out_of_bound_negative()
	{
		list.insert(1, -1);
		assertEquals("index_out_of_bound_negative failed", 0, list.size());	
	}
	
	@Test
	public final void resize()
	{
		insert_twenty_items(list);
		assertEquals("resize failed", 20, list.size());	
	}
	
	@Test
	public final void contains()
	{
		insert_ten_items(list);
		for (int index = 0; index < 10; index++)
			assertTrue("contains failed", list.contains(index));
	}
	
	@Test
	public final void not_contain()
	{
		insert_ten_items(list);
		for (int index = 10; index < 20; index++)
			assertFalse("not_contain failed", list.contains(index));
	}
	
	@Test
	public final void contains_after_expand()
	{
		insert_twenty_items(list);
		for (int index = 0; index < 20; index++)
			assertTrue("contains_after_expand failed", list.contains(index));
	}
	
	@Test
	public final void not_contain_after_expand()
	{
		insert_twenty_items(list);
		for (int index = 20; index < 40; index++)
			assertFalse("not_contain_after_expand failed", list.contains(index));
	}
	
	@Test
	public final void index_of_has_value()
	{
		insert_ten_items_values_added_5(list);
		for (int index = 0; index < 10; index++)
			assertEquals("index_of_has_value failed", index, list.indexOf(index+5));
	}
	
	@Test
	public final void index_of_value_not_found()
	{
		insert_ten_items_values_added_5(list);
		for (int index = 0; index < 5; index++)
			assertEquals("index_of_value_not_found failed", -1, list.indexOf(index));
		for (int index = 15; index < 20; index++)
			assertEquals("index_of_value_not_found failed", -1, list.indexOf(index));
	}
	
	@Test
	public final void get_in_bound()
	{
		insert_ten_items(list);
		for (int index = 0; index < 10; index++)
			assertEquals("get_in_bound failed", Integer.valueOf(index), list.get(index));
	}
	
	@Test
	public final void get_out_bound()
	{
		insert_ten_items(list);
		for (int index = -5; index < 0; index++)
			assertEquals("get_out_bound failed", null, list.get(index));
		for (int index = 10; index < 15; index++)
			assertEquals("get_out_bound failed", null, list.get(index));
	}
	
	@Test
	public final void set_in_bound()
	{
		insert_ten_items(list);
		list.set(0, -1);
		list.set(2, -1);
		list.set(4, -1);
		list.set(6, -1);
		list.set(8, -1);
		for (int index = 0; index < 10; index++)
			if (index % 2 == 0)
				assertEquals("set_in_bound failed", Integer.valueOf(-1), list.get(index));
			else
				assertEquals("set_in_bound failed", Integer.valueOf(index), list.get(index));
	}
	
	@Test
	public final void set_out_bound()
	{
		insert_ten_items(list);
		list.set(-1, -1);
		list.set(-2, -1);
		list.set(-3, -1);
		list.set(10, -1);
		list.set(11, -1);
		for (int index = 0; index < 10; index++)
			assertEquals("set_out_bound failed", Integer.valueOf(index), list.get(index));
	}
	
	@Test
	public final void empty()
	{
		assertTrue("empty failed", list.isEmpty());	
	}
	
	@Test
	public final void not_empty()
	{
		list.insert(1, 0);
		assertFalse("not_empty failed", list.isEmpty());	
	}
	
	@Test
	public final void not_empty_more_items()
	{
		insert_ten_items(list);
		assertFalse("not_empty_more_items failed", list.isEmpty());	
	}
	
	@Test
	public final void not_empty_after_resize()
	{
		insert_twenty_items(list);
		assertFalse("not_empty_after_resize failed", list.isEmpty());	
	}
	
	@Test
	public final void to_string_1()
	{
		insert_ten_items(list);
		assertEquals("to_string_1 failed", "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());	
	}
	
	@Test
	public final void to_string_2()
	{
		insert_ten_items(list);
		assertEquals("to_string_1 failed", "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());	
		
		list.set(3, -1);
		list.set(6, -1);
		list.set(9, -1);
		assertEquals("to_string_1 failed", "[0, 1, 2, -1, 4, 5, -1, 7, 8, -1]", list.toString());
		
		list.insert(-2, 0);
		list.insert(-2, 6);
		assertEquals("to_string_1 failed", "[-2, 0, 1, 2, -1, 4, -2, 5, -1, 7, 8, -1]", list.toString());
		
		list.remove(2);
		list.remove(6);
		list.remove(8);
		assertEquals("to_string_1 failed", "[-2, 0, 2, -1, 4, -2, -1, 7, -1]", list.toString());
	}
	
	// ---------- helper methods ---------
	
	public final void insert_ten_items(MyArrayList<Integer> list)
	{
		for (int index = 0; index < 10; index++)
			list.insert(index, index);
	}
	
	public final void insert_ten_items_values_added_5(MyArrayList<Integer> list)
	{
		for (int index = 0; index < 10; index++)
			list.insert(index+5, index);
	}
	
	public final void insert_twenty_items(MyArrayList<Integer> list)
	{
		for (int index = 0; index < 20; index++)
			list.insert(index, index);
	}
}


