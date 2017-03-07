package com.iqmsoft.boot.wickets.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iqmsoft.boot.wickets.model.Admin;


public interface AdminRepository extends MongoRepository<Admin, String>{

}
