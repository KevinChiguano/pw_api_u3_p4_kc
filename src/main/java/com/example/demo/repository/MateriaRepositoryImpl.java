package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{

	@PersistenceContext
	private EntityManager entityManeger;
	
	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entityManeger.createQuery("SELECT m FROM Materia m WHERE m.codigo =: datoCodigo",Materia.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManeger.persist(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManeger.merge(materia);
		
	}

	@Override
	public void actualizarParcial(Integer id, String codigo) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManeger.createQuery("UPDATE Materia m SET m.codigo=:datoCodigo WHERE e.id=:datoCondicion");
		myQuery.setParameter("datoCodigo", codigo);
		myQuery.setParameter("datoCondicion", id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManeger.remove(this.seleccionarPorId(id));
	}

	@Override
	public Materia seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManeger.find(Materia.class, id);
	}

}
