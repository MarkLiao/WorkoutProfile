package com.markus.workoutprofiles.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.markus.workoutprofiles.Beans.UserDetailsBean;
import com.markus.workoutprofiles.Entity.UserDetailEntity;
import com.markus.workoutprofiles.Entity.WorkoutProfileActivityEntity;
import com.markus.workoutprofiles.Entity.WorkoutProfileEntity;

@Repository
@Transactional
public class WorkoutProfileDaoImpl implements IWorkoutProfileDao {

	@PersistenceContext
	private EntityManager entityManager;

	private static final String HQLMATCH = "FROM WorkoutProfileEntity AS WP where WP.firstName = ? and WP.lastName = ? and WP.age = ?";
	private static final String ALLPROFILEHQL = "From WorkoutProfileEntity";
	private static final String USERACTIVITYLIST = "From WorkoutProfileActivityEntity as WPAE where WPAE.userId = ?";
	private static final String PDNE = "Profile doesn't exist";
	private static final String PAE = "Profile already exists";
	private static final String SUCCESS = "success";
	private static final String FAILURE = "failure";

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkoutProfileEntity> getAllWorkoutProfiles() {
		Query query = entityManager.createQuery(ALLPROFILEHQL);
		return (List<WorkoutProfileEntity>) query.getResultList();
	}

	@Override
	public ResponseEntity<String> addNewProfile(WorkoutProfileEntity newProfile) {
		if (doesProfileExist(newProfile)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.TEXT_PLAIN).body(PAE);
		}
		entityManager.persist(newProfile);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<String> deleteExistingProfile(Long id) {
		WorkoutProfileEntity profile = entityManager.find(WorkoutProfileEntity.class, id);
		if (profile == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.TEXT_PLAIN).body(FAILURE);
		}
		entityManager.remove(profile);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(SUCCESS);
	}

	@Override
	public WorkoutProfileEntity getProfileById(Long id) {
		WorkoutProfileEntity profile = entityManager.find(WorkoutProfileEntity.class, id);
		if (profile == null) {
			return null;
		}
		return profile;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkoutProfileActivityEntity> getUserActivityList(Long id) {
		List<WorkoutProfileActivityEntity> activityList = (List<WorkoutProfileActivityEntity>) entityManager
				.createQuery(USERACTIVITYLIST).setParameter(1, id);
		return activityList;
	}

	@Override
	public ResponseEntity<String> updateUserDetails(UserDetailsBean userDetails) {
		Long userId = userDetails.getUserId();
		WorkoutProfileEntity workoutProfile = entityManager.find(WorkoutProfileEntity.class, userId);
		if (workoutProfile == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.TEXT_PLAIN).body(FAILURE);
		}
		workoutProfile.setFirstName(userDetails.getUserFirstName());
		workoutProfile.setLastName(userDetails.getUserLastName());
		workoutProfile.setAge(userDetails.getUserAge());
		UserDetailEntity currentUserDetail = workoutProfile.getUserDetailEntity();
		if (currentUserDetail == null) {
			currentUserDetail = new UserDetailEntity();
		}
		currentUserDetail.setId(userDetails.getUserId());
		currentUserDetail.setUserHeight(userDetails.getUserHeight());
		currentUserDetail.setUserWeight(userDetails.getUserWeight());
		currentUserDetail.setUserGender(userDetails.getUserGender());
		workoutProfile.setUserDetailEntity(currentUserDetail);
		entityManager.persist(workoutProfile);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(SUCCESS);
	}

	private boolean doesProfileExist(WorkoutProfileEntity profile) {
		Query query = generateProfileMatchingQuery(profile);
		int count = query.getResultList().size();
		if (count > 0) {
			return true;
		}
		return false;
	}

	private Query generateProfileMatchingQuery(WorkoutProfileEntity profile) {
		return entityManager.createQuery(HQLMATCH).setParameter(1, profile.getFirstName())
				.setParameter(2, profile.getLastName()).setParameter(3, profile.getAge());
	}
}
