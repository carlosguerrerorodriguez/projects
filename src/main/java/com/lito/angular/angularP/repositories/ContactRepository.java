package com.lito.angular.angularP.repositories;

import com.lito.angular.angularP.models.*;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<contact, String> {
    contact findOne(String id);

    @Override
    void delete(contact deleted);
}