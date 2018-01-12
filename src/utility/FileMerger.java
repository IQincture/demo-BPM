package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileMerger {

	public static void mergeFiles() throws IOException {
		File file = new File("D://Incture//AutomationFramWork//src//objectRepository");
		File outputFile = new File("D://Incture//AutomationFramWork//src//objectRepository//final.properties");
		File[] files = file.listFiles();

		StringBuffer sb = new StringBuffer();
		final char newLine = '\n';
		BufferedReader reader = null;
		for (File file2Read : files) {
			if (!file2Read.getName().equals("final.properties")) {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file2Read)));
				String readLine = null;
				while ((readLine = reader.readLine()) != null) {
					sb.append(readLine).append(newLine);
				}
				reader.close();
				sb.append(newLine);
			}
		}

		FileOutputStream os = new FileOutputStream(outputFile);
		os.write(sb.toString().getBytes());
		os.close();

	}

}
