package com.markus.workoutprofiles.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.markus.workoutprofiles.Beans.UserDetailsBean;
import com.markus.workoutprofiles.Entity.WorkoutProfileEntity;
import com.markus.workoutprofiles.Service.IWorkoutProfileService;

@RestController
@RequestMapping("/profiles")
public class WorkoutProfileController {

	@Autowired
	private IWorkoutProfileService workoutProfileService;

	// Model And View Renders the View
	@RequestMapping
	private ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping("/createUserContainer")
	private ModelAndView getCreateUserContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("createUserContainer");
		return modelAndView;
	}

	@GetMapping("/listAllUsersContainer")
	private ModelAndView listAllUserContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listAllUsersContainer");
		return modelAndView;
	}

	@GetMapping("/userStatsContainer")
	private ModelAndView getUserStatsContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userStatsContainer");
		return modelAndView;
	}

	@GetMapping("/getAllProfiles")
	public List<WorkoutProfileEntity> getAllProfiles() {
		return this.workoutProfileService.getAllProfiles();
	}

	@PostMapping("/createNewProfile")
	public ResponseEntity<String> createNewProfile(@Valid @RequestBody WorkoutProfileEntity newProfile) {
		return this.workoutProfileService.createNewProfile(newProfile);
	}

	@PostMapping("/updateExistingProfile")
	public ResponseEntity<String> updateExistingProfile(@RequestBody UserDetailsBean userDetailsBean) {
		return this.workoutProfileService.updateUserDetails(userDetailsBean);
	}

	@GetMapping("/getUserProfileById/{id}")
	public WorkoutProfileEntity getUserProfileById(@PathVariable Long id) {
		return this.workoutProfileService.getUserProfileById(id);
	}

	@DeleteMapping("/removeProfile/{id}")
	public ResponseEntity<String> deleteExistingProfile(@PathVariable Long id) {
		return this.workoutProfileService.deleteExistingProfile(id);
	}
}
