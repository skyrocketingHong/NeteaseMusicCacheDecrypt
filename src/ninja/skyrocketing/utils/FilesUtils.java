package ninja.skyrocketing.utils;

import java.io.File;
import java.util.ArrayList;

/**
 * @Author skyrocketing Hong
 * @Date 2020-07-16 016 11:04:16
 * @Version 1.0
 */
public class FilesUtils {
	public static ArrayList<String> getFiles(String path) {
		ArrayList<String> files = new ArrayList<>();
		File file = new File(path);
		File[] tempList = file.listFiles();
		
		for (File value : tempList) {
			if (value.isFile()) {
				String fileName = value.toString();
				if (fileName.matches(".*[.uc]")) {
					files.add(fileName);
				}
			}
			if (value.isDirectory()) {
				break;
			}
		}
		return files;
	}
}
