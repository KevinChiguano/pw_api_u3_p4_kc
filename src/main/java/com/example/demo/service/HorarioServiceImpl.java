package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHorarioRepository;
import com.example.demo.repository.modelo.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService{
	
	@Autowired
	private IHorarioRepository horarioRepository;

	@Override
	public Horario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.horarioRepository.seleccionarPorId(id);
	}

	@Override
	public List<Horario> buscarTodos(String sala) {
		// TODO Auto-generated method stub
		return this.horarioRepository.seleccionarTodos(sala);
	}

	@Override
	public void guardar(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.insertar(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.actualizar(horario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.horarioRepository.borrar(id);
	}

}
