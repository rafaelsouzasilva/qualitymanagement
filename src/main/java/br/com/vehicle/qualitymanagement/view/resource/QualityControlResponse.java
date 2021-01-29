package br.com.vehicle.qualitymanagement.view.resource;

import br.com.vehicle.qualitymanagement.domain.QualityControl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class QualityControlResponse {

    private UUID id;
    private Date evaluationDate;
    private boolean enabled;
    private boolean closed;
    private ParametrizationQualityControlResponse parametrization;

    public static QualityControlResponse fromDomain(QualityControl qualityControl) {
        return new QualityControlResponse(
                qualityControl.getId(),
                qualityControl.getEvaluationDate(),
                qualityControl.isEnabled(),
                qualityControl.isClosed(),
                ParametrizationQualityControlResponse.fromDomain(qualityControl.getParametrization())
            );
    }
}
