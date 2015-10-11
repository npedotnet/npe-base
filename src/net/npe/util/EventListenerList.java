/**
 * EventListenerList.java
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

import java.util.EventListener;
import java.util.LinkedList;

public class EventListenerList<T extends EventListener> extends LinkedList<T> {
	
	public EventListenerList() {
		super();
	}
	
	public void addListener(T listener) {
		add(listener);
	}
	
	public void removeListener(T listener) {
		remove(listener);
	}

	private static final long serialVersionUID = 1L;

}
