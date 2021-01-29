package br.com.vehicle.qualitymanagement.infra.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "employee")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EmployeeEntity {

    @Id
    private UUID id;
    private String name;
    private Date birthdate;
    private String area;
    private boolean enabled;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

}
