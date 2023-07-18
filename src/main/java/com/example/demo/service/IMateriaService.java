package com.example.demo.service;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {
	
	public Materia consultarPorCodigo(String codigo);
	public void guardar(Materia materia);
	public void actualizar(Materia materia);
	public void actualizarParcial(Integer id, String codigo);
	public void eliminar(Integer id);
	public Materia consultarPorId(Integer id);

}
