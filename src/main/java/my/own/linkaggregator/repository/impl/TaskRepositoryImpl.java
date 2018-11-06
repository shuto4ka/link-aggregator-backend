package my.own.linkaggregator.repository.impl;

import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.domain.Task;
import my.own.linkaggregator.repository.TaskRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final MongoTemplate mongoTemplate;
    private final DataJpaTaskRepository dataJpaTaskRepository;

    @Override
    public void markLinkAsDeletedById(ObjectId linkId) {
        Query query = Query.query(Criteria.where("links")
                .elemMatch(Criteria.where("_id").is(linkId)));

        Update update = Update.update("links.$.deleted", true);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Task.class);
        log.info("Marked link as delete. {}", result.toString());
    }

    @Override
    public Task save(Task task) {
        return dataJpaTaskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(String id) {
        return dataJpaTaskRepository.findById(id);
    }

    @Override
    public void deleteById(String taskId) {
        dataJpaTaskRepository.deleteById(taskId);
    }

    @Override
    public void addLink(String taskId, Link link) {
        link.setId(ObjectId.get());
        Query query = Query.query(Criteria.where("_id").is(taskId));

        Update update = new Update().addToSet("links", link);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Task.class);
        log.info("Added link. {}", result.toString());
    }

    @Override
    public void updateLink(Link link) {
        Query query = Query.query(Criteria.where("links")
                .elemMatch(Criteria.where("_id").is(link.getId())));

        Update update = Update.update("links.$", link);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Task.class);
        log.info("Updated link. {}", result.toString());
    }
}
