package my.own.linkaggregator.web.graphql.spqr;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.own.linkaggregator.AuthorizedUser;
import my.own.linkaggregator.domain.Task;
import my.own.linkaggregator.service.TaskService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskGraph {
    //TODO auth security

    private final TaskService taskService;

    @GraphQLQuery(name = "task")
    public Task task(@GraphQLArgument(name = "id") Long id) {
        log.info("fetching task with id={}", id);
        return taskService.get(id);
    }

    @GraphQLMutation(name = "addTask")
    public Task addTask() {
        log.info("adding task for userId={}", 1);
        Task task = Task.builder()
                .user(AuthorizedUser.user)
                .build();
        return taskService.add(task);
    }

    @GraphQLMutation(name = "updateTask")
    public Task updateTask(@GraphQLArgument(name = "task") Task task) {
        log.info("updating task with id={}", task.getId());
        return taskService.update(task);
    }

    @GraphQLMutation(name = "deleteTask")
    public void deleteTask(@GraphQLArgument(name = "taskId") Long taskId) {
        log.info("deleting task with id={}", taskId);
        taskService.delete(taskId);
    }
}


