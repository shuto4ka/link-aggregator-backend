package my.own.linkaggregator.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.User;
import my.own.linkaggregator.repository.UserRepository;
import my.own.linkaggregator.service.UserService;
import my.own.linkaggregator.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User add(User user) {
        Assert.isNull(user.getId(), "User Id must be null");
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User get(long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id=" + userId));
    }
}
