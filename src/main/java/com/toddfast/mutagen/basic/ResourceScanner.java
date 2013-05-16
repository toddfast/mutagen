package com.toddfast.mutagen.basic;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author Todd Fast
 */
public class ResourceScanner {

	/**
	 * 
	 * 
	 */
	private ResourceScanner() {
		super();
	}


	/**
	 *
	 *
	 */
	public List<String> getResources(String rootResourcePath,
			Pattern filterPattern, ClassLoader classLoader)
			throws URISyntaxException, IOException {

		Set<String> result=new TreeSet<String>();

		if (classLoader==null) {
			classLoader=ResourceScanner.class.getClassLoader();
		}

		Enumeration<URL> en=classLoader.getResources(rootResourcePath);

		if (!en.hasMoreElements()) {
			throw new IllegalArgumentException("No resources on path \""+
				rootResourcePath+"\" were found");
		}

		while (en.hasMoreElements()) {

			URI uri;
			try {
				uri=en.nextElement().toURI();
			}
			catch (URISyntaxException e) {
				throw new IOException("Exception converting resource URL "+
					"to URI (this shouldn't happen)",e);
			}

			result.addAll(
				getResources(uri,filterPattern));
		}

		return new ArrayList<String>(result);
	}


	/**
	 *
	 *
	 */
	private List<String> getResources(URI uri, Pattern pattern)
			throws IOException {

		List<String> result = new ArrayList<String>();

		System.err.println("Getting resources for URI: "+uri);
		if (uri.getScheme().equals("jar")) {
			// The URI looks like this:
			// jar:file:<path>/<file>.jar!/<qualified package path>
			String uriString=uri.toString();

			final String PREFIX="file:";
			int startIndex=uriString.indexOf(PREFIX);
			int endIndex=uriString.indexOf("!");

			assert startIndex!=-1 && endIndex!=-1:
				"JAR URI doesn't have expected format: "+uri;

			String fileURIString=
				uriString.substring(startIndex+PREFIX.length(),endIndex);
			File file = new File(fileURIString);

			// Everything after the "!/" in the URI is the resource path within
			// the jar. We don't want to return anything that does't also match
			// that.
			String resourcePath=uriString.substring(endIndex+2);
			result.addAll(
				getResourcesFromJarFile(file,pattern,resourcePath));
		}
		else {
			// The URI points to a file
			File file = new File(uri);

			if (file.isDirectory()){
				result.addAll(
					getResourcesFromDirectory(file,pattern));
			}
			else {
				result.addAll(
					getResourcesFromJarFile(file,pattern,null));
			}
		}
		return result;
	}


	/**
	 *
	 *
	 */
	private List<String> getResourcesFromJarFile(File file, Pattern pattern,
			String resourcePathPrefix)
			throws IOException {

		List<String> result = new ArrayList<String>();

		ZipFile zipfile=null;
		try{
			zipfile = new ZipFile(file);
			Enumeration e = zipfile.entries();
			while (e.hasMoreElements()) {
				ZipEntry entry = (ZipEntry)e.nextElement();

				if (entry.isDirectory()) {
					continue;
				}

				String entryName = entry.getName();
				if (pattern.matcher(entryName).matches()) {
					if (!entryName.startsWith(resourcePathPrefix)) {
						continue;
					}

					result.add(entryName);
				}
			}

		}
		finally {
			try {
				if (zipfile!=null) {
					zipfile.close();
				}
			}
			catch (IOException e){
				// Ignore
			}
		}

		return result;
	}


	/**
	 *
	 *
	 */
	private List<String> getResourcesFromDirectory(
			File directory, Pattern pattern)
			throws IOException {

		List<String> result = new ArrayList<String>();

		File[] fileList = directory.listFiles();
		for (File file: fileList) {
			if (file.isDirectory()) {
				result.addAll(getResourcesFromDirectory(file, pattern));
			}
			else {
				String fileName = file.getCanonicalPath();
				if (pattern.matcher(fileName).matches()) {
					result.add(fileName);
				}
			}
		}

		return result;
	}


	/**
	 *
	 *
	 */
	public static ResourceScanner getInstance() {
		return INSTANCE;
	}




	////////////////////////////////////////////////////////////////////////////
	// Fields
	////////////////////////////////////////////////////////////////////////////

	private static final ResourceScanner INSTANCE=new ResourceScanner();
}
