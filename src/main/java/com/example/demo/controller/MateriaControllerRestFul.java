package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {
	
	@Autowired
	private IMateriaService materiaService;
	
	//GET
	@GetMapping(path = "/{codigo}")
	public Materia consultarPorCodigo(@PathVariable String codigo) {
		return this.materiaService.consultarPorCodigo(codigo);
	}
	
	//Post
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.materiaService.guardar(materia);
	}
	
	@PutMapping(path = "/actualizar/{identificador}")
	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador) {
		materia.setId(identificador);
		this.materiaService.actualizar(materia);
		
	}
	
	@PatchMapping(path = "/actualizarParcial/{id}/{codigo}")
	public void actualizarParcial(@RequestBody Materia materia ,@PathVariable Integer id, @PathVariable String codigo){
		materia.setId(id);
		Materia mat1 = this.materiaService.consultarPorId(id);
		mat1.setCodigo(codigo);
		this.materiaService.actualizar(mat1);
	}

	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.materiaService.eliminar(id);
	}
}
