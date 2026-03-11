package local.learnspring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "uncategorized error"),
    INVALID_KEY(1001, "Invalid message key"),
    USER_NOT_EXISTED(1002, "User is not exist"),
    USERNAME_INVALID(1003, "username must be at least 3 characters"),
    PASSWORD_INVALID(1004, "password must be at least 8 to 12 characters"),
    USER_EXISTED(1005, "User already existed"),
    ;

    private int code;
    private String message;
}
