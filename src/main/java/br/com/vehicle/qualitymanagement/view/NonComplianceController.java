package br.com.vehicle.qualitymanagement.view;

import br.com.vehicle.qualitymanagement.service.NonComplianceService;
import br.com.vehicle.qualitymanagement.view.resource.NonComplianceRequest;
import br.com.vehicle.qualitymanagement.view.resource.NonComplianceResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/nonCompliance")
public class NonComplianceController {

    private NonComplianceService nonComplianceService;

    public NonComplianceController(NonComplianceService nonComplianceService) {
        this.nonComplianceService = nonComplianceService;
    }

    @GetMapping
    public ResponseEntity<List<NonComplianceResponse>> list() {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<NonComplianceResponse> create(@RequestBody NonComplianceRequest nonComplianceRequest) {
        nonComplianceService.create(nonComplianceRequest.toDomain());

        return ResponseEntity.ok().build();
    }

}
