package com.kisannetwork.smsservice.smsservice.repository;


import com.kisannetwork.smsservice.smsservice.domain.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {

}
