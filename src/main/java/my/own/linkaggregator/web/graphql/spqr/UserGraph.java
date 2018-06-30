package my.own.linkaggregator.web.graphql.spqr;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.User;
import my.own.linkaggregator.service.UserService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserGraph {

    private final UserService userService;

    @GraphQLQuery(name = "user")
    public User user(@GraphQLArgument(name = "id") Long id) {
        log.info("fetching user with id={}", id);
        return userService.get(id);
    }
}
