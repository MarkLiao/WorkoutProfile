package com.markus.workoutprofiles.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "workoutprofile")
@JsonIgnoreProperties(allowGetters = true)
public class WorkoutProfileEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "First_Name")
	@NotBlank
	private String firstName;

	@Column(name = "Last_Name")
	@NotBlank
	private String lastName;

	@Column(name = "Age", nullable = false)
	private int age;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<WorkoutProfileActivityEntity> workoutProfileActivityEntity;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id")
	private UserDetailEntity userDetailEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<WorkoutProfileActivityEntity> getWorkoutProfileActivityEntity() {
		return workoutProfileActivityEntity;
	}

	public void setWorkoutProfileActivityEntity(List<WorkoutProfileActivityEntity> workoutProfileActivityEntity) {
		this.workoutProfileActivityEntity = workoutProfileActivityEntity;
	}

	public UserDetailEntity getUserDetailEntity() {
		return userDetailEntity;
	}

	public void setUserDetailEntity(UserDetailEntity userDetailEntity) {
		this.userDetailEntity = userDetailEntity;
	}

}
