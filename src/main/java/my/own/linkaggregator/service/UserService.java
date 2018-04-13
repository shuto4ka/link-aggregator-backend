package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.User;

public interface UserService {
    User add(User user);

    User get(long userId);
}
