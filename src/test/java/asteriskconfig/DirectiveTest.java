package asteriskconfig;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectiveTest {
	@Test
	public void testConstructor() {
		Directive entry = new Directive("foo", "bar");
		assertEquals("foo", entry.getKey());
		assertEquals("bar", entry.getValue());

		entry = new Directive("bob","alice","mycomment");
		assertEquals("bob", entry.getKey());
		assertEquals("alice", entry.getValue());
		assertEquals("mycomment", entry.getComment());
	}

	@Test
	public void testSerialization() {
		Directive entry = new Directive("foo","bar");
		assertEquals(String.format("foo => bar"), entry.toString());

		entry = new Directive("bob","alice","mycomment");
		assertEquals(String.format("bob => alice%s; mycomment", GlobalSettings.getInstance().getInlineCommentPrefix()), entry.toString());
	}
}
