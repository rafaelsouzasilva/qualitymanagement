package br.com.vehicle.qualitymanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ParametrizationQualityControl {

    private UUID id;
    private String description;
    private br.com.vehicle.qualitymanagement.domain.Process process;

}
