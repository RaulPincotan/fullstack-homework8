package ro.fastrackit.fullstackhomework8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fastrackit.fullstackhomework8.model.entity.Cleanup;

public interface CleanupRepository extends JpaRepository<Cleanup, Long> {
}
