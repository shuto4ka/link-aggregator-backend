package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> save(User user);

    Mono<User> get(String userId);
}
