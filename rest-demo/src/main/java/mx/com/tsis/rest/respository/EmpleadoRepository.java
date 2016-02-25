package mx.com.tsis.rest.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.tsis.rest.model.Empleado;

/**
 * Spring Data JPA repository for the Empleado entity.
 */
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

}
