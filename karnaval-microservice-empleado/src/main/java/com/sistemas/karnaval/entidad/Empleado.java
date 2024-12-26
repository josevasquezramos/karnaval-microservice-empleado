package com.sistemas.karnaval.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "empleados")
@Data
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // ID único del empleado

	@Column(nullable = false, length = 100)
	private String nombre; // Nombre del empleado

	@Column(nullable = false, length = 100)
	private String apellido; // Apellido del empleado

	@Column(nullable = false, unique = true, length = 8)
	private String dni; // DNI del empleado (Perú: 8 dígitos)

	@Column(nullable = false, length = 50)
	private String cargo; // Cargo del empleado

	@Column(nullable = false, length = 50)
	private String email; // Correo electrónico

	@Column(nullable = false, length = 15)
	private String telefono; // Teléfono de contacto

	@Column(nullable = false)
	private Boolean estado; // Estado del empleado (Activo/Inactivo)
}
