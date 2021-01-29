package br.com.vehicle.qualitymanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NonCompliance {

    private UUID id;
    private String title;
    private String description;
    private Date date;
    private String origin;
    private boolean enabled;
    private String violatedRuleCode;
    private String violatedRuleDescription;
    private QualityControl qualityControl;

}
