package jwd.parcijalni.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.service.ActivityService;
import jwd.parcijalni.support.ActivityDtoToActivity;
import jwd.parcijalni.support.ActivityToActivityDTO;
import jwd.parcijalni.web.dto.ActivityDTO;

@RestController
@RequestMapping("api/activities")
public class ApiActivityController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActivityDtoToActivity toActivity;
	@Autowired
	private ActivityToActivityDTO toDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ActivityDTO>> findAll(@RequestParam(required = false, value = "name") String name,
			@RequestParam(required = true, value = "page") int page) {

		int totalPages = 0;
		Long totalElements = 0l;
		List ret = null;
		if (name != null) {
			Page<Activity> all = activityService.findByName(page, name);
			ret = all.getContent();
			totalPages = all.getTotalPages();
			totalElements = all.getTotalElements();
		} else {
			Page<Activity> all = activityService.findAll(page);
			ret = all.getContent();
			totalPages = all.getTotalPages();
			totalElements = all.getTotalElements();
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("total-pages", ""+totalPages);
		httpHeaders.add("total-elements", ""+totalElements);
		return new ResponseEntity<>(toDTO.convert(ret),httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ActivityDTO> findOne(@PathVariable Long id) {
		Activity activity = activityService.findOne(id);
		if (activity == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toDTO.convert(activity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ActivityDTO> save(@RequestBody Activity activity) {

		if (activity.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Activity saved = activityService.save(activity);

		return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ActivityDTO> delete(@PathVariable Long id) {
		Activity deleted = activityService.delete(id);
		if (deleted == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/{id}")
	public ResponseEntity<ActivityDTO> edit(@RequestBody ActivityDTO dto, @PathVariable Long id) {
		if (dto.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Activity saved = activityService.save(toActivity.convert(dto));

		return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.OK);

	}

}
