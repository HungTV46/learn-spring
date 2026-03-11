package local.learnspring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
