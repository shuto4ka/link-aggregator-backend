package my.own.linkaggregator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Table(name = "link")
@Access(AccessType.FIELD)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link implements Persistable<Long> {

    @Id
    @GenericGenerator(
            name = "link_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "link_id_seq"),
                    @Parameter(name = "increment_size", value = "30"),
                    @Parameter(name = "optimizer", value = "pooled-lo")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_generator")
    @Access(value = AccessType.PROPERTY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    private String value;
    private String title;
    private boolean done;

    @Override
    public boolean isNew() {
        return id == null;
    }
}
