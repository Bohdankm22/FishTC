package com.bionic.edu.service;

import com.bionic.edu.entity.Outcome;

public interface OutcomeService {
	
	public void save(Outcome outcome);
	
	public Outcome findById(int id);

}
