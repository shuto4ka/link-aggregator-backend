package my.own.linkaggregator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link {

    private ObjectId id;

    private String value;
    private String title;
    private boolean done;

    private boolean deleted;
}
