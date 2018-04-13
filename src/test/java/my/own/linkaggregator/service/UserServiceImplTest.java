package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static my.own.linkaggregator.TestData.USER_1;
import static org.junit.Assert.assertEquals;

public class UserServiceImplTest extends AbstactDbTest {
    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        User newUser = User.builder().username("new-user").password("password").build();
        newUser = userService.add(newUser);
        assertEquals(3L, newUser.getId().longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addUserWithNotNullId() {
        User newUser = User.builder().id(3L).username("new-user").password("password").build();
        userService.add(newUser);
    }

    @Test
    public void getUser() {
        User user = userService.get(USER_1.getId());
        assertEquals(USER_1, user);
    }
}