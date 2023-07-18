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

import com.example.demo.repository.modelo.Horario;
import com.example.demo.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestFul {
	
	@Autowired
	private IHorarioService horarioService;
	
	@GetMapping(path = "/{id}")
	public Horario consultarPorId(@PathVariable Integer id) {
		return this.horarioService.buscarPorId(id);
	}
	
	@PostMapping
	public void guardar(@RequestBody Horario horario) {
		this.horarioService.guardar(horario);
	}
	
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Horario horario ,@PathVariable Integer identificador) {
		horario.setId(identificador);
		this.horarioService.actualizar(horario);
		
	}
	
	@PatchMapping(path = "{identificador}/{sala}")
	public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer identificador, @PathVariable String sala) {
		horario.setId(identificador);
		Horario hora1 = this.horarioService.buscarPorId(identificador);
		hora1.setSala(sala);
		this.horarioService.actualizar(horario);
		
	}
	
	@DeleteMapping(path = "{identificador}")
	public void borrar(@PathVariable Integer identificador) {
		this.horarioService.eliminar(identificador);
	}

}
