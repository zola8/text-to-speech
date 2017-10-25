package com.mz.text2speech.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mz.text2speech.service.EffectService;

@Service
public class EffectServiceImpl implements EffectService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EffectServiceImpl.class);

	private static Map<String, String> EFFECTS;

	// http://marytts.phonetik.uni-muenchen.de:59125/audioeffects
	// mary.setAudioEffects("Robot(amount:100)+Stadium(amount:200)");

	public EffectServiceImpl() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Volume", "Volume(amount:%s)"); // 0..2
		map.put("TractScaler", "TractScaler(amount:%s)"); // 0..4
		map.put("F0Scale", "F0Scale(f0Scale:%s)"); // ? 0..100
		map.put("F0Add", "F0Add(f0Add:%s)"); // ? 0..100
		map.put("Rate", "Rate(durScale:%s)");
		map.put("Robot", "Robot(amount:%s)");
		map.put("Whisper", "Whisper(amount:%s)");
		map.put("Stadium", "Stadium(amount:%s)");
		map.put("Chorus", "Chorus(delay1:466;amp1:0.54;delay2:600;amp2:-0.10;delay3:250;amp3:0.30)");
		map.put("FIRFilter", "FIRFilter(type:3;fc1:500.0;fc2:2000.0)");
		map.put("JetPilot", "JetPilot");
		EFFECTS = Collections.unmodifiableMap(map);
	}

	public List<String> getKnownEffects() {
		return EFFECTS.keySet().stream().sorted().collect(Collectors.toList());
	}

	public String getPattern(String effect) {
		return EFFECTS.get(effect);
	}

	public String setPattern(String effect, String value) {
		String result = getPattern(effect);
		if (StringUtils.isEmpty(result)) {
			LOGGER.info("No effect is set due to incorrect values. Effect={}; Value={}", effect, value);
			return StringUtils.EMPTY;
		}
		result = String.format(result, value);
		LOGGER.info("Effect is set to: {}", result);
		return result;
	}

}
