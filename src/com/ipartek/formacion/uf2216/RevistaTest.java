package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RevistaTest {
	public final int LONGITUD_MAX_TITULO = 150;
	public final int LONGITUD_MIN_TITULO = 3;
	public static final int LONGITUD_ISBN = 10;

	// atributos
	int id=1;
	String titulo="aaaa";
	int iSBN=15;
	int numPags=11;
	boolean formato=true;
	static Revista r;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		r = new Revista(id,titulo, iSBN, numPags, formato);
		r.setId(id);
		r.setTitulo(titulo);
		r.setISBN(iSBN);
		r.setNumPags(numPags);
		r.setFormato(formato);
	}

	@After
	public void tearDown() throws Exception {
		r=null;
	}

	@Test
	public void testGetTitulo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetISBN() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumPags() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsFormato() {
		fail("Not yet implemented");
	}

	@Test (expected = Exception.class)
	public void testSetTitulo() throws Exception {
		/*
		r.setTitulo("aa");
		assertFalse("menor que LONGITUD_MINIMA",r.getTitulo());
	
		r.setTitulo("aaaaaaaaaaaaaa");
		assertTrue("En el intervalo",r.getTitulo());
		*/
	}

	@Test (expected = Exception.class)
	public void testSetISBN() throws Exception {
		fail("Not yet implemented");
	}

	@Test (expected = Exception.class)
	public void testSetNumPags() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFormato() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
