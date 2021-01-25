package br.com.vehicle.qualitymanagement.infra.jpa.entity;

import br.com.vehicle.qualitymanagement.domain.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profile")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProfileEntity implements GrantedAuthority {

    @Id
    private UUID id;
    private String name;

    @ManyToMany(mappedBy = "userProfiles")
    private List<UserEntity> users;

    @Override
    public String getAuthority() {
        return this.getName();
    }

    public Profile toDomain() {
        return new Profile();
    }
}
