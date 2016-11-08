
package com.jfixby.rmi.api.files;

import java.io.IOException;

import com.jfixby.cmns.api.java.ByteArray;
import com.jfixby.rmi.api.RMIFace;

public interface RMIFilesDataContainer extends RMIFace {

	boolean delete (java.util.List<String> relativePath) throws java.rmi.RemoteException;

	boolean isFolder (java.util.List<String> relativePath) throws java.rmi.RemoteException, IOException;

	boolean isFile (java.util.List<String> relativePath) throws java.rmi.RemoteException, IOException;

	boolean exists (java.util.List<String> relativePath) throws java.rmi.RemoteException, IOException;

	String[] listChildren (java.util.List<String> relativePath) throws java.rmi.RemoteException;

	boolean mkdirs (java.util.List<String> relativePath) throws java.rmi.RemoteException;

	boolean rename (java.util.List<String> relativePath, String new_name) throws java.rmi.RemoteException;

	long lastModified (java.util.List<String> relativePath) throws java.rmi.RemoteException, IOException;

	long getSize (java.util.List<String> relativePath) throws java.rmi.RemoteException, IOException;

	boolean writeDataToFile (java.util.List<String> relativePath, ByteArray data, boolean append)
		throws java.rmi.RemoteException, IOException;

	ByteArray readDataFromFile (java.util.List<String> relativePath) throws java.rmi.RemoteException, IOException;

}
