/**
 * ByteArrayWriter.java
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

public class ByteArrayWriter extends OutputWriter {
	
	/**
	 * constructor
	 * @param buffer byte array buffer
	 * @param offset offset in buffer
	 * @param endian default ByteOrderWriter (LittleEndian or BigEndian)
	 */
	public ByteArrayWriter(byte [] buffer, int offset, ByteOrderWriter endian) {
		super(endian);
		this.buffer = buffer;
		position = offset;
	}
	
	@Override
	public void write(int byteValue) {
		buffer[position++] = (byte)byteValue;
	}

	private byte [] buffer;
	private int position;
	
}
