package mx.com.tsis.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tsis.rest.model.Empleado;
import mx.com.tsis.rest.respository.EmpleadoRepository;
import mx.com.tsis.rest.service.EmpleadoService;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	
//	private static final AtomicLong counter = new AtomicLong();
	
	@Autowired
	EmpleadoRepository empleadoRepository;
//	private static  List<Empleado> empleados;
	
//	static{
//		empleados= populateDummyUsers();
//	}

	
	@Override
	public Empleado save(Empleado empleado) {
		empleadoRepository.saveAndFlush(empleado);
//		empleado.setId(counter.incrementAndGet());
//		empleados.add(empleado);
		return empleado;
	}

	@Override
	public List<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado findOne(Long id) {
		return empleadoRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		empleadoRepository.delete(id);
	}

	

//	private static List<Empleado> populateDummyUsers(){
//		List<Empleado> empleados = new ArrayList<Empleado>();
//		empleados.add(new Empleado(counter.incrementAndGet(),"uno", "uno", "uno", new Date(), BigDecimal.TEN));
//		empleados.add(new Empleado(counter.incrementAndGet(),"Tomy", "uno", "uno", new Date(), BigDecimal.TEN));
//		empleados.add(new Empleado(counter.incrementAndGet(),"Kelly", "uno", "uno", new Date(), BigDecimal.TEN));
//		return empleados;
//	}

}
