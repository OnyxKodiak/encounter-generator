package encountergenerator.models.data;

import encountergenerator.models.forms.Encounter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface EncountersDao extends CrudRepository<Encounter, Integer> {
}