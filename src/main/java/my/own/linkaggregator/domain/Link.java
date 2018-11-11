package my.own.linkaggregator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link {

    @Indexed
    private ObjectId id;

    private String value;
    private String title;
    private boolean done;

    private boolean deleted;
}
