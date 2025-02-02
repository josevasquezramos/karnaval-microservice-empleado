package com.sistemas.karnaval.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.karnaval.entidad.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}