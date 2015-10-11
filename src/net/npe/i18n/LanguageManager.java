/**
 * LanguageManager.java
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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import net.npe.util.EventListenerList;

public abstract class LanguageManager {
	
	public LanguageManager() {
	}
	
	public abstract void readLanguage(String path);
	
	public Language getLanguage(String key) {
		return languages.get(key);
	}
	
	public Language getLanguageFromLocale(String locale) {
		Iterator<Language> iterator = languages.values().iterator();
		while(iterator.hasNext()) {
			Language language = iterator.next();
			if(locale.equals(language.getLocale())) {
				return language;
			}
		}
		return null;
	}
	
	public Language getCurrent() {
		return current;
	}
	
	public Language getDefaultLanguage() {
		String locale = Locale.getDefault().getLanguage();
		return getLanguageFromLocale(locale);
	}
	
	public void addLanguageListener(LanguageListener listener) {
		listeners.add(listener);
	}
	
	public void removeLanguageListener(LanguageListener listener) {
		listeners.remove(listener);
	}
	
	public void fireLanguageEvent() {
		LanguageEvent e = new LanguageEvent(current);
		for(int i=0; i<listeners.size(); i++) {
			listeners.get(i).languageChanged(e);
		}
	}

	protected HashMap<String, Language> languages = new HashMap<String, Language>();
	protected EventListenerList<LanguageListener> listeners = new EventListenerList<LanguageListener>();
	protected Language current;

}
