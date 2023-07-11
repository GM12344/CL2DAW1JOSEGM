package com.examen.test;

import com.examen.dao.EmpleadoDao;
import com.examen.dao.impl.EmpleadoDaoImpl;
import com.examen.model.Empleado;

public class EmpleadoTestRegistrar {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();

		Empleado empleado = new Empleado("Jose", "Miranda","47474715");

		String mensaje = dao.registrarEmpleado(empleado);

		System.out.println(mensaje);
	}

}
