package encountergenerator.services;

import encountergenerator.models.forms.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
