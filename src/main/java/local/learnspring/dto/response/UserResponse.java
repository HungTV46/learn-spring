package local.learnspring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
