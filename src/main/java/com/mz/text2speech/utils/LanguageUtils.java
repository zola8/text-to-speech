package com.mz.text2speech.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mz.text2speech.dto.LanguageInfo;

public final class LanguageUtils {

	public static final String GENDER_MALE = "male";
	public static final String GENDER_FEMALE = "female";

	private static List<LanguageInfo> infoTable;

	static {
		// http://myrobotlab.org/content/marytts-multi-language-support
		List<LanguageInfo> list = new ArrayList<>();
		list.add(new LanguageInfo("DE", "voice-bits1-hsmm", GENDER_FEMALE));
		list.add(new LanguageInfo("DE", "voice-bits3-hsmm", GENDER_MALE));
		list.add(new LanguageInfo("DE", "voice-dfki-pavoque-neutral-hsmm", GENDER_MALE));
		list.add(new LanguageInfo("EN_GB", "voice-dfki-poppy-hsmm", GENDER_FEMALE));
		list.add(new LanguageInfo("EN_GB", "voice-dfki-prudence-hsmm", GENDER_FEMALE));
		list.add(new LanguageInfo("EN_GB", "voice-dfki-obadiah-hsmm", GENDER_MALE));
		list.add(new LanguageInfo("EN_GB", "voice-dfki-spike-hsmm", GENDER_MALE));
		list.add(new LanguageInfo("EN_US", "voice-cmu-slt-hsmm", GENDER_FEMALE));
		list.add(new LanguageInfo("EN_US", "voice-cmu-bdl-hsmm", GENDER_MALE));
		list.add(new LanguageInfo("EN_US", "voice-cmu-rms-hsmm", GENDER_MALE));
		list.add(new LanguageInfo("FR", "voice-enst-camille-hsmm", GENDER_FEMALE));
		list.add(new LanguageInfo("FR", "voice-upmc-jessica-hsmm", GENDER_FEMALE));
		list.add(new LanguageInfo("FR", "voice-enst-dennys-hsmm", GENDER_MALE));
		list.add(new LanguageInfo("FR", "voice-upmc-pierre-hsmm", GENDER_MALE));
		list.add(new LanguageInfo("IT", "voice-istc-lucia-hsmm", GENDER_FEMALE));
		list.add(new LanguageInfo("TR", "voice-dfki-ot-hsmm", GENDER_MALE));
		list.add(new LanguageInfo("TE", "voice-cmu-nk-hsmm", GENDER_FEMALE));
		infoTable = Collections.unmodifiableList(list);
	}

	private LanguageUtils() {
		// utility constructor
	}

	public static List<LanguageInfo> getLanguageInfoTable() {
		return infoTable;
	}

}
