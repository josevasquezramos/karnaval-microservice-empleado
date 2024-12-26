package com.sistemas.karnaval.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemas.karnaval.entidad.Empleado;
import com.sistemas.karnaval.servicio.EmpleadoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	/**
	 * Endpoint para listar todos los empleados.
	 * 
	 * @return Lista de empleados.
	 */
	@GetMapping
	public ResponseEntity<List<Empleado>> listarEmpleados() {
		return ResponseEntity.ok(empleadoService.listarTodos());
	}

	/**
	 * Endpoint para obtener un empleado por su ID.
	 * 
	 * @param id ID del empleado.
	 * @return Detalles del empleado.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
		return ResponseEntity.ok(empleadoService.buscarPorId(id));
	}

	/**
	 * Endpoint para crear un nuevo empleado.
	 * 
	 * @param empleado Datos del empleado.
	 * @return Empleado creado.
	 */
	@PostMapping
	public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
		return ResponseEntity.ok(empleadoService.crear(empleado));
	}

	/**
	 * Endpoint para actualizar un empleado existente.
	 * 
	 * @param id       ID del empleado a actualizar.
	 * @param empleado Datos del empleado a actualizar.
	 * @return Empleado actualizado.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
		return ResponseEntity.ok(empleadoService.actualizar(id, empleado));
	}

	/**
	 * Endpoint para eliminar un empleado.
	 * 
	 * @param id ID del empleado a eliminar.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
		empleadoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
