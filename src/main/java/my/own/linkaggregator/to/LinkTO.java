package my.own.linkaggregator.to;

import lombok.Data;

@Data
public class LinkTO {
    private final Long id;
    private final long taskId;
    private final String value;
    private final String title;
    private final boolean done;
}
