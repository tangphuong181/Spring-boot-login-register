package io.phuongnt.demo.dao;

import io.phuongnt.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

//  @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username=:username")
   public User findByUsername(/*@Param("username")*/ String username);



}
