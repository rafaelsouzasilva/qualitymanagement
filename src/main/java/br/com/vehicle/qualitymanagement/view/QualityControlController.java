package br.com.vehicle.qualitymanagement.view;

import br.com.vehicle.qualitymanagement.service.QualityControlService;
import br.com.vehicle.qualitymanagement.view.resource.QualityControlResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/qualityControl")
public class QualityControlController {

    private QualityControlService qualityControlService;

    public QualityControlController(QualityControlService qualityControlService) {
        this.qualityControlService = qualityControlService;
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

}
