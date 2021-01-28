package br.com.vehicle.qualitymanagement.infra.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "process")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProcessEntity {

    @Id
    private UUID id;
    private String name;
    private String description;
    private String tasks;
    private boolean enabled;

}
