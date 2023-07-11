package com.examen.test;

import com.examen.dao.EmpleadoDao;
import com.examen.dao.impl.EmpleadoDaoImpl;

public class EmpleadoTestEliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    EmpleadoDao dao = new EmpleadoDaoImpl();
    String mensaje = dao.eliminarEmpleado(6);
    System.out.println(mensaje);
	}

}
