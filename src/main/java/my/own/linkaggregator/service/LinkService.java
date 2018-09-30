package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Link;

import java.util.List;

public interface LinkService {

    Link add(Link link);

    Link get(Long linkId);

    void addAll(List<Link> links);

    Link update(Link link);

    void delete(long linkId);
}
