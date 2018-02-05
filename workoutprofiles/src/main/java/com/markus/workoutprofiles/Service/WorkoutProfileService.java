package com.markus.workoutprofiles.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.markus.workoutprofiles.Beans.UserDetailsBean;
import com.markus.workoutprofiles.DAO.IWorkoutProfileDao;
import com.markus.workoutprofiles.Entity.WorkoutProfileActivityEntity;
import com.markus.workoutprofiles.Entity.WorkoutProfileEntity;

@Service
public class WorkoutProfileService implements IWorkoutProfileService {

	@Autowired
	private IWorkoutProfileDao workoutProfileDaoImpl;

	@Override
	public List<WorkoutProfileEntity> getAllProfiles() {
		return this.workoutProfileDaoImpl.getAllWorkoutProfiles();
	}

	@Override
	public ResponseEntity<String> createNewProfile(WorkoutProfileEntity newProfile) {
		return this.workoutProfileDaoImpl.addNewProfile(newProfile);
	}

	@Override
	public ResponseEntity<String> deleteExistingProfile(Long id) {
		return this.workoutProfileDaoImpl.deleteExistingProfile(id);
	}

	@Override
	public List<WorkoutProfileActivityEntity> getUserActivityList(Long id) {
		return this.workoutProfileDaoImpl.getUserActivityList(id);
	}

	@Override
	public ResponseEntity<String> updateUserDetails(UserDetailsBean userDetails) {
		return this.workoutProfileDaoImpl.updateUserDetails(userDetails);
	}

	@Override
	public WorkoutProfileEntity getUserProfileById(Long userId) {
		return this.workoutProfileDaoImpl.getProfileById(userId);
	}
}
