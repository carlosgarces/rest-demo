package mx.com.tsis.rest.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import mx.com.tsis.rest.model.Empleado;
import mx.com.tsis.rest.service.EmpleadoService;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	
	private static final AtomicLong counter = new AtomicLong();
	
	private static  List<Empleado> empleados;
	
	static{
		empleados= populateDummyUsers();
	}

	
	@Override
	public Empleado save(Empleado empleado) {
		empleado.setId(counter.incrementAndGet());
		empleados.add(empleado);
		return empleado;
	}

	@Override
	public List<Empleado> findAll() {
		return empleados;
	}

	@Override
	public Empleado findOne(Long id) {
		return empleados.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	@Override
	public void delete(Long id) {
		for (Iterator<Empleado> iterator = empleados.iterator(); iterator.hasNext(); ) {
			Empleado empleado = iterator.next();
		    if (empleado.getId() == id) {
		        iterator.remove();
		    }
		}
		
	}

	

	private static List<Empleado> populateDummyUsers(){
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(new Empleado(counter.incrementAndGet(),"uno", "uno", "uno", LocalDate.now(), BigDecimal.TEN));
		empleados.add(new Empleado(counter.incrementAndGet(),"Tomy", "uno", "uno", LocalDate.now(), BigDecimal.TEN));
		empleados.add(new Empleado(counter.incrementAndGet(),"Kelly", "uno", "uno", LocalDate.now(), BigDecimal.TEN));
		return empleados;
	}

}
