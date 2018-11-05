package my.own.linkaggregator.repository;

import my.own.linkaggregator.domain.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    @Query(value = "{ 'links.id': ?0 }", fields = "{ 'links': 1 }")
    Optional<Task> findLinkById(ObjectId linkId);
}
