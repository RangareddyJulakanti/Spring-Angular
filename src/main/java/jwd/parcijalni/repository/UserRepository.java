package jwd.parcijalni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.parcijalni.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
