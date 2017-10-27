package com.mz.text2speech.rest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mz.text2speech.service.EffectService;
import com.mz.text2speech.service.impl.VoiceManagerServiceImpl;

@RestController
public class VoiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VoiceController.class);

	@Autowired
	private VoiceManagerServiceImpl voiceManagerService;

	@RequestMapping("/say")
	public void say(@RequestParam String text, @RequestParam(required = false) String effect,
			@RequestParam(required = false) String value) {
		if (!StringUtils.isEmpty(text)) {
			voiceManagerService.playAudio(text);
		}
	}

}
