package com.mz.text2speech.service;

import java.util.List;

public interface EffectService {

	/**
	 * Gets back all known effects what can be added to the voice.
	 * 
	 * @return list of effects
	 */
	List<String> getEffects();

	/**
	 * Counts and gets back the number of applicable effects.
	 * 
	 * @return number of available effects
	 */
	int countEffects();

	/**
	 * Gets back all known effects and their's help text.
	 * 
	 * @return effects' help text
	 */
	String getEffectsInfo();

}
