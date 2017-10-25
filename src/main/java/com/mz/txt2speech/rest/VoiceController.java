package com.mz.txt2speech.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mz.txt2speech.dto.LanguageInfo;
import com.mz.txt2speech.dto.LanguageUtils;
import com.mz.txt2speech.service.EffectService;
import com.mz.txt2speech.service.impl.VoiceManagerServiceImpl;

import marytts.signalproc.effects.AudioEffect;
import marytts.signalproc.effects.AudioEffects;

@RestController
public class VoiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VoiceController.class);

	@Autowired
	private VoiceManagerServiceImpl voiceManagerService;
	@Autowired
	private EffectService effectService;

	@RequestMapping("/say")
	public void say(@RequestParam String text, @RequestParam(required = false) String effect,
			@RequestParam(required = false) String value) {
		if (!StringUtils.isEmpty(text)) {
			if (!StringUtils.isEmpty(effect)) {
				// TODO + jellel join ha tobb
				voiceManagerService.getInstance().setAudioEffects(effectService.setPattern(effect, value));
			} else {
				voiceManagerService.resetEffects();
			}
			voiceManagerService.playAudio(text);
		}
	}

	@RequestMapping("/info/voices")
	public Set<String> getVoices() {
		return voiceManagerService.getInstance().getAvailableVoices();
	}

	@RequestMapping("/info/locales")
	public Set<Locale> getLocales() {
		return voiceManagerService.getInstance().getAvailableLocales();
	}

	@RequestMapping("/info/effects")
	public List<String> getEffects() {
		List<String> result = new ArrayList<>();
		for (AudioEffect effect : AudioEffects.getEffects()) {
			LOGGER.info(effect.getName());
			LOGGER.info(effect.getHelpText());
			result.add(effect.getName());
		}
		return result;
	}

	@RequestMapping("/info/knownEffects")
	public List<String> getKnownEffects() {
		return effectService.getKnownEffects();
	}

	@RequestMapping("/info/effectPattern")
	public String getEffectPattern(@RequestParam String effect) {
		return effectService.getPattern(effect);
	}

	@RequestMapping("/info/languageTable")
	public List<LanguageInfo> getLanguageTable() {
		return LanguageUtils.getLanguageTable();
	}

}
