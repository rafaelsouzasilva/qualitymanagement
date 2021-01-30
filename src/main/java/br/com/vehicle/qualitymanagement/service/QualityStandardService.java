package br.com.vehicle.qualitymanagement.service;

import br.com.vehicle.qualitymanagement.domain.QualityStandard;
import br.com.vehicle.qualitymanagement.infra.adapter.QualityStandardAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualityStandardService {

    @Autowired
    private QualityStandardAdapter qualityStandardAdapter;

    public QualityStandardService(QualityStandardAdapter qualityStandardAdapter) {
        this.qualityStandardAdapter = qualityStandardAdapter;
    }
    
    public List<QualityStandard> findAll() {
        return qualityStandardAdapter.findAll();
    }

}
