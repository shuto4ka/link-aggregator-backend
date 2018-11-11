package my.own.linkaggregator.service;

import my.own.linkaggregator.domain.Task;
import reactor.core.publisher.Mono;

public interface TaskService {

    Mono<Task> save(Task task);

    Mono<Task> get(String taskId);

    Mono<Void> delete(String taskId);
}
