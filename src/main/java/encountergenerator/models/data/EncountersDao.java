package encountergenerator.models.data;

import encountergenerator.models.forms.Encounters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface EncountersDao extends CrudRepository<Encounters, Integer> {
}