package se3.treecycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se3.treecycle.entity.Education;

import java.util.Optional;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    @Override
    Optional<Education> findById(Long id);
}
