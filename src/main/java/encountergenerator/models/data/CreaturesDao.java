package encountergenerator.models.data;

import encountergenerator.models.forms.Creatures;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface CreaturesDao extends CrudRepository<Creatures, Integer> {
}