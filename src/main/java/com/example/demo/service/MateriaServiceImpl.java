package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public Materia consultarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarPorCodigo(codigo);
	}

	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.actualizar(materia);
	}

	@Override
	public void actualizarParcial(Integer id, String codigo) {
		// TODO Auto-generated method stub
		this.materiaRepository.actualizarParcial(id, codigo);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.materiaRepository.borrar(id);
	}

	@Override
	public Materia consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarPorId(id);
	}

}
