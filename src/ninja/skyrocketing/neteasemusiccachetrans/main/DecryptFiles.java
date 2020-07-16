package ninja.skyrocketing.neteasemusiccachetrans.main;

import java.io.*;

/**
 * @Author skyrocketing Hong
 * @Date 2020-07-16 016 12:27:02
 * @Version 1.0
 */
public class DecryptFiles {
	public static void Decrypt(String filePath, String fileType) throws IOException {
		File inFile = new File(filePath);
		String inFileName = inFile.getName();
		System.out.println("开始转换: " + inFileName);
		
		String[] fileNameSplit = inFileName.split("\\.");
		inFileName = fileNameSplit[0];
		
		File outFile = new File(inFile.getParentFile() + "\\" + inFileName + "." + fileType);
		
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream(inFile));
		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outFile));
		
		byte[] data = new byte[1024 * 4];
		int len;
		while ((len = dataInputStream.read(data)) != -1) {
			for (int i = 0; i < len; i++) {
				data[i] ^= 0xa3;
			}
			dataOutputStream.write(data, 0, len);
		}
		
		dataOutputStream.close();
		dataInputStream.close();
		
		if (outFile.setLastModified(inFile.lastModified())) {
			System.out.println("转换完成, 已将文件创建时间修改, 输出文件为: " + outFile.toString());
		} else {
			System.out.println("转换完成, 未修改文件创建时间, 输出文件为: " + outFile.toString());
		}
	}
}
