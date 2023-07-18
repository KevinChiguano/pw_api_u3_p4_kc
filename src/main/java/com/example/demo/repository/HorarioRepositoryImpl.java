package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Horario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Horario seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public List<Horario> seleccionarTodos(String sala) {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery = this.entityManager.createQuery("SELECT h FROM Horario h WHERE h.sala =:datoSala", Horario.class);
		myQuery.setParameter("datoSala",sala);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(horario);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionarPorId(id));
	}

}
