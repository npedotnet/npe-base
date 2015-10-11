/**
 * XmlLanguageManager.java
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

package net.npe.i18n.xml;

import java.io.File;
import java.util.Locale;

import net.npe.i18n.LanguageManager;

public class XmlLanguageManager extends LanguageManager {
	
	public XmlLanguageManager() {
		super();
	}

	@Override
	public void readLanguage(String path) {
		XmlLanguage language = new XmlLanguage();
		language.read(path);
		languages.put(language.getName(), language);
	}
	
	public void readLanguages(String directory) {
		String [] list = new File(directory).list();
		for(String name : list) {
			if(name.endsWith(".xml")) {
				File file = new File(directory + name);
				if(file.isFile()) {
					readLanguage(directory + name);
				}
			}
		}
		current = getLanguageFromLocale(Locale.getDefault().getLanguage());
	}

}
