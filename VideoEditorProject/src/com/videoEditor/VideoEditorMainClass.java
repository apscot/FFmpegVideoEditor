package com.videoEditor;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;

public class VideoEditorMainClass {

	static String[] extentionArray = { "mp4", "avi", "mkv" };
	static List<String> extentionsList = Arrays.asList(extentionArray);
	static String command = "";
	static int counter = 1;

	public static void main(String[] args) {
		try {
			File main = new File("E:\\himym\\All");
			
			listFiles(main);
			System.out.println(command);
			File file = new File("src\\com\\resources\\output.bat");

			file.createNewFile();
			FileWriter fw = new FileWriter("src\\com\\resources\\output.bat");
			fw.append("@ECHO off \n");
			fw.append(command);
			fw.close();

			
			Process p = Runtime.getRuntime().exec(file.getPath());
			

		} catch (Exception e) {
			System.out.println("HEY Buddy ! U r Doing Something Wrong ");
			e.printStackTrace();
		}
		// Enter data using BufferReader

	}

	public static void listFiles(File file) {
		if (file.isDirectory()) {
			// System.out.println("*"+file.getName()+"*");
			File[] innerFileArray = file.listFiles();
			Arrays.sort(innerFileArray);

			for (File innerFile : Arrays.asList(innerFileArray))
				listFiles(innerFile);
		} else {
			String extension = FilenameUtils.getExtension(file.getName());
			if (extentionsList.contains(extension.toLowerCase())) {
				command = command + "src\\com\\resources\\ffmpeg -i " + "\""+file.getAbsolutePath()+"\""
						+ " -ss";
				String time = "00:" + generateRandomNumber(3, 20) + ":" + generateRandomNumber(0, 50);
				command = command + " " + time + " -t 00:00:10 -vcodec copy -acodec copy -pix_fmt yuv420p G:\\outputs\\"
						+ counter + "." + extension + "\n";
				counter++;

			}
		}
	}

	public static String generateRandomNumber(int low, int high) {
		Random r = new Random();
		int result = r.nextInt(high - low) + low;
		String finalResult = "" + result;
		if (result < 10)
			finalResult = "0" + result;
		return finalResult;
	}

}
