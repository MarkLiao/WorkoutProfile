package com.markus.workoutprofiles.DAO;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.markus.workoutprofiles.Beans.UserDetailsBean;
import com.markus.workoutprofiles.Entity.WorkoutProfileActivityEntity;
import com.markus.workoutprofiles.Entity.WorkoutProfileEntity;

public interface IWorkoutProfileDao {
	List<WorkoutProfileEntity> getAllWorkoutProfiles();

	ResponseEntity<String> addNewProfile(WorkoutProfileEntity newProfile);

	ResponseEntity<String> deleteExistingProfile(Long id);

	WorkoutProfileEntity getProfileById(Long id);

	List<WorkoutProfileActivityEntity> getUserActivityList(Long id);

	ResponseEntity<String> updateUserDetails(UserDetailsBean userDetails);

}
