package my.own.linkaggregator;

import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.domain.Task;
import my.own.linkaggregator.domain.User;

public class TestData {
    public static final User USER_1 = User.builder()
            .id(1L)
            .username("user1")
            .password("$2a$10$3tMf9I/1FlWNNWexNrmORuYOUrr/5Ir.cZtqojYbczmxltAttq4mG").build();

    public static final User USER_2 = User.builder()
            .id(2L)
            .username("user2")
            .password("$2a$10$3tMf9I/1FlWNNWexNrmORuYOUrr/5Ir.cZtqojYbczmxltAttq4mG").build();


    public static final Task TASK_1 = Task.builder().id(1L).user(USER_1).name("task 1").build();
    public static final Task TASK_2 = Task.builder().id(2L).user(USER_1).name("task 2").build();
    public static final Task TASK_3 = Task.builder().id(3L).user(USER_2).name("task 3").build();

    public static final Link LINK_1 = Link.builder().id(1L).task(TASK_1).value("https://1").title("link 1").done(false).build();
    public static final Link LINK_2 = Link.builder().id(2L).task(TASK_1).value("https://2").title("link 2").done(false).build();
    public static final Link LINK_3 = Link.builder().id(3L).task(TASK_1).value("https://3").title("link 3").done(true).build();
    public static final Link LINK_4 = Link.builder().id(4L).task(TASK_2).value("https://4").title("link 4").done(false).build();
    public static final Link LINK_5 = Link.builder().id(5L).task(TASK_2).value("https://5").title("link 5").done(true).build();
    public static final Link LINK_6 = Link.builder().id(6L).task(TASK_3).value("https://6").title("link 6").done(false).build();

}
