package my.own.linkaggregator.repository;

import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.domain.Task;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TaskRepository {

    Mono<Void> markLinkAsDeletedById(ObjectId linkId);

    Mono<Task> save(Task task);

    Mono<Task> findById(String id);

    Mono<Void> deleteById(String taskId);

    Mono<Link> addLink(String taskId, Link link);

    Mono<Link> updateLink(Link link);
}
