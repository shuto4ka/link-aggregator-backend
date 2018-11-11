package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Link;
import org.bson.types.ObjectId;
import reactor.core.publisher.Mono;

public interface LinkService {

    Mono<Link> add(String taskId, Link link);
    Mono<Link> update(Link link);

    Mono<Void> markAsDeleted(ObjectId linkId);
}
