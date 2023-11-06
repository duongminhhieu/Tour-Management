package com.tourmanagement.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class DaoBase {
    @PersistenceContext
    protected EntityManager _entityManager;
}
