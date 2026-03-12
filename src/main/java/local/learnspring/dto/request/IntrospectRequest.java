package local.learnspring.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IntrospectRequest {
    String token;
}
