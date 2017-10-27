package com.mz.text2speech.rest;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.text2speech.dto.LanguageInfo;
import com.mz.text2speech.service.EffectService;
import com.mz.text2speech.service.impl.VoiceManagerServiceImpl;
import com.mz.text2speech.utils.LanguageUtils;

@RestController
@RequestMapping("/info")
public class InfoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InfoController.class);

	@Autowired
	private VoiceManagerServiceImpl voiceManagerService;
	@Autowired
	private EffectService effectService;

	@RequestMapping("/voices")
	public Set<String> getVoices() {
		return voiceManagerService.getInstance().getAvailableVoices();
	}

	@RequestMapping("/locales")
	public Set<Locale> getLocales() {
		return voiceManagerService.getInstance().getAvailableLocales();
	}

	@RequestMapping("/effects/list")
	public List<String> getEffects() {
		return effectService.getEffects();
	}

	@RequestMapping("/effects/info")
	public String getEffectsInfo() {
		String result = effectService.getEffectsInfo();
		LOGGER.debug(result);
		return result;
	}

	@RequestMapping("/languageTable")
	public List<LanguageInfo> getLanguageTable() {
		return LanguageUtils.getLanguageInfoTable();
	}

}
