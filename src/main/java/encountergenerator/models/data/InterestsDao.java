package encountergenerator.models.data;

import encountergenerator.models.forms.Interests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface InterestsDao extends CrudRepository<Interests, Integer>{

}
