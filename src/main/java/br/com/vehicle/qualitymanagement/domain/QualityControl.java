package br.com.vehicle.qualitymanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class QualityControl {

    private UUID id;
    private Date evaluationDate;
    private boolean enabled;
    private boolean closed;
    private ParametrizationQualityControl parametrization;

}
