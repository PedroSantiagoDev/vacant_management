package br.com.jphp.vacant_management.modules.company.repositories;

import br.com.jphp.vacant_management.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> { }
