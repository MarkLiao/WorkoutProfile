package com.markus.workoutprofiles.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.markus.workoutprofiles.Entity.WorkoutActivityTypeEntity;
import com.markus.workoutprofiles.Entity.WorkoutDayOfWeekEntity;

@Repository
@Transactional
public class DropDownDao implements IDropDownDao {

	private final static String dayOfWeekHql = "From WorkoutDayOfWeekEntity";
	private final static String workoutActivityTypeHql = "From WorkoutActivityTypeEntity";

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Map<String, Object> getActivityContainerDropDowns() {
		Map<String, Object> returnObject = new HashMap<>();
		returnObject.put("dayOfWeekList", getDayOfWeekDropDown());
		returnObject.put("workoutActivityTypeList", getActivityTypeDropDown());
		return returnObject;
	}

	@SuppressWarnings("unchecked")
	private List<WorkoutDayOfWeekEntity> getDayOfWeekDropDown() {
		List<WorkoutDayOfWeekEntity> dayOfWeekList = new ArrayList<>();
		dayOfWeekList = (List<WorkoutDayOfWeekEntity>) entityManager.createQuery(dayOfWeekHql).getResultList();
		return dayOfWeekList;
	}

	@SuppressWarnings("unchecked")
	private List<WorkoutActivityTypeEntity> getActivityTypeDropDown() {
		List<WorkoutActivityTypeEntity> activityTypeList = new ArrayList<>();
		activityTypeList = (List<WorkoutActivityTypeEntity>) entityManager.createQuery(workoutActivityTypeHql)
				.getResultList();
		return activityTypeList;
	}

}
