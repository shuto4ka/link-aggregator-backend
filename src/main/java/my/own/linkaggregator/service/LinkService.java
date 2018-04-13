package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Link;

public interface LinkService {

    Link add(Link link);

    Link get(Long linkId);

    Link update(Link link);

    void delete(long linkId);
}
