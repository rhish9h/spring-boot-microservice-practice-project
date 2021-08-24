package in.rhish.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserWithDepartment {
    private Long userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private Department department;
}
