package com.bionic.edu.dao;

import com.bionic.edu.entity.Outcome;

public interface OutcomeDao {
	
	public void save(Outcome outcome);
	
	public Outcome findById(int id);

}
