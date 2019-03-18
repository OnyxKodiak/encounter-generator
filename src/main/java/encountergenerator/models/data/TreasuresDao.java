package encountergenerator.models.data;

import encountergenerator.models.forms.Treasures;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface TreasuresDao extends CrudRepository<Treasures, Integer> {
}