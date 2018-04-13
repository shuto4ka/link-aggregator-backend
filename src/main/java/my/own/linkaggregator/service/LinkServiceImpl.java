package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link get(Long linkId) {
        return linkRepository.findById(linkId).orElse(null);
    }

    public Link add(Link link) {
        Assert.isNull(link.getId(), "Link Id must be null");
        return linkRepository.save(link);
    }

    @Override
    public Link update(Link link) {
        Assert.notNull(link.getId(), "Link Id must not be null");
        return linkRepository.save(link);
    }

    @Override
    public void delete(long linkId) {
        linkRepository.deleteById(linkId);
    }
}