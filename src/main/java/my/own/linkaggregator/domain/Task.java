package my.own.linkaggregator.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "task")
@Access(AccessType.FIELD)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @SequenceGenerator(name = "task_id_seq", sequenceName = "task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @Access(value = AccessType.PROPERTY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Singular
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task", cascade = CascadeType.REMOVE)
    @OrderBy("id")
    private List<Link> links;

}

