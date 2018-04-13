package my.own.linkaggregator.to;

import lombok.Data;

import java.util.List;

@Data
public class TaskTO {
    private final Long id;
    private final long userId;
    private final String name;
    private final List<LinkTO> links;
}
