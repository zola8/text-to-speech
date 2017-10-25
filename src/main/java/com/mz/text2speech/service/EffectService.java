package com.mz.text2speech.service;

import java.util.List;

public interface EffectService {

	public List<String> getKnownEffects();

	public String getPattern(String effect);

	public String setPattern(String effect, String value);

}
