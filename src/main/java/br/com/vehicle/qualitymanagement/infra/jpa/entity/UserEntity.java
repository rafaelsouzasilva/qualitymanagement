package br.com.vehicle.qualitymanagement.infra.jpa.entity;

import br.com.vehicle.qualitymanagement.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter @Setter @AllArgsConstructor
public class UserEntity implements UserDetails {

    @Id
    private UUID id;
    private String email;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private ProfileEntity profile;

    public UserEntity() {
        this.id = UUID.randomUUID();
    }

    public UserEntity(String email, String password) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
    }

    public static UserEntity fromDomain(User user) {
        return new UserEntity(user.getEmail(), user.getPassword());
    }

    public List<ProfileEntity> getUserProfiles() {
        List<ProfileEntity> profiles = new ArrayList<ProfileEntity>();
        profiles.add(profile);
        return profiles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getUserProfiles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User toDomain() {
        return new User(id, email, password);
    }
}
