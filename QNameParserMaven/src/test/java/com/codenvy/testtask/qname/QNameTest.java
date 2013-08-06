package com.codenvy.testtask.qname;

import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.Test;

import com.codenvy.testtask.qname.IllegalNameException;
import com.codenvy.testtask.qname.QName;

/**
 * Codenvy. Test task
 * 
 * Testing of QName Parser by JUnit
 * 
 * @author Vladimir Bezpalchuk
 * 
 * @version 1.0 03 Aug 2013.
 */

public class QNameTest {

	/**
	 * Test method for
	 * {@link com.codenvy.testtask.qname.QName#parse(java.lang.String)}.
	 */
	
	private QName[] qN = new QName[20]; // Array of QName's for testing
	
	/**
	* Method tests correct creating of QName instances.
	*/	
	@Test
	public void testParse0() throws IllegalNameException {

		assertNotNull("correct", new QName("prefix","name"));
		assertNotNull("correct", new QName("prefix","na me"));
		assertNotNull("correct", new QName("","name"));

	}

	/**
	* Expected correct answer.
	*/	
	@Test
	public void testParse1() throws IllegalNameException {

		assertNotNull("correct", qN[0] = QName.parse("name"));

	}
	
	/**
	* Expected correct answer.
	*/	
	@Test
	public void testParse2() throws IllegalNameException {

		assertNotNull("correct", qN[1] = QName.parse("prefix:name"));

	}
	
	/**
	* Expected correct answer.
	*/	
	@Test
	public void testParse3() throws IllegalNameException {

		assertNotNull("correct", qN[2] = QName.parse("prefix:na me"));

	}
	
	/**
	* Expected correct answer.
	*/	
	@Test
	public void testParse4() throws IllegalNameException {

		assertNotNull("correct", qN[3] = QName.parse("x:p"));

	}
	
	/**
	* Expected correct answer.
	*/	
	@Test
	public void testParse5() throws IllegalNameException {

		assertNotNull("correct", qN[4] = QName.parse("u:a1"));

	}
		
	/**
	* Expected correct answer.
	*/	
	@Test
	public void testParse6() throws IllegalNameException {

		assertNotNull("correct", qN[5] = QName.parse("a-:-"));

	}
	
	/**
	* Expected correct answer.
	*/	
	@Test
	public void testParse7() throws IllegalNameException {

		assertNotNull("correct", qN[6] = QName.parse("n"));

	}
	
	@Test(expected = Exception.class)
	public void testParse8() throws IllegalNameException {

		qN[7] = QName.parse("");

	}

	@Test(expected = Exception.class)
	public void testParse9() throws IllegalNameException {

		qN[8] = QName.parse(":name");

	}

	@Test(expected = Exception.class)
	public void testParse10() throws IllegalNameException {

		qN[9] = QName.parse(".");

		qN[10] = QName.parse("..");

	}
	
	@Test(expected = Exception.class)
	public void testParse11() throws IllegalNameException {

		qN[11] = QName.parse("prefix:");

	}
	
	@Test(expected = Exception.class)
	public void testParse12() throws IllegalNameException {

		qN[12] = QName.parse(" name");

	}
	
	@Test(expected = Exception.class)
	public void testParse13() throws IllegalNameException {

		qN[13] = QName.parse(" prefix:name");

	}
	
	@Test(expected = Exception.class)
	public void testParse14() throws IllegalNameException {

		qN[14] = QName.parse(" prefix: name");

	}

	@Test(expected = Exception.class)
	public void testParse15() throws IllegalNameException {

		qN[15] = QName.parse("prefix:name ");

	}
	
	@Test(expected = Exception.class)
	public void testParse16() throws IllegalNameException {

		qN[16] = QName.parse("pre fix:name");

	}
	
	@Test(expected = Exception.class)
	public void testParse17() throws IllegalNameException {

		qN[17] = QName.parse("name/name");

	}
	
	@Test(expected = Exception.class)
	public void testParse18() throws IllegalNameException {

		qN[18] = QName.parse("name[name");

	}
	
	@Test(expected = Exception.class)
	public void testParse19() throws IllegalNameException {

		qN[19] = QName.parse("prefix:name:name");

	}
}
