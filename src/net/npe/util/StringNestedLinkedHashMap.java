/**
 * StringNestedLinkedHashMap.java
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

package net.npe.util;

public class StringNestedLinkedHashMap extends NestedLinkedHashMap<String, Object> {
	
	public String getString(String key) {
		String [] tokens = key.split("\\.");
		if(1 < tokens.length) {
			NestedMap<String, Object> nestedMap = this;
			for(int i=0; i<tokens.length-1; i++) {
				nestedMap = getNestedMap(tokens[i]);
			}
			return (String)nestedMap.get(tokens[tokens.length-1]);
		}
		return (String)get(key);
	}

	private static final long serialVersionUID = 1L;

}
