package my.own.linkaggregator.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.domain.Task;
import my.own.linkaggregator.repository.TaskRepository;
import my.own.linkaggregator.service.TaskService;
import my.own.linkaggregator.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public Task add(Task task) {
        Assert.isNull(task.getId(), "Task Id must be null");
        return taskRepository.save(task);
    }

    @Override
    @Transactional(readOnly = true)
    public Task get(Long taskId) {
        return taskRepository
                .findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found with id=" + taskId));
    }

    @Override
    @Transactional
    public Task update(Task task) {
        Assert.notNull(task.getId(), "Task Id must not be null");
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public void delete(long taskId) {
        taskRepository.deleteById(taskId);
    }
}
