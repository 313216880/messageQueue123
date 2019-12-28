package com.cn.messageQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Process process = null;
		BufferedReader bufferedReader = null;
		BufferedReader bufrError = null;
        String cmdScript = "python " + "scriptPath";
        try {
			process = Runtime.getRuntime().exec(cmdScript);
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("UTF-8")));
			bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
			StringBuffer buffer = new StringBuffer();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				buffer.append(line).append("\n");
			}
			while ((line = bufrError.readLine()) != null) {
				buffer.append(line).append("\n");
			}
			int resultVul = process.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bufrError.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			if (process != null) {
				process.destroy();
			}
		};
        
        
        
        
    }
}
