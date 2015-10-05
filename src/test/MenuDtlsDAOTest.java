package test;

import static org.junit.Assert.*;


import org.junit.Test;
public class MenuDtlsDAOTest {

	@Test
	public void testingMenuDtlsDAO() {
		assertEquals("Here is test for Hello World String: ", "Hello + World", helloWorld());
	}
 
	 
	public String helloWorld() {
		String helloWorld = "Hello +" + " World";
		return helloWorld;
	}

}
