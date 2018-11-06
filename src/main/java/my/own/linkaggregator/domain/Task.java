package my.own.linkaggregator.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("tasks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    private String id;

    @Indexed
    private String userId;
    private String name;

    @Singular
    private List<Link> links;

    private boolean deleted;

}

