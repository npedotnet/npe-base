/**
 * LanguageEvent.java
 * 
 * Copyright (c) 2015 Kenji Sasaki
 * Released under the MIT license.
 * https://github.com/npedotnet/npe-base/blob/master/LICENSE
 * 
 * This file is a part of npe-base.
 * https://github.com/npedotnet/npe-base
 *
 * For more details, see npe-base wiki.
 * https://github.com/npedotnet/npe-base/wiki
 * 
 */

package net.npe.i18n;

public class LanguageEvent {
	
	public LanguageEvent(Language language) {
		this.language = language;
	}
	
	public Language getLanguage() {
		return language;
	}
	
	private Language language;

}
