package my.own.linkaggregator.web.graphql.spqr;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.User;
import my.own.linkaggregator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserGraph {

    private final UserService userService;

    @Autowired
    public UserGraph(UserService userService) {
        this.userService = userService;
    }

    @GraphQLQuery(name = "user")
    public User user(@GraphQLArgument(name = "id") Long id) {
        log.info("fetching user with id={}", id);
        return userService.get(id);
    }

//    @GraphQLMutation(name = "addLinkToTask")
//    public Link addLinkToTask(@GraphQLArgument(name = "taskId") Long taskId,
//                              @GraphQLArgument(name = "value") String value) {
//        log.info("adding link to taskId={} with value={}", taskId, value);
//        return userService.add(taskId, value);
//    }
}
