package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.User;
import my.own.linkaggregator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        Assert.isNull(user.getId(), "User Id must be null");
        return userRepository.save(user);
    }

    @Override
    public User get(long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
