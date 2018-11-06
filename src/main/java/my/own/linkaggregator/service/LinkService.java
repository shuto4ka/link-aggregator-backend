package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Link;
import org.bson.types.ObjectId;

public interface LinkService {

    Link add(String taskId, Link link);
    Link update(Link link);

    void markAsDeleted(ObjectId linkId);
}
