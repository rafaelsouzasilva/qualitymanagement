package br.com.vehicle.qualitymanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Process {

    private UUID id;
    private String name;
    private String description;
    private String tasks;
    private boolean enabled;

}
