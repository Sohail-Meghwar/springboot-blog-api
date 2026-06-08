package blogapp.com.payloads;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    @NotEmpty
    @Size(min=5, message="Username must be at least 4 characters")
    private String name;
    @Email(message="Email address is not valid")
    private String email;
    @NotEmpty
    @Size(min=3, message="Password must be at least 8 characters")
    private String password;
    @NotEmpty
    private String about;

    private Set<RoleDto> roles=new HashSet<>();

    
}
