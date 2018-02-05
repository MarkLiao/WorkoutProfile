package com.markus.workoutprofiles.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.markus.workoutprofiles.Entity.WorkoutProfileActivityEntity;
import com.markus.workoutprofiles.Entity.WorkoutProfileEntity;

@Repository
@Transactional
public class WorkoutProfileActivityDao implements IWorkoutProfileActivityDao {

	@PersistenceContext
	EntityManager entityManager;

	private static final String FAILURE = "failure";
	private static final String SUCCESS = "success";

	@Override
	public ResponseEntity<String> createNewActivity(WorkoutProfileActivityEntity workoutActivity) {
		WorkoutProfileEntity workoutProfile = entityManager.find(WorkoutProfileEntity.class,
				workoutActivity.getUserId());
		if (workoutProfile == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.TEXT_PLAIN).body(FAILURE);
		}

		List<WorkoutProfileActivityEntity> profileActivities = workoutProfile.getWorkoutProfileActivityEntity();
		profileActivities.add(workoutActivity);
		entityManager.persist(workoutProfile);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(SUCCESS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkoutProfileActivityEntity> getActivityListByUserId(Long userId) {
		String hql = "From WorkoutProfileActivityEntity as WPAE where WPAE.userId = ?";
		List<WorkoutProfileActivityEntity> activityList = (List<WorkoutProfileActivityEntity>) entityManager
				.createQuery(hql).setParameter(1, userId).getResultList();
		return activityList;
	}

}
