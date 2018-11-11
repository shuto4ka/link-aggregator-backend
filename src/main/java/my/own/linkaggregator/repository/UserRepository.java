package my.own.linkaggregator.repository;

import my.own.linkaggregator.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
