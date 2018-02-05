package com.markus.workoutprofiles.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.markus.workoutprofiles.DAO.IWorkoutProfileActivityDao;
import com.markus.workoutprofiles.Entity.WorkoutProfileActivityEntity;

@Service
public class WorkoutProfileActivityService implements IWorkoutProfileActivityService {

	@Autowired
	private IWorkoutProfileActivityDao activityDao;

	@Override
	public ResponseEntity<String> createNewActivity(WorkoutProfileActivityEntity workoutActivity) {
		return this.activityDao.createNewActivity(workoutActivity);
	}

	@Override
	public List<WorkoutProfileActivityEntity> getActivityListByUserId(Long userId) {
		return this.activityDao.getActivityListByUserId(userId);
	}

}
