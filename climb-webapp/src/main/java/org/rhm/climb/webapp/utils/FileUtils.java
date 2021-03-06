package org.rhm.climb.webapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

	public static void saveFile(File file, String fileName) throws IOException {
		
		FileInputStream in = null;
		FileOutputStream out = null;

		String destinationDir = file.getAbsoluteFile().getParentFile().getAbsolutePath() + File.separator + "climb-webapp" + File.separator + "uploads";
		File destDir = new File(destinationDir);

		if (!destDir.exists())
			destDir.mkdirs();
		
		
		//String targetPath = dir.getPath() + File.separator + fileName;
		String targetPath = destDir +  File.separator + fileName;

		System.out.println("source file path ::" + file.getAbsolutePath());
		System.out.println("saving file to ::" + targetPath);
		
		
		File destinationFile = new File(targetPath);
		

		
		
		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(destinationFile);
			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}

		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}

	}
}