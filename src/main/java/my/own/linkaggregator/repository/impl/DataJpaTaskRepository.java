package my.own.linkaggregator.repository.impl;

import my.own.linkaggregator.domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataJpaTaskRepository extends MongoRepository<Task, String> {

}
