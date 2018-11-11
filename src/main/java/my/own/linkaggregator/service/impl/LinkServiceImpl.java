package my.own.linkaggregator.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.repository.TaskRepository;
import my.own.linkaggregator.service.LinkService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final TaskRepository taskRepository;

    @Override
    public Mono<Link> add(@NonNull String taskId, @NonNull Link link) {
        Assert.isNull(link.getId(), "Link id must be null");
        return taskRepository.addLink(taskId, link);
    }

    @Override
    public Mono<Link> update(@NonNull Link link) {
        Assert.notNull(link.getId(), "Link id must not be null");
        return taskRepository.updateLink(link);
    }

    @Override
    public Mono<Void> markAsDeleted(@NonNull ObjectId linkId) {
        return taskRepository.markLinkAsDeletedById(linkId);
    }
}