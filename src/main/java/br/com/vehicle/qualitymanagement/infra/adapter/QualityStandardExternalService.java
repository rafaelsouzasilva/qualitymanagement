package br.com.vehicle.qualitymanagement.infra.adapter;

import br.com.vehicle.qualitymanagement.domain.QualityStandard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class QualityStandardExternalService implements QualityStandardAdapter {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${standard.service.api}")
    private String externalServiceApiUrl;

    @Override
    public List<QualityStandard> findAll() {
        QualityStandardResponseApi response = restTemplate.getForObject(
                externalServiceApiUrl,
                QualityStandardResponseApi.class
        );

        return response.getData();
    }
}
