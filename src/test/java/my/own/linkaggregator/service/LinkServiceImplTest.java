package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Link;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static my.own.linkaggregator.TestData.TASK_1;
import static org.junit.Assert.assertEquals;

public class LinkServiceImplTest extends AbstactDbTest {

    @Autowired
    LinkService linkService;

    @Test
    public void addLink() {
        Link newLink = Link.builder().task(TASK_1).value("123").title("123").build();
        newLink = linkService.add(newLink);

        assertEquals(7L, newLink.getId().longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLinkWithNonNullId() {
        Link newLink = Link.builder().id(10L).build();
        linkService.add(newLink);
    }
}