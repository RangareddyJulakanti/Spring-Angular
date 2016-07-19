package jwd.parcijalni.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.parcijalni.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public Page<User> findByFirstnameLikeOrLastnameLike(Pageable page ,String firstname, String lastname);

}
