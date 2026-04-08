package com.project.jarvis.repository;

import com.project.jarvis.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("""
        SELECT p FROM Project p
        WHERE p.deletedAt IS NULL
        ORDER BY p.updatedAt DESC
    """)
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedAt IS NULL
            AND p.id = :projectId
            """)
    Optional<Project> findAccessibleProjectsById(@Param("projectId") Long projectId, @Param("userId") Long userId);

}
