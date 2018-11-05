package my.own.linkaggregator.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.User;
import my.own.linkaggregator.repository.UserRepository;
import my.own.linkaggregator.service.UserService;
import my.own.linkaggregator.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(@NonNull User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(@NonNull String userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id=" + userId));
    }
}
