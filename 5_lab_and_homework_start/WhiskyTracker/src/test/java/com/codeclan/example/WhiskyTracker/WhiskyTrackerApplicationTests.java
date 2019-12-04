package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.Region;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {


	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindAllWhiskysByYear(){
		List<Whisky> foundWhiskys = whiskyRepository.findAllWhiskysByYear(1991);
		assertEquals(1, foundWhiskys.size());
	}

	@Test
	public void canFindAllDistilleriesByRegion(){
		List<Distillery> foundRegions = distilleryRepository.findAllDistillerysByRegion("Highland");
		assertEquals(1, foundRegions.size());
	}

	@Test
	public void canFindAllWhiskysByDistilleryName(){
		List<Whisky> foundWhiskys = whiskyRepository.findAllWhiskysByDistilleryNameAndAge("Glendronach", 15);
		assertEquals(1, foundWhiskys.size());
	}

	@Test
	public void canFindAllWhiskysByDistilleryRegion(){
		List<Whisky> foundWhiskys = whiskyRepository.findAllWhiskysByDistilleryRegion("Highland");
		assertEquals(2, foundWhiskys.size());
	}

	@Test
	public void canFindAllDistillerysByWhiskyAge(){
		List<Distillery> foundDistillerys = distilleryRepository.findAllDistillerysByWhiskiesAge(12);
		assertEquals(2, foundDistillerys.size());
	}

}
