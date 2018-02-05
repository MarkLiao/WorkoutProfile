package com.markus.workoutprofiles.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markus.workoutprofiles.DAO.IDropDownDao;

@Service
public class DropDownService implements IDropDownService {

	@Autowired
	IDropDownDao dropDownDao;

	@Override
	public Map<String, Object> getActivityContainerDropDowns() {
		return dropDownDao.getActivityContainerDropDowns();
	}

}
