package com.mz.txt2speech.service;

import marytts.MaryInterface;

public interface VoiceManagerService {

	MaryInterface getInstance();

	void playAudio(String text);

	public void resetEffects();

}
