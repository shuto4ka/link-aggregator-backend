package my.own.linkaggregator.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.repository.TaskRepository;
import my.own.linkaggregator.service.LinkService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final TaskRepository taskRepository;

    @Override
    public Link add(String taskId, Link link) {
        Assert.isNull(link.getId(), "Link id must be null");
        taskRepository.addLink(taskId, link);
        return link;
    }

    @Override
    public Link update(Link link) {
        Assert.notNull(link.getId(), "Link id must not be null");
        taskRepository.updateLink(link);
        return link;
    }

    @Override
    public void markAsDeleted(ObjectId linkId) {
        taskRepository.markLinkAsDeletedById(linkId);
    }
}