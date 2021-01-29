package br.com.vehicle.qualitymanagement.view;

import br.com.vehicle.qualitymanagement.domain.NonCompliance;
import br.com.vehicle.qualitymanagement.service.NonComplianceService;
import br.com.vehicle.qualitymanagement.view.resource.NonComplianceRequest;
import br.com.vehicle.qualitymanagement.view.resource.NonComplianceResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nonCompliance")
public class NonComplianceController {

    private NonComplianceService nonComplianceService;

    public NonComplianceController(NonComplianceService nonComplianceService) {
        this.nonComplianceService = nonComplianceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NonComplianceResponse> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(
                NonComplianceResponse.fromDomain(nonComplianceService.find(id))
        );
    }

    @GetMapping
    public ResponseEntity<List<NonComplianceResponse>> list() {
        return ResponseEntity.ok(
            nonComplianceService.findAll()
                .stream()
                .map(NonComplianceResponse::fromDomain)
                .collect(Collectors.toList())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        nonComplianceService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<NonComplianceResponse> create(@RequestBody NonComplianceRequest nonComplianceRequest) {
        NonComplianceResponse nonComplianceResponse = NonComplianceResponse.fromDomain(
            nonComplianceService.create(nonComplianceRequest.toDomain())
        );

        return ResponseEntity
                .created(URI.create("/nonCompliance/" + nonComplianceResponse.getId()))
                .body(nonComplianceResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<NonComplianceResponse> update(
            @PathVariable("id") UUID id,
            @RequestBody NonComplianceRequest nonComplianceRequest
    ) {
        NonCompliance domain = nonComplianceRequest.toDomain();
        domain.setId(id);

        return ResponseEntity.ok().body(
            NonComplianceResponse.fromDomain(
                nonComplianceService.update(domain)
            )
        );
    }

}
