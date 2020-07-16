package ninja.skyrocketing.neteasemusiccachetrans.main;

import ninja.skyrocketing.utils.FilesUtils;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author skyrocketing Hong
 * @Date 2020-07-16 016 11:00:52
 * @Version 1.0
 */
public class Application {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入含有缓存文件的文件夹路径: ");
		String path = scanner.next();
		System.out.println("请输入转换后的的文件格式 (如mp3、flac): ");
		String type = scanner.next();
		
		for (String file : FilesUtils.getFiles(path)) {
			DecryptFiles.Decrypt(file, type);
		}
	}
}
