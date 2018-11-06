package my.own.linkaggregator.repository;

import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.domain.Task;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository {

    void markLinkAsDeletedById(ObjectId linkId);

    Task save(Task task);

    Optional<Task> findById(String id);

    void deleteById(String taskId);

    void addLink(String taskId, Link link);

    void updateLink(Link link);
}
