package mx.com.dxesoft.lunchtime.repository;

import mx.com.dxesoft.lunchtime.domain.HorarioDeComida;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HorarioDeComidaRepository extends MongoRepository<HorarioDeComida, String> {
}
