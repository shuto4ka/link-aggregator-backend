package my.own.linkaggregator.service;

import my.own.linkaggregator.AbstractIntegrationTest;
import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.domain.Task;
import my.own.linkaggregator.repository.TaskRepository;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkServiceImplTest extends AbstractIntegrationTest {

    @Autowired
    private LinkService linkService;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void markAsDeleted() {
        Task task = saveTaskWith2Links();

        linkService.markAsDeleted(task.getLinks().get(0).getId()).block();

        task = taskRepository.findById(task.getId()).block();

        assertThat(task.getLinks().get(0).isDeleted()).isTrue();
        assertThat(task.getLinks().get(1).isDeleted()).isFalse();
    }

    @Test
    public void addLink() {
        Task task = saveTaskWith2Links();
        linkService.add(task.getId(), Link.builder().title("3").build()).block();

        task = taskRepository.findById(task.getId()).block();

        assertThat(task.getLinks()).hasSize(3);
    }

    @Test
    public void updateLink() {
        Task task = saveTaskWith2Links();
        task.getLinks().get(0).setTitle("update");
        linkService.update(task.getLinks().get(0)).block();

        Task updatedTask = taskRepository.findById(task.getId()).block();

        assertThat(task.getLinks()).isEqualTo(updatedTask.getLinks());
    }

    private Task saveTaskWith2Links() {
        Task task = taskRepository.save(Task.builder().build()).block();
        task.setLinks(List.of(
                Link.builder().id(ObjectId.get()).title("1").build(),
                Link.builder().id(ObjectId.get()).title("2").build()));
        taskRepository.addLink(task.getId(), task.getLinks().get(0)).block();
        taskRepository.addLink(task.getId(), task.getLinks().get(1)).block();

        return task;
    }
}