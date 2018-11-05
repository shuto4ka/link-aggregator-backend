package my.own.linkaggregator.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.repository.TaskRepository;
import my.own.linkaggregator.service.LinkService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final TaskRepository taskRepository;

    @Override
    public Link save(Link link) {
//        Assert.isNull(link.getId(), "Link Id must be null");
//        return linkRepository.save(link);
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(ObjectId linkId) {
//        linkRepository.deleteById(linkId);
        throw new UnsupportedOperationException();
    }
}