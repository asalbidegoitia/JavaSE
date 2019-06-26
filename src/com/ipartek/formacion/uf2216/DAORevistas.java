package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;






public class DAORevistas implements IPersistible<Revista> {
	private static DAORevistas INSTANCE;
	private ArrayList<Revista> lista; // lo inicializamos en el constructor

	/**
	 * Encargado de devolver solo 1 objeto, patron Singleton
	 * 
	 * @return
	 */
	public static DAORevistas getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DAORevistas();
		}
		return INSTANCE;

	}

	/**
	 * Privado para que nadie pueda crear objetos (Singleton)
	 */
	private DAORevistas() {
		super();
		this.lista = new ArrayList<Revista>();		
	}

	public List<Revista> getAll() {
		return lista;
	}

	public Revista getById(int id) {
		Revista resul = null;
		for (Revista revista : lista) {
			if (revista.getId() == id) {
				resul = revista;
				break;
			}
		}
		return resul;
	}

	public boolean insert(Revista pojo) {
		boolean resul = false;
		if (pojo != null) {
			resul = lista.add(pojo);
		}
		return resul;
	}

	public boolean delete(int id) {
		Revista revista = getById(id);
		return lista.remove(revista);
	}

	public boolean update(Revista pojo) {
		boolean resul = false;
		if (pojo != null) {
			for (Revista revista : lista) {
				if (revista.getId() == pojo.getId()) {
					// modificar
					int pos = lista.indexOf(revista);
					lista.set(pos, pojo);
					resul = true;
					break;
				}
			}
		}
		return resul;
	}

	
	public ArrayList<Revista> listarRevistas(ArrayList<Revista> revistas) {
		System.out.println("Listado de Revistas");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("   ID           TITULO   ISBN   PAGINAS   DIGITAL");
		System.out.println("-----------------------------------------------------------------");
		
		Collections.sort(revistas);
		for (int i = 0; i < revistas.size(); i++) {

			System.out
					.println("   "+(i + 1) + "            "
							+ revistas.get(i).getTitulo() + "     " 
							+ revistas.get(i).getISBN() + "       " 
							+ revistas.get(i).getNumPags() + "       " 
							+ revistas.get(i).isFormato());

		} // end for
		return revistas;
	}
	

}
