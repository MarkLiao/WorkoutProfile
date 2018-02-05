package com.markus.workoutprofiles.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.markus.workoutprofiles.Beans.UserDetailsBean;
import com.markus.workoutprofiles.Entity.WorkoutProfileActivityEntity;
import com.markus.workoutprofiles.Entity.WorkoutProfileEntity;

public interface IWorkoutProfileService {

	List<WorkoutProfileEntity> getAllProfiles();

	ResponseEntity<String> createNewProfile(WorkoutProfileEntity newProfile);

	ResponseEntity<String> deleteExistingProfile(Long id);

	List<WorkoutProfileActivityEntity> getUserActivityList(Long id);

	ResponseEntity<String> updateUserDetails(UserDetailsBean userDetails);

	WorkoutProfileEntity getUserProfileById(Long userId);
}
