package jwd.parcijalni.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.parcijalni.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

	public Page<Activity> findByNameLike(Pageable page ,String name);
}
