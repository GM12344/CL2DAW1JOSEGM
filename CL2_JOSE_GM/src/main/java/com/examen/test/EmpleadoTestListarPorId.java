package com.examen.test;

import com.examen.dao.EmpleadoDao;
import com.examen.dao.impl.EmpleadoDaoImpl;
import com.examen.model.Empleado;

public class EmpleadoTestListarPorId {

	public static void main(String[] args) {
	
	EmpleadoDao dao = new EmpleadoDaoImpl();
	Empleado empleado = dao.buscarEmpleado(1);
	System.out.println(empleado);

	}

}
