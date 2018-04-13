package my.own.linkaggregator.utils;

import my.own.linkaggregator.domain.Link;
import my.own.linkaggregator.to.LinkTO;

public class TOUtils {
    public static LinkTO createFromEntity(Link link) {
        return new LinkTO(link.getId(), link.getTask().getId(), link.getValue(), link.getTitle(), link.isDone());
    }

//    public static TaskTO createFromEntity(Task task) {
//
//        return new LinkTO(link.getId(), link.getTask().getId(), link.getValue(), link.getTitle(), link.isDone());
//    }
}
