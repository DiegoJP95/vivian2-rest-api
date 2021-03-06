package com.project.vivian.serviceImpl;
import com.project.vivian.dao.TurnosDAO;
import com.project.vivian.entidad.Turno;
import com.project.vivian.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("turnoService")
public class TurnoServicelmpl implements TurnoService {

    @Autowired
    private TurnosDAO turnoDAO;

	@Override
	public Integer agregarTurno(Turno turno) throws Exception {
        try {

        	String id = turnoDAO.obtenerUltimoId();
            return turnoDAO.saveTurno(id,turno.getDescripcion(),turno.getHorario());
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
	}

	@Override
	public List<Turno> listarTurnos() throws Exception {
        try {
            return turnoDAO.findAll();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
	}

	@Override
	public int actualizarTurno(Turno turno) throws Exception {
        try {
        	turnoDAO.save(turno);
            return 1;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
	}

	@Override
	public int eliminarTurno(int id) throws Exception {
        try {        	
            return turnoDAO.deleteWithId(id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
	}

   
}