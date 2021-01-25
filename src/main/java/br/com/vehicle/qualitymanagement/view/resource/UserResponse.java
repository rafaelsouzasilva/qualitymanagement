package br.com.vehicle.qualitymanagement.view.resource;

import br.com.vehicle.qualitymanagement.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserResponse {
    private UUID id;
    private String email;

    public static UserResponse fromDomain(User user) {
        return new UserResponse(user.getId(), user.getEmail());
    }
}
