package com.mz.txt2speech.service.impl;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mz.txt2speech.service.VoiceManagerService;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

@Service
public class VoiceManagerServiceImpl implements VoiceManagerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VoiceManagerServiceImpl.class);

	private MaryInterface marytts = null;

	public VoiceManagerServiceImpl() {
		try {
			marytts = new LocalMaryInterface();
		} catch (MaryConfigurationException e) {
			LOGGER.error("MaryTTS initialization error.", e);
		}
	}

	public MaryInterface getInstance() {
		return marytts;
	}

	public void playAudio(String text) {
		AudioInputStream audio = null;
		try {
			audio = marytts.generateAudio(text);
			AudioPlayer player = new AudioPlayer(audio);
			player.start();
			player.join();
		} catch (SynthesisException ex) {
			LOGGER.error("Error during audio generation.", ex);
		} catch (InterruptedException ex) {
			LOGGER.error("Error during speaking.", ex);
		} finally {
			try {
				if (audio != null) {
					audio.close();
				}
			} catch (IOException ex) {
				LOGGER.error("Unrecoverable error.", ex);
			}
		}
	}

	public void resetEffects() {
		marytts.setAudioEffects(StringUtils.EMPTY);
	}

}
