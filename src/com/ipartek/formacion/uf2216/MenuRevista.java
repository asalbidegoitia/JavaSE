package com.ipartek.formacion.uf2216;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;





public class MenuRevista {
	static final int OPCION_CREAR=1;
	static final int OPCION_LISTAR=2;
	static final int OPCION_TXT=3;
	static final int OPCION_SALIR=4;
	static final String OPCION_SI="Si";
	static final String OPCION_NO="No";
	public final static int LONGITUD_MAX_TITULO = 150;
	public final static int LONGITUD_MIN_TITULO = 3;
	public static final int LONGITUD_ISBN = 10;
	static Scanner sc;
	static DAORevistas dao;
	static ArrayList<Revista> revistas;
	static boolean crear;
	
	static int id;
	static String titulo;
	static int iSBN;
	static int numPags;
	static boolean formato;
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		dao = DAORevistas.getInstance();
		sc = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("\nSelecciona una opción: ");
			System.out.println("1- Crear Revista");
			System.out.println("2- Listar Revistas");
			System.out.println("3- Guardar en fichero .TXT");
			System.out.println("4- Salir de la aplicación");
			
			try {
				opcion = Integer.parseInt(sc.nextLine().trim());			
			} catch (Exception e) {
				 e.printStackTrace();
				System.out.println("Mensaje excepcion " + e.getMessage());
				System.out.println("Ha introducido datos sin el formato indicado");	
			}
			switch (opcion) {
			case OPCION_CREAR:				
				crearRevista();
				break;
			case OPCION_LISTAR:	
				System.out.println("Se listaran las revistas: ");
				revistas =(ArrayList<Revista>) dao.getAll();
				dao.listarRevistas(revistas);
				break;
			case OPCION_TXT:				
				guardarFicheroTXT();
				break;	
			default:
			    System.out.println("Ha introducido datos sin el formato indicado o la opción no es valida");
			    break;
			}
		}while(opcion!=OPCION_SALIR);
		
		System.out.println("Se acaba la ejecución");
		sc.close();		
	}


	/**
	 * 
	 * @throws Exception
	 */
	private static void crearRevista() throws Exception {
		crear=false;
		int longitud=0;
		do {
			System.out.println("Introduce el titulo de la revista: ");
			titulo = sc.nextLine();	
		}while("".equals(titulo)|| titulo.length() <= LONGITUD_MIN_TITULO || titulo.length() >= LONGITUD_MAX_TITULO);
		
		do {
			System.out.println("Introduce el ISBN de la revista (debe ser un número de longitud 10): ");
			iSBN = Integer.parseInt(sc.nextLine().trim());
			longitud = String.valueOf(iSBN).length();
		}while(iSBN ==0 || longitud!=LONGITUD_ISBN);
		
		do {
			System.out.println("Introduce el número de páginas de la revista: ");
			numPags = Integer.parseInt(sc.nextLine().trim());
		}while(numPags ==0);
		
		do {
			System.out.println("¿Está la revista en formato digital? (true o false): ");
			//formato = sc.hasNextBoolean();
			formato=Boolean.parseBoolean(sc.nextLine());
		}while("".equals(formato));
		
		System.out.println("Se va a proceder a generar una revista con los siguientes datos: ");
		System.out.println( "Titulo: "+titulo + ", ISBN: "+ iSBN + ", Páginas: "+ numPags + ", Digital: "+ formato);
		System.out.println("¿Confirma que quiere crear esta revista? (true o false): ");
		crear=Boolean.parseBoolean(sc.nextLine());
		if(crear) {
			Revista revista = new Revista(id, titulo, iSBN, numPags, formato);
			revista.setId(dao.getAll().size()+1);
			dao.insert(revista);	
		}
	}

	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static void guardarFicheroTXT() throws FileNotFoundException, IOException, ClassNotFoundException {
		//String ficheroRevistas =  "C:\\1713\\eclipse-workspace\\AsierSalbidegoitiaLeon\\revistas.txt";
		String ficheroRevistas = "c:/Users/curso/Desktop/revistas.txt";
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ficheroRevistas);
            pw = new PrintWriter(ficheroRevistas);
            for (int i = 1; i < dao.getAll().size()+1; i++)
            	pw.println(dao.getById(i).toString());
            	pw.flush(); 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              //e2.printStackTrace();
        	  System.out.println("Mensaje excepcion " + e2.getMessage());
			  System.out.println("No se ha generado el fichero de texto");	
           }
        }
        fichero.close();
        pw.close();
        System.out.println("Se ha generado el fichero de texto en "+ ficheroRevistas);	
		
	}
}
