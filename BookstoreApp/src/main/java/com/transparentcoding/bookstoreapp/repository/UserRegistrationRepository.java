package com.transparentcoding.bookstoreapp.repository;

import com.transparentcoding.bookstoreapp.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Long> {
}
