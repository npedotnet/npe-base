/**
 * NestedMap.java
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

import java.util.Map;

public interface NestedMap<K, V> extends Map<K, V> {
	
	public NestedMap<K, V> getNestedMap(K key);

}
