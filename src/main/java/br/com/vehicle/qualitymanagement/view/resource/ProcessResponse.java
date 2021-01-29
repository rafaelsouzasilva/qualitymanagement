package br.com.vehicle.qualitymanagement.view.resource;

import br.com.vehicle.qualitymanagement.domain.Process;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProcessResponse {

    private UUID id;
    private String name;
    private String description;
    private String tasks;
    private boolean enabled;

    public static ProcessResponse fromDomain(Process process) {
        return new ProcessResponse(
                process.getId(),
                process.getName(),
                process.getDescription(),
                process.getTasks(),
                process.isEnabled()
            );
    }
}
