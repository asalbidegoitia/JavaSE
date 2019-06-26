package com.ipartek.formacion.uf2216;

import java.io.Serializable;

public class Revista implements Leible,Comparable<Revista>,Serializable {
	public final int LONGITUD_MAX_TITULO = 150;
	public final int LONGITUD_MIN_TITULO = 3;
	public static final int LONGITUD_ISBN = 10;


	// atributos
	private int id;
	private  String titulo;
	private static int iSBN;
	private static int numPags;
	private static boolean formato;

	// constructora
	public Revista(int id,String titulo, int iSBN, int numPags, boolean formato) throws Exception {
		super();
		this.setId(id);
		this.setTitulo(titulo);
		this.setISBN(iSBN);
		this.setNumPags(numPags);
		this.setFormato(formato);
		/*
		 * this.titulo = titulo; ISBN = iSBN; this.numPags = numPags; this.formato =
		 * formato;
		 */
	}
	

	// getters y setters	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}

	public int getISBN() {
		return iSBN;
	}

	public int getNumPags() {
		return numPags;
	}

	public boolean isFormato() {
		return formato;
	}

	/**
	 * 
	 * @param titulo
	 * @throws Exception
	 */
	public void setTitulo(String titulo) throws Exception {
		if (titulo != null && titulo.length() >= LONGITUD_MIN_TITULO && titulo.length() <= LONGITUD_MAX_TITULO) {
			this.titulo = titulo;
		} else {
			String msg = String
					.format("Titulo debe tener longitud entre " + LONGITUD_MIN_TITULO + " y " + LONGITUD_MAX_TITULO);
			throw new Exception(msg);
		}
	}

	/**
	 * 
	 * @param iSBN
	 * @throws Exception
	 */
	public void setISBN(int iSBN) throws Exception {
		int longitud = String.valueOf(iSBN).length();
		if (iSBN!=0 && longitud==LONGITUD_ISBN) {
			this.iSBN = iSBN;
		}else {
			throw new Exception("Longitud ISBN debe ser "+LONGITUD_ISBN);
		}
	}

	/**
	 * 
	 * @param numPags
	 * @throws Exception
	 */
	public void setNumPags(int numPags) throws Exception {
		if (numPags>=1) {
			this.numPags = numPags;
		}else {
			throw new Exception(" Número de Páginas  debe ser >= 1");
		}
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "Revista [titulo=" + titulo + ", ISBN=" + iSBN + ", numPags=" + numPags + ", formato=" + formato + "]";
	}
	
	@Override
	public int compareTo(Revista r) {
		return r.numPags - this.numPags;
	}
}
