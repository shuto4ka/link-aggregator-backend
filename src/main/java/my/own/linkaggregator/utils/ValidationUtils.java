package my.own.linkaggregator.utils;

import my.own.linkaggregator.domain.User;
import my.own.linkaggregator.utils.exception.AccessDeniedException;
import org.springframework.util.Assert;

public class ValidationUtils {

    public static void checkUserPermission(User actual, User expected) {
        Assert.notNull(actual, "Actual user must not be null");
        Assert.notNull(expected, "Excepted user must not be null");
        if (!expected.getId().equals(actual.getId())) {
            throw new AccessDeniedException(String.format("Access denied for userId=%d to resource of userId=%d",
                    actual.getId(), expected.getId()));
        }
    }
}
