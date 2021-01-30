package br.com.vehicle.qualitymanagement.view;

import br.com.vehicle.qualitymanagement.service.NonComplianceService;
import br.com.vehicle.qualitymanagement.service.QualityControlService;
import br.com.vehicle.qualitymanagement.view.resource.NonComplianceResponse;
import br.com.vehicle.qualitymanagement.view.resource.QualityControlResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/qualityControl")
public class QualityControlController {

    private QualityControlService qualityControlService;
    private NonComplianceService nonComplianceService;

    public QualityControlController(
            QualityControlService qualityControlService,
            NonComplianceService nonComplianceService
    ) {
        this.qualityControlService = qualityControlService;
        this.nonComplianceService = nonComplianceService;
    }

    @GetMapping
    public ResponseEntity<List<QualityControlResponse>> list() {
        return ResponseEntity.ok(
            qualityControlService.findAll()
                .stream()
                .map(QualityControlResponse::fromDomain)
                .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}/nonCompliance")
    public ResponseEntity<List<NonComplianceResponse>> listAllNonCompliance(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(
                nonComplianceService.findAllByQualityControl(id)
                        .stream()
                        .map(NonComplianceResponse::fromDomain)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<QualityControlResponse> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(
                QualityControlResponse.fromDomain(qualityControlService.findById(id))
        );
    }

}
