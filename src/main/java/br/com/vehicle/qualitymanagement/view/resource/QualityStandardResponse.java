package br.com.vehicle.qualitymanagement.view.resource;

import br.com.vehicle.qualitymanagement.domain.QualityStandard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class QualityStandardResponse {

    private String code;
    private String description;

    public static QualityStandardResponse fromDomain(QualityStandard qualityStandard) {
        return new QualityStandardResponse(
                qualityStandard.getCode(),
                qualityStandard.getDescription()
            );
    }
}
