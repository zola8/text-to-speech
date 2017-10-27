package com.mz.text2speech.dto;

public class LanguageInfo {

	private String locale;
	private String voiceName;
	private String gender;

	public LanguageInfo(String locale, String voiceName, String gender) {
		this.locale = locale;
		this.voiceName = voiceName;
		this.gender = gender;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getVoiceName() {
		return voiceName;
	}

	public void setVoiceName(String voiceName) {
		this.voiceName = voiceName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LanguageInfo [locale=");
		builder.append(locale);
		builder.append(", voiceName=");
		builder.append(voiceName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}

}
