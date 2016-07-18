package jwd.parcijalni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.web.dto.ActivityDTO;

@Component
public class ActivityToActivityDTO implements Converter<Activity, ActivityDTO> {

	@Override
	public ActivityDTO convert(Activity activity) {
		
		if(activity ==null){
			return null;
		}
		
		ActivityDTO dto = new ActivityDTO();
		dto.setId(activity.getId());
		dto.setName(activity.getName());
		
		return dto;
	}
	
	public List<ActivityDTO> convert(List<Activity> activities){
		List<ActivityDTO> dtos = new ArrayList<>();
		
		for(Activity activity : activities){
			dtos.add(convert(activity));
		}
		return dtos;
	}

}
