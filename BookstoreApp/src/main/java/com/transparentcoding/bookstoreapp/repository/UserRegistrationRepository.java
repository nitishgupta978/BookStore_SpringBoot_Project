package com.transparentcoding.bookstoreapp.repository;

import com.transparentcoding.bookstoreapp.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Long> {

    @Query(value = "select * from user_registration where email_id=?1 and password = ?2", nativeQuery = true)
    Optional<UserRegistration> findByEmail(String emailId, String password);


    @Query(value = " select  * from user_registration here id=?1", nativeQuery = true)
    UserRegistration getById(String id);
}
