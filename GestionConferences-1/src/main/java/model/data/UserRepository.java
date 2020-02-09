package model.data;

import model.User;

public interface UserRepository {
	User findByUsername(String username);

	void save(User user);

	Iterable<User> findSimpleAdmin();
}
