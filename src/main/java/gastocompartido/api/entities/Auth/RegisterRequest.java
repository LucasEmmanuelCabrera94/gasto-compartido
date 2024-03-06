package gastocompartido.api.entities.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String userName;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String country;
}
