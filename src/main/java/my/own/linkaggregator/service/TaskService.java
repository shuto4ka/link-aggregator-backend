package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Task;

public interface TaskService {

    Task save(Task task);

    Task get(String taskId);

    void delete(String taskId);
}
