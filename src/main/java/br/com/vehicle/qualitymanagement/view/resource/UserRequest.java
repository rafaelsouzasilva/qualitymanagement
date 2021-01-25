package br.com.vehicle.qualitymanagement.view.resource;

import br.com.vehicle.qualitymanagement.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserRequest {
    private String email;
    private String password;

    public User toDomain() {
        return new User(email, password);
    }
}
