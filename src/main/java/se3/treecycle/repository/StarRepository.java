package se3.treecycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se3.treecycle.entity.Education;
import se3.treecycle.entity.Member;
import se3.treecycle.entity.Star;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
    Star findByMemberAndEducation(Member member, Education education);
}
