package com.example.demo.repository;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public Materia seleccionarPorCodigo(String codigo);
	
	public void insertar(Materia materia);
	
	public void actualizar(Materia materia);
	
	public void actualizarParcial(Integer id, String codigo);
	
	public void borrar(Integer id);
	
	public Materia seleccionarPorId(Integer id);

}
