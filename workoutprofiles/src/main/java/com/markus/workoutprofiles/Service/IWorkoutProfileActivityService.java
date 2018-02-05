package com.markus.workoutprofiles.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.markus.workoutprofiles.Entity.WorkoutProfileActivityEntity;

public interface IWorkoutProfileActivityService {
	ResponseEntity<String> createNewActivity(WorkoutProfileActivityEntity workoutActivity);

	List<WorkoutProfileActivityEntity> getActivityListByUserId(Long userId);
}
