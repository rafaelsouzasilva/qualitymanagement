package br.com.vehicle.qualitymanagement.infra.adapter;

import br.com.vehicle.qualitymanagement.domain.QualityStandard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class QualityStandardResponseApi {

    private List<QualityStandard> data;

}
