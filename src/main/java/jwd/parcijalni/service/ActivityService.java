package jwd.parcijalni.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.parcijalni.model.Activity;

public interface ActivityService {
	
	public Page<Activity> findAll(int page);
	public Activity findOne(Long id);
	public List<Activity> save(List<Activity> activities);
	public Activity save (Activity activity);
	public Activity delete(Long id);
	public List<Activity> delete(List<Long> id);
	public Page<Activity> findByName (int page ,String name);

}
