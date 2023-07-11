package com.examen.test;

import com.examen.dao.EmpleadoDao;
import com.examen.dao.impl.EmpleadoDaoImpl;

public class EmpleadoTestListar {

	public static void main(String[] args) {
  EmpleadoDao dao = new EmpleadoDaoImpl();
  dao.listaEmpleados().stream().forEach(System.out::println);	
	}

}
