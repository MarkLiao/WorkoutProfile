package com.markus.workoutprofiles.DAO;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.markus.workoutprofiles.Entity.WorkoutProfileActivityEntity;

public interface IWorkoutProfileActivityDao {
	ResponseEntity<String> createNewActivity(WorkoutProfileActivityEntity workoutActivity);

	List<WorkoutProfileActivityEntity> getActivityListByUserId(Long userId);
}
