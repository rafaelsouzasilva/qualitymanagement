package br.com.vehicle.qualitymanagement.view;

import br.com.vehicle.qualitymanagement.service.QualityStandardService;
import br.com.vehicle.qualitymanagement.view.resource.QualityStandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/qualityStandard")
public class QualityStandardController {

    private QualityStandardService qualityStandardService;

    public QualityStandardController(QualityStandardService qualityStandardService) {
        this.qualityStandardService = qualityStandardService;
    }

    @GetMapping
    public ResponseEntity<List<QualityStandardResponse>> list() {
        return ResponseEntity.ok(
            qualityStandardService.findAll()
                .stream()
                .map(QualityStandardResponse::fromDomain)
                .collect(Collectors.toList())
        );
    }

}
