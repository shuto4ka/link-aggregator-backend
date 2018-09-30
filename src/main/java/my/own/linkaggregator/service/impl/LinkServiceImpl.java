package my.own.linkaggregator.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.repository.LinkRepository;
import my.own.linkaggregator.service.LinkService;
import my.own.linkaggregator.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    @Override
    @Transactional(readOnly = true)
    public Link get(Long linkId) {
        return linkRepository
                .findById(linkId)
                .orElseThrow(() -> new NotFoundException("Link not found with id=" + linkId));
    }

    @Override
    @Transactional
    public Link add(Link link) {
        Assert.isNull(link.getId(), "Link Id must be null");
        return linkRepository.save(link);
    }

    @Override
    @Transactional
    public void addAll(List<Link> links) {
        linkRepository.saveAll(links);
    }

    @Override
    @Transactional
    public Link update(Link link) {
        Assert.notNull(link.getId(), "Link Id must not be null");
        return linkRepository.save(link);
    }

    @Override
    @Transactional
    public void delete(long linkId) {
        linkRepository.deleteById(linkId);
    }
}