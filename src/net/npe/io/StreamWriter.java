/**
 * StreamWriter.java
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

package net.npe.io;

import java.io.IOException;
import java.io.OutputStream;

public class StreamWriter extends OutputWriter {

	public StreamWriter(OutputStream stream, ByteOrderWriter endian) {
		super(endian);
		this.stream = stream;
	}
	
	@Override
	public void write(int byteValue) throws IOException {
		stream.write(byteValue);
	}
	
	private OutputStream stream;

}
