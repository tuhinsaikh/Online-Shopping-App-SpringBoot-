package com.project.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CurrentUserSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@Column(unique = true)
	private Integer UserId;
	
	private String uniqueId;
	private LocalDateTime time;
	public CurrentUserSession(Integer userId, String uniqueId, LocalDateTime time) {
		super();
		UserId = userId;
		this.uniqueId = uniqueId;
		this.time = time;
	}
	
	
	
	
}
