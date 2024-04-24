package com.main.services;

import java.util.List;

import com.main.entity.Doctor;
 

public interface IDoctorService 
{
     public List<Doctor> showDoctorsByIncomeRange(Float start, Float end);
     public List<Doctor> showDoctorsBySpecialization(String specialization);
     
}
