package mx.com.dxesoft.lunchtime.service;

import com.google.common.base.Preconditions;
import mx.com.dxesoft.lunchtime.domain.HorarioDeComida;
import mx.com.dxesoft.lunchtime.repository.HorarioDeComidaRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioDeComidaService {

    private final Logger log = LoggerFactory.getLogger(HorarioDeComidaService.class);

    private final HorarioDeComidaRepository horarioDeComidaRepository;

    @Autowired
    public HorarioDeComidaService(HorarioDeComidaRepository horarioDeComidaRepository) {
        this.horarioDeComidaRepository = horarioDeComidaRepository;
    }

    /**
     * Finds all horarios de comidas.
     *
     * @return a list of Horarios de comida.
     */
    public List<HorarioDeComida> findAll() {
        log.debug("Request to get all the horarios de comida");

        return horarioDeComidaRepository.findAll();
    }

    /**
     * Saves a new 'Horario de comida'.
     *
     * @param horarioDeComida 'horario de comida' to save.
     * @return the saved 'Horario de comida'.
     */
    public HorarioDeComida save(HorarioDeComida horarioDeComida) {
        log.debug("Request to save 'horario de comida'.");
        Preconditions.checkNotNull(horarioDeComida, "horarioDeComida can not be null");

        return this.horarioDeComidaRepository.insert(horarioDeComida);
    }

    /**
     * Updates an 'horario de comida'.
     *
     * @param horarioDeComida 'horario de comida' to be updated.
     * @return the updated 'Horario de comida'.
     */
    public HorarioDeComida update(HorarioDeComida horarioDeComida) {
        log.debug("Request to update an existing 'Horario de comida'");
        Preconditions.checkNotNull(horarioDeComida, "Horario de comida can not be null");

        return this.horarioDeComidaRepository.save(horarioDeComida);
    }

    /**
     * Deletes an 'horario de comida'.
     *
     * @param id 'horario de comida' identifier.
     */
    public void delete(String id) {
        log.debug("Request to delete an 'Horario de comida'");
        Preconditions.checkArgument(StringUtils.isEmpty(id), "Id can not be null or empty");

        this.horarioDeComidaRepository.deleteById(id);
    }

    public Optional<HorarioDeComida> findById(String id) {
        return this.horarioDeComidaRepository.findById(id);
    }
}
