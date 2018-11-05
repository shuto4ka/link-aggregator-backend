package my.own.linkaggregator;

import my.own.linkaggregator.domain.User;

public class AuthorizedUser {
    public static final User user = new User();
    static {
        user.setId("1");
    }
}
