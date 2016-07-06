package com.softserve.osbb.repository;

import com.softserve.osbb.model.OsbbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OsbbRepository extends JpaRepository<OsbbEntity, Integer> {
}