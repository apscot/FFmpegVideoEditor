package com.videoEditor;

import java.io.File;
import java.io.FileWriter;

public class VideoEditorMainClass {

	public static void main(String[] args) {
		try {

			String ExecCommand = "cmd /c start src\\com\\resources\\ffmpeg -i G:\\MyWorkspace\\ffmpeg-4.1.3-win64-static\\ffmpeg-4.1.3-win64-static\\bin\\1.MOV -ss 00:00:05 -t 00:00:10 -vcodec copy -acodec copy G:\\MyWorkspace\\ffmpeg-4.1.3-win64-static\\ffmpeg-4.1.3-win64-static\\bin\\2.MOV"
					+ " \n "
					+ "src\\com\\resources\\ffmpeg -i G:\\MyWorkspace\\ffmpeg-4.1.3-win64-static\\ffmpeg-4.1.3-win64-static\\bin\\1.MOV -ss 00:00:20 -t 00:00:10 -vcodec copy -acodec copy G:\\MyWorkspace\\ffmpeg-4.1.3-win64-static\\ffmpeg-4.1.3-win64-static\\bin\\3.MOV"
					+ " \n " +

					"src\\com\\resources\\ffmpeg -f concat -safe 0 -i src\\com\\resources\\list.txt -c copy G:\\MyWorkspace\\ffmpeg-4.1.3-win64-static\\ffmpeg-4.1.3-win64-static\\bin\\output-final.MOV"
					+ " \n "
					+ "src\\com\\resources\\ffmpeg -i G:\\MyWorkspace\\ffmpeg-4.1.3-win64-static\\ffmpeg-4.1.3-win64-static\\bin\\output-final.MOV G:\\\\MyWorkspace\\\\ffmpeg-4.1.3-win64-static\\\\ffmpeg-4.1.3-win64-static\\\\bin\\\\output-final.mp4"
					+ " \n "

					+ "src\\com\\resources\\ffmpeg -f concat -safe 0 -i src\\com\\resources\\list2.txt -c copy G:\\MyWorkspace\\ffmpeg-4.1.3-win64-static\\ffmpeg-4.1.3-win64-static\\bin\\final.mp4";

			System.out.println(ExecCommand);

			File file = new File("src\\com\\resources\\test.bat");
			if (file.length() == 0) {
				file.createNewFile();
				FileWriter fw = new FileWriter("src\\com\\resources\\test.bat");
				fw.append("@ECHO off \n");
				fw.append(ExecCommand);
				fw.close();
			}

			Process p = Runtime.getRuntime().exec(file.getPath());

		} catch (Exception e) {
			System.out.println("HEY Buddy ! U r Doing Something Wrong ");
			e.printStackTrace();
		}
		// Enter data using BufferReader

	}
}
