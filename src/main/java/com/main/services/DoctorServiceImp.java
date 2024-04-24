package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("docService")
public class DoctorServiceImp implements IDoctorService 
{
	@Autowired
	private EntityManager manager;

	@Override
	public List<Doctor> showDoctorsByIncomeRange(Float start, Float end)
	{
		//create stored procedure pointing to PL/SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_Get_Doctors_By_Income_Range", Doctor.class);
		//register both IN, OUT params  by specifying their modes
		query.registerStoredProcedureParameter(1, Float.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Float.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.REF_CURSOR);
		//set values IN params
		query.setParameter(1, start);
		query.setParameter(2, end);
		//call pl/sql procedure
		List<Doctor> dList = query.getResultList();
		
		return dList;
	}

	@Override
	public List<Doctor> showDoctorsBySpecialization(String specialization) 
	{
		 
		return null;
	}

}
