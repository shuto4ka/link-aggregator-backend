package my.own.linkaggregator.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Task;
import my.own.linkaggregator.repository.TaskRepository;
import my.own.linkaggregator.service.TaskService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Mono<Task> save(@NonNull Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Mono<Task> get(@NonNull String taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public Mono<Void> delete(@NonNull String taskId) {
        return taskRepository.deleteById(taskId);
    }
}
