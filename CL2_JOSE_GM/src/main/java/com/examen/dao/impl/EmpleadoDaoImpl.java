package com.examen.dao.impl;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.examen.dao.EmpleadoDao;
import com.examen.model.Empleado;



public class EmpleadoDaoImpl implements EmpleadoDao {
	
	// variable staticas final 
			public  static  final String  REGISTRO_OK ="Se registro correctamente al empleado.";
			
			public  static  final String  REGISTRO_ERROR ="No Se registro correctamente al empleado.";
			
		    public  static  final String  ACTUALIZA_OK ="Se actualizo correctamente al empleado.";
			
			public  static  final String  ACTUALIZA_ERROR ="No Se actualizo correctamente al empleado.";
			
		    public  static  final String  ELIMINA_OK ="Se elimino correctamente al empleado.";
			
			public  static  final String  ELIMINA_ERROR ="No Se elimino correctamente al empleado.";

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpleadoPU");
		EntityManager manager = factory.createEntityManager();

		
		
	@Override
	public String registrarEmpleado(Empleado empleado) {
         String mensaje = REGISTRO_ERROR;
		 
		 if(!Objects.isNull(empleado) ) {//if (!empleado es diferente de null)
			 manager.getTransaction().begin();// iniciamos transaccion
				manager.persist(empleado);
				manager.getTransaction().commit();// confirmamos registro
				mensaje= REGISTRO_OK;
				manager.close();
			
			 
		 }
		return mensaje;
	}
	

	@Override
	public Empleado buscarEmpleado(int id) {
		  return  manager.find(Empleado.class,id);
			 
		 }
			
	public Empleado buscarEmpleadoId(int id) {
			
	return buscarEmpleado(id);
	}

	@Override
	public List<Empleado> listaEmpleados() {
		
	CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();// construye criterio para las consultas
	CriteriaQuery<Empleado>criteriaQuery = criteriaBuilder.createQuery(Empleado.class);//creamos la consulta indicando  la clase de referencia
	Root<Empleado>registro= criteriaQuery.from(Empleado.class);//obtiene datos de la consulta con la clase  especifica	
	CriteriaQuery<Empleado>todos= criteriaQuery.select(registro);// se obtiene la seleccion  de registros de la bd
	TypedQuery<Empleado>lista= manager.createQuery(todos);//prepara consulta para la ejecucion
	return lista.getResultList();//retorna la lista  de elementos
			}

	@Override
	public String ActualizarEmpleado(Empleado empleado) {
    String mensaje = ACTUALIZA_ERROR;
		 
		 Empleado objeto= buscarEmpleadoId(empleado.getId());
		 
		 if(!Objects.isNull(objeto)) {//if (!empleado es diferente de null)
				manager.getTransaction().begin();// iniciamos transaccion
				
				
				objeto.setNombre(empleado.getNombre());
				objeto.setApellidos(empleado.getApellidos());
				objeto.setDni(empleado.getDni());
			
				manager.getTransaction().commit();
				manager.close();
				mensaje= ACTUALIZA_OK;
		 }
		
	      
		return mensaje;
	}
	@Override
	public String eliminarEmpleado(int id) {
		String mensaje = ELIMINA_ERROR;
		 
		Empleado objeto=buscarEmpleado(id);
		 
		 if(!Objects.isNull(objeto)) {//if (!empleado es diferente de null)
				manager.getTransaction().begin();// iniciamos transaccion
				manager.remove(objeto);
				manager.getTransaction().commit();
				manager.close();
				mensaje= ELIMINA_OK;
		 }
		
	      
		return mensaje;
	}

	}


