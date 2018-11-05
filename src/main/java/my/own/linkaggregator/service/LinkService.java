package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Link;
import org.bson.types.ObjectId;

public interface LinkService {

    Link save(Link link);

    void delete(ObjectId linkId);
}
