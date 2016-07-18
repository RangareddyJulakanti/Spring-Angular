package jwd.parcijalni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.service.ActivityService;
import jwd.parcijalni.web.dto.ActivityDTO;

@Component
public class ActivityDtoToActivity implements Converter<ActivityDTO, Activity> {

	@Autowired
	private ActivityService activityService;
	
	@Override
	public Activity convert(ActivityDTO dto) {
		Activity activity = new Activity();
		if(dto.getId()!=null){
			
			activity = activityService.findOne(dto.getId());
			
			if(activity == null){
				throw new IllegalStateException("Tried to "
						+ "modify a non-existant activity");
			}
		}
		
		activity.setId(dto.getId());
		activity.setName(dto.getName());

		return activity;
		
	}
	
	public List<Activity> convert(List<ActivityDTO> dtos){
		List<Activity> ret = new ArrayList<>();
		
		for(ActivityDTO dto: dtos){
			ret.add(convert(dto));
		}
		return ret;
	}

}
