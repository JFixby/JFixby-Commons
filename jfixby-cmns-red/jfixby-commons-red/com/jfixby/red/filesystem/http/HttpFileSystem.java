
package com.jfixby.red.filesystem.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.jfixby.cmns.api.debug.Debug;
import com.jfixby.cmns.api.err.Err;
import com.jfixby.cmns.api.file.File;
import com.jfixby.cmns.api.file.FileInputStream;
import com.jfixby.cmns.api.file.FileOutputStream;
import com.jfixby.cmns.api.file.FileSystem;
import com.jfixby.cmns.api.net.http.Http;
import com.jfixby.cmns.api.net.http.HttpURL;
import com.jfixby.cmns.api.util.path.AbsolutePath;
import com.jfixby.cmns.api.util.path.RelativePath;
import com.jfixby.red.filesystem.AbstractFileSystem;
import com.jfixby.red.filesystem.http.descript.HttpFolderDescriptor;

public class HttpFileSystem extends AbstractFileSystem implements FileSystem {

	public static final String OS_SEPARATOR = "/";

	private final HttpURL url;
	final private String name;

	public HttpFileSystem (final HttpFileSystemSpecs specs) {
		this.url = Debug.checkNull("rootUrl", specs.getRootUrl());
		this.name = "HttpFileSystem<" + this.url + ">";
	}

	public HttpURL getURLFor (final AbsolutePath<FileSystem> abs) {
		final RelativePath relative = abs.getRelativePath();
		final String prefix = (this.url.getURLString());
		final String urlString = prefix + this.mid(prefix) + urlEncodeString("" + relative);
		final HttpURL url = Http.newURL(urlString);
		return url;
	}

	private static String urlEncodeString (final String string) {
		try {
			return URLEncoder.encode(string, "UTF-8");
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String mid (final String prefix) {
		return prefix.endsWith(OS_SEPARATOR) ? "" : OS_SEPARATOR;
	}

	@Override
	public HttpFile newFile (final AbsolutePath<FileSystem> file_path) {
		if (file_path == null) {
			throw new Error("Filepath is null.");
		}
		if (file_path.getMountPoint() != this) {
			throw new Error("Path does not belong to this filesystem: " + file_path);
		}
		return new HttpFile(this, file_path);
	}

	@Override
	public FileOutputStream newFileOutputStream (final File output_file) {
		Err.reportError("Read only file system");
		return null;// final FileFilter F
	}

	@Override
	public FileOutputStream newFileOutputStream (final File output_file, final boolean append) {
		Err.reportError("Read only file system");
		return null;// final FileFilter F
	}

	@Override
	public FileInputStream newFileInputStream (final File input_file) {
		if (input_file == null) {
			throw new Error("Input file is null.");
		}
		if (input_file.getFileSystem() != this) {
			throw new Error("Input file does not belong to this filesystem: " + input_file);
		}

		return new HttpFileInputStream((HttpFile)input_file);
	}

	@Override
	public String nativeSeparator () {
		return OS_SEPARATOR;
	}

	public static String toNativePathString (final String string) {
		return string;
	}

	@Override
	public String toString () {
		return this.name;
	}

	public String getName () {
		return this.name;
	}

	final HTTPFileInfoCache hTTPFileInfoCache = new HTTPFileInfoCache();
	final HttpFolderDescriptorCache httpFolderDescriptorCache = new HttpFolderDescriptorCache();

	public HTTPFileInfo getCachedInfo (final HttpURL key) {
		return this.hTTPFileInfoCache.get(key);
	}

	public void caheValue (final HttpURL key, final HTTPFileInfo info) {
		this.hTTPFileInfoCache.put(key, info);
	}

	public HttpFolderDescriptor getCachedDescriptor (final HttpURL key) {
		return this.httpFolderDescriptorCache.get(key);
	}

	public void caheValue (final HttpURL key, final HttpFolderDescriptor desc) {
		this.httpFolderDescriptorCache.put(key, desc);
	}
}
