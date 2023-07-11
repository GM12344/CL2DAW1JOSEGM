package com.examen.dao;

import java.util.List;

import com.examen.model.Empleado;



public interface EmpleadoDao {

	public String registrarEmpleado(Empleado empleado);
	
	public Empleado buscarEmpleado(int id);
	
	public List<Empleado>listaEmpleados();
	
	public String ActualizarEmpleado(Empleado empleado);
	
	public String eliminarEmpleado(int id);
	
	
}
