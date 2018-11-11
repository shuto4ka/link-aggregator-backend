package my.own.linkaggregator.repository.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.domain.Task;
import my.own.linkaggregator.repository.TaskRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final ReactiveMongoTemplate mongoTemplate;
    private final DataJpaTaskRepository dataJpaTaskRepository;

    @Override
    public Mono<Void> markLinkAsDeletedById(ObjectId linkId) {
        Query query = Query.query(Criteria.where("links")
                .elemMatch(Criteria.where("_id").is(linkId)));

        Update update = Update.update("links.$.deleted", true);

        return mongoTemplate.updateFirst(query, update, Task.class)
                .doOnNext(updateResult -> log.info("Marked link as delete with id={}. {}", linkId, updateResult.toString()))
                .then();
    }

    @Override
    public Mono<Task> save(Task task) {
        return dataJpaTaskRepository.save(task);
    }

    @Override
    public Mono<Task> findById(String id) {
        return dataJpaTaskRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(String taskId) {
        return dataJpaTaskRepository.deleteById(taskId);
    }

    @Override
    public Mono<Link> addLink(String taskId, Link link) {
        link.setId(ObjectId.get());
        Query query = Query.query(Criteria.where("_id").is(taskId));

        Update update = new Update().addToSet("links", link);

        return mongoTemplate.updateFirst(query, update, Task.class)
                .doOnNext(updateResult -> log.info("Added link with id={}. {}", link.getId(), updateResult.toString()))
                .thenReturn(link);
    }

    @Override
    public Mono<Link> updateLink(Link link) {
        Query query = Query.query(Criteria.where("links")
                .elemMatch(Criteria.where("_id").is(link.getId())));

        Update update = Update.update("links.$", link);

        return mongoTemplate.updateFirst(query, update, Task.class)
                .doOnNext(updateResult -> log.info("Updated link with id=. {}", link.getId(), updateResult.toString()))
                .thenReturn(link);
    }
}
