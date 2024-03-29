package com.group_A.MyTodo_App.repository;

import com.group_A.MyTodo_App.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
