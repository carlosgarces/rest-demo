package mx.com.tsis.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tsis.rest.model.Empleado;
import mx.com.tsis.rest.service.EmpleadoService;
import mx.com.tsis.rest.util.HeaderUtil;

/**
 * REST controller for managing Empleado.
 */
@RestController
public class EmpleadoController {

	private final Logger log = LoggerFactory.getLogger(EmpleadoController.class);

	@Autowired
	private EmpleadoService empleadoService;

	/**
	 * POST /empleados -> Create a new empleado.
	 */
	@RequestMapping(value = "/empleado/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) throws URISyntaxException {
		log.debug("REST request to save Empleado : {}", empleado);
		if (empleado.getId() != null) {
			return ResponseEntity.badRequest().headers(
					HeaderUtil.createFailureAlert("empleado", "idexists", "A new empleado cannot already have an ID"))
					.body(null);
		}
		Empleado result = empleadoService.save(empleado);
		return ResponseEntity.created(new URI("/empleados/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert("empleado", result.getId().toString())).body(result);
	}

	/**
	 * PUT /empleados -> Updates an existing empleado.
	 */
	@RequestMapping(value = "/empleado/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empleado> updateEmpleado(@RequestBody Empleado empleado) throws URISyntaxException {
		log.debug("REST request to update Empleado : {}", empleado);
		if (empleado.getId() == null) {
			return createEmpleado(empleado);
		}
		Empleado result = empleadoService.save(empleado);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("empleado", empleado.getId().toString()))
				.body(result);
	}

	/**
	 * GET /empleados -> get all the empleados.
	 */
	@RequestMapping(value = "/empleado/", method = RequestMethod.GET)
	public ResponseEntity<List<Empleado>> getAllEmpleados() {
		List<Empleado> empleados = empleadoService.findAll();
		if(empleados.isEmpty()){
			new ResponseEntity<List<Empleado>>(HttpStatus.NO_CONTENT);
		}
		log.debug("REST request to get all Empleados where empresa is null");
		return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);

	}

	/**
	 * GET /empleados/:id -> get the "id" empleado.
	 */
	@RequestMapping(value = "/empleado/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empleado> getEmpleado(@PathVariable Long id) {
		log.debug("REST request to get Empleado : {}", id);
		Empleado empleado = empleadoService.findOne(id);
		return Optional.ofNullable(empleado).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * DELETE /empleados/:id -> delete the "id" empleado.
	 */
	@RequestMapping(value = "/empleado/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
		log.debug("REST request to delete Empleado : {}", id);
		empleadoService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("empleado", id.toString())).build();
	}
}
