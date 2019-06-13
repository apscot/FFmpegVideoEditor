package com.videoEditor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class VideoJoinerMainClass {

	public static void main(String[] args) throws IOException {
	
		File main = new File("G:\\outputs2");
		FileWriter fw = new FileWriter("src\\com\\resources\\names.txt");
		File[] files = main.listFiles();
		sortByNumber(files);
		for(File file : Arrays.asList(files)) {
			fw.append("file \'"+file.getAbsolutePath()+"\'\n");
		}
		fw.close();
		
		Process p = Runtime.getRuntime().exec("cmd /c start src\\com\\resources\\ffmpeg -f concat -safe 0 -i src\\com\\resources\\names.txt -c copy -pix_fmt yuv420p G:\\outputs\\final4.mp4");
		

	}

	
	public static void sortByNumber(File[] files) {
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int n1 = extractNumber(o1.getName());
                int n2 = extractNumber(o2.getName());
                return n1 - n2;
            }

            private int extractNumber(String name) {
                int i = 0;
                try {
                    //int s = name.indexOf('_')+1;
                    int e = name.lastIndexOf('.');
                    String number = name.substring(0, e);
                    i = Integer.parseInt(number);
                } catch(Exception e) {
                    i = 0; // if filename does not match the format
                           // then default to 0
                }
                return i;
            }
        });

        for(File f : files) {
            System.out.println(f.getName());
        }
    }
}
