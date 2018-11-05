package my.own.linkaggregator.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Task;
import my.own.linkaggregator.repository.TaskRepository;
import my.own.linkaggregator.service.TaskService;
import my.own.linkaggregator.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task save(@NonNull Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task get(@NonNull String taskId) {
        return taskRepository
                .findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found with id=" + taskId));
    }

    @Override
    public void delete(@NonNull String taskId) {
        taskRepository.deleteById(taskId);
    }
}
