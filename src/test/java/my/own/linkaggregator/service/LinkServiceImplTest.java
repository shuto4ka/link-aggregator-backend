//package my.own.linkaggregator.service;
//
//import my.own.linkaggregator.AbstractIntegrationTest;
//import my.own.linkaggregator.domain.Link;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//import static my.own.linkaggregator.TestData.TASK_1;
//import static org.junit.Assert.assertEquals;
//
//public class LinkServiceImplTest extends AbstractIntegrationTest {
//
//    @Autowired
//    private LinkService linkService;
//
//    @Test
//    public void addLink() {
//        Link newLink = Link.builder().task(TASK_1).value("123").title("123").build();
//        newLink = linkService.save(newLink);
//
//        assertEquals(7L, newLink.getId().longValue());
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void addLinkWithNonNullId() {
//        Link newLink = Link.builder().id(10L).build();
//        linkService.save(newLink);
//    }
//
//    @Test
//    public void saveAll() {
//        Link newLink1 = Link.builder().task(TASK_1).value("123").title("123").build();
//        Link newLink2 = Link.builder().task(TASK_1).value("12").title("12").build();
//        Link newLink3 = Link.builder().task(TASK_1).value("1").title("12").build();
//        linkService.saveAll(List.of(newLink1, newLink2, newLink3));
//    }
//}