package my.own.linkaggregator.web.graphql.spqr;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.domain.Task;
import my.own.linkaggregator.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
public class LinkGraph {
    //TODO auth security

    private final LinkService linkService;

    @Autowired
    public LinkGraph(LinkService linkService) {
        this.linkService = linkService;
    }

    @GraphQLQuery(name = "link")
    public Link link(@GraphQLArgument(name = "id") Long id) {
        log.info("fetching link with id={}", id);
        return linkService.get(id);
    }

    @GraphQLMutation(name = "addLink")
    public Link addLink(@GraphQLArgument(name = "taskId") Long taskId,
                              @GraphQLArgument(name = "value") String value) {
        log.info("adding link to taskId={} with value={}", taskId, value);
        Link link = Link.builder()
                .value(value)
                .task(Task.builder().id(taskId).build())
                .build();
        return linkService.add(link);
    }

    @GraphQLMutation(name = "updateLink")
    public Link updateLink(@GraphQLArgument(name = "link") Link link) {
        log.info("updating link with id={}", link.getId());
        return linkService.update(link);
    }

    @GraphQLMutation(name = "deleteLink")
    public void deleteLink(@GraphQLArgument(name = "linkId") Long linkId) {
        log.info("deleting link with id={}", linkId);
        linkService.delete(linkId);
    }

}
