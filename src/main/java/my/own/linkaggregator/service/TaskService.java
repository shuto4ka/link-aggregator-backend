package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Task;

public interface TaskService {

    Task add(Task task);

    Task get(Long taskId);

    Task update(Task task);

    void delete(long taskId);
}
