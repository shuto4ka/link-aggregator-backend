package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.User;

public interface UserService {
    User save(User user);

    User get(String userId);
}
