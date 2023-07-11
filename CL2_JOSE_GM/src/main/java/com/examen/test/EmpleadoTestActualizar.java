package com.examen.test;

import com.examen.dao.EmpleadoDao;
import com.examen.dao.impl.EmpleadoDaoImpl;
import com.examen.model.Empleado;

public class EmpleadoTestActualizar {

public static void main(String[] args) {
		// TODO Auto-generated method stub
EmpleadoDao dao = new EmpleadoDaoImpl();
Empleado empleado= dao.buscarEmpleado(3);
System.out.println(empleado);

empleado.setNombre("Thalia");
empleado.setDni("12121212");
String mensaje = dao.ActualizarEmpleado(empleado);
System.out.println(mensaje);
System.out.println(empleado);

	}

}
