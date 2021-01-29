package br.com.vehicle.qualitymanagement.view.resource;

import br.com.vehicle.qualitymanagement.domain.ParametrizationQualityControl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ParametrizationQualityControlResponse {

    private UUID id;
    private String description;
    private ProcessResponse process;

    public static ParametrizationQualityControlResponse fromDomain(ParametrizationQualityControl parametrizationQualityControl) {
        return new ParametrizationQualityControlResponse(
                parametrizationQualityControl.getId(),
                parametrizationQualityControl.getDescription(),
                ProcessResponse.fromDomain(parametrizationQualityControl.getProcess())
            );
    }
}
