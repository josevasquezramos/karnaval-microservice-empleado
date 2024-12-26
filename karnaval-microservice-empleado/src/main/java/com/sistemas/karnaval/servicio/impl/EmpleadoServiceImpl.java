package com.sistemas.karnaval.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.karnaval.entidad.Empleado;
import com.sistemas.karnaval.repositorio.EmpleadoRepository;
import com.sistemas.karnaval.servicio.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public Empleado crear(Empleado entidad) {
		return empleadoRepository.save(entidad);
	}

	@Override
	public Empleado actualizar(Long id, Empleado entidad) {
		if (!empleadoRepository.existsById(id)) {
			throw new RuntimeException("Empleado no encontrado");
		}
		entidad.setId(id);
		return empleadoRepository.save(entidad);
	}

	@Override
	public void eliminar(Long id) {
		empleadoRepository.deleteById(id);
	}

	@Override
	public Empleado buscarPorId(Long id) {
		return empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
	}

	@Override
	public List<Empleado> listarTodos() {
		return empleadoRepository.findAll();
	}
}
