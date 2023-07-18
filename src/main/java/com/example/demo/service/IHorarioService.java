package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Horario;

public interface IHorarioService {
	
	public Horario buscarPorId(Integer id);
	public List<Horario> buscarTodos(String sala);
	public void guardar(Horario horario);
	public void actualizar(Horario horario);
	public void eliminar(Integer id);

}
