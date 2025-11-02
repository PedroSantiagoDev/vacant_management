package br.com.jphp.vacant_management.modules.company.controllers;

import br.com.jphp.vacant_management.modules.company.entities.JobEntity;
import br.com.jphp.vacant_management.modules.company.useCases.CreateJobUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
@Tag(name = "Vagas", description = "Endpoints para gerenciamento de vagas")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    @Operation(summary = "Criar nova vaga", description = "Endpoint para criar uma nova vaga (requer autenticação)")
    @SecurityRequirement(name = "bearer-jwt")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity) {
        return this.createJobUseCase.execute(jobEntity);
    }

}
