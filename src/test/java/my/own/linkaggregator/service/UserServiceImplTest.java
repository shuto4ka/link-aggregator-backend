package my.own.linkaggregator.service;

import my.own.linkaggregator.AbstractIntegrationTest;
import my.own.linkaggregator.repository.UserRepository;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends AbstractIntegrationTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll().block();
    }

//    @Test
//    public void addUser() {
//        User newUser = User.builder().username("new-user").password("password").build();
//        newUser = userService.save(newUser);
//        assertThat(userRepository.findById(newUser.getId())).isPresent();
//    }
//
//    @Test
//    public void getUser() {
//        User newUser = User.builder().username("new-user").password("password").build();
//        newUser = userService.save(newUser);
//
//        assertThat(userService.get(newUser.getId())).isNotNull();
//    }
}