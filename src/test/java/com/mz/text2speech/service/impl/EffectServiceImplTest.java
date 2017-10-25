package com.mz.text2speech.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EffectServiceImplTest {

	@InjectMocks
	private EffectServiceImpl effectService;

	@Test
	public void testGetKnownEffects() {
		// WHEN
		List<String> result = effectService.getKnownEffects();

		// THEN
		assertNotNull(result);
		assertEquals(11, result.size());
		assertEquals("Chorus", result.get(0));
		assertEquals("F0Add", result.get(1));
		assertEquals("F0Scale", result.get(2));
		assertEquals("FIRFilter", result.get(3));
		assertEquals("JetPilot", result.get(4));
		assertEquals("Rate", result.get(5));
		assertEquals("Robot", result.get(6));
		assertEquals("Stadium", result.get(7));
		assertEquals("TractScaler", result.get(8));
		assertEquals("Volume", result.get(9));
		assertEquals("Whisper", result.get(10));
	}

	@Test
	public void testPatternNotFound() {
		// THEN
		assertNull(effectService.getPattern("not_found"));
	}

	@Test
	public void testGetPattern() {
		// WHEN
		String result = effectService.getPattern("Volume");

		// THEN
		assertEquals("Volume(amount:%s)", result);
	}

	@Test
	public void testSetPattern() {
		// WHEN
		String result = effectService.setPattern("Volume", "2");

		// THEN
		assertEquals("Volume(amount:2)", result);
	}

	@Test
	public void testSetPatternNotFound() {
		// THEN
		assertEquals(StringUtils.EMPTY, effectService.setPattern("not_found", "3"));
	}

}
