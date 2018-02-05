package com.markus.workoutprofiles.Controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.markus.workoutprofiles.Entity.WorkoutProfileActivityEntity;
import com.markus.workoutprofiles.Service.IDropDownService;
import com.markus.workoutprofiles.Service.IWorkoutProfileActivityService;

@RestController
@RequestMapping("/userStats")
public class UserStatsContainer {

	@Autowired
	private IWorkoutProfileActivityService activityService;

	@Autowired
	private IDropDownService dropDownService;

	@GetMapping("/getActivityContainer")
	public ModelAndView getActivityContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("workoutProfileActivityContainer");
		return modelAndView;
	}

	@GetMapping("/getActivityListContainer")
	public ModelAndView getActivityListContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("activityListContainer");
		return modelAndView;
	}

	@GetMapping("/loadActivityDropDowns")
	public Map<String, Object> getDropDowns() {
		return this.dropDownService.getActivityContainerDropDowns();
	}

	@GetMapping("/getUserDetailsContainer")
	public ModelAndView getUserDetailsContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userDetailsContainer");
		return modelAndView;
	}

	@GetMapping("/getUserActivityList/{id}")
	public List<WorkoutProfileActivityEntity> getActivityListByUserId(@PathVariable Long id) {
		return this.activityService.getActivityListByUserId(id);
	}

	@PostMapping("/createNewActivity")
	public ResponseEntity<String> saveActivity(@Valid @RequestBody WorkoutProfileActivityEntity workoutActivity) {
		return this.activityService.createNewActivity(workoutActivity);
	}

}
