package com.apps.first_app.repository;

import com.apps.first_app.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
}