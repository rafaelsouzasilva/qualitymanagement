package br.com.vehicle.qualitymanagement.infra.adapter;

import br.com.vehicle.qualitymanagement.domain.QualityStandard;

import java.util.List;

public interface QualityStandardAdapter {

    List<QualityStandard> findAll();
}
