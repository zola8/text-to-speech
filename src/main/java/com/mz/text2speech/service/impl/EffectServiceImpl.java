package com.mz.text2speech.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mz.text2speech.service.EffectService;

import marytts.signalproc.effects.AudioEffects;

@Service
public class EffectServiceImpl implements EffectService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EffectServiceImpl.class);

	@Override
	public List<String> getEffects() {
		List<String> result = new ArrayList<>();

		AudioEffects.getEffects().iterator().forEachRemaining((effect) -> {
			result.add(effect.getName());
		});

		LOGGER.debug("Collected effects = {}", result);
		return result.stream().sorted().collect(Collectors.toList());
	}

	@Override
	public String getEffectsInfo() {
		StringBuilder result = new StringBuilder();

		AudioEffects.getEffects().iterator().forEachRemaining((effect) -> {
			result.append(effect.getName()).append("\n");
			result.append(effect.getHelpText()).append("\n");
		});

		return result.toString();
	}

	@Override
	public int countEffects() {
		return AudioEffects.countEffects();
	}

}
