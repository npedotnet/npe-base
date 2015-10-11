/**
 * NestedArrayList.java
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

import java.util.ArrayList;

public class NestedArrayList<E> extends ArrayList<E> implements NestedList<E> {
	
	@SuppressWarnings("unchecked")
	@Override
	public NestedList<E> getNestedList(int index) {
		return (NestedList<E>)get(index);
	}

	private static final long serialVersionUID = 1L;

}
