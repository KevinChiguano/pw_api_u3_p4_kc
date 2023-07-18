package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Horario;

public interface IHorarioRepository {
	
	public Horario seleccionarPorId(Integer id);
	public List<Horario> seleccionarTodos(String sala);
	public void insertar(Horario horario);
	public void actualizar(Horario horario);
	public void borrar(Integer id);

}
