package my.own.linkaggregator.repository.impl;

import my.own.linkaggregator.domain.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataJpaTaskRepository extends ReactiveMongoRepository<Task, String> {

}
