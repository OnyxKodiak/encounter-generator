package encountergenerator.models.data;

import encountergenerator.models.forms.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
    User findByName(String name);
}
