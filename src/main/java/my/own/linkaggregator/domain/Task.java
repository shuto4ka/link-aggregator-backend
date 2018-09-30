package my.own.linkaggregator.domain;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
    @GenericGenerator(
            name = "task_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "task_id_seq"),
                    @Parameter(name = "increment_size", value = "30"),
                    @Parameter(name = "optimizer", value = "pooled-lo")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_generator")
    @Access(value = AccessType.PROPERTY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @NotNull
    private User user;

    private String name;

    @Singular
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
    @OrderBy("id")
    @BatchSize(size = 100)
    private List<Link> links;

}

