package com.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.entity.Doctor;
import com.main.services.IDoctorService;

@SpringBootApplication
public class SbDataJpaProj08Application 
{

	public static void main(String[] args) 
	{
		  ApplicationContext ctx = SpringApplication.run(SbDataJpaProj08Application.class, args);
		
		     IDoctorService service = ctx.getBean("docService", IDoctorService.class);
		     List<Doctor> dList = service.showDoctorsByIncomeRange(20000f, 40000f);
		     System.out.println(dList);
		     ((ConfigurableApplicationContext) ctx).close();
		     
	}
	

}
