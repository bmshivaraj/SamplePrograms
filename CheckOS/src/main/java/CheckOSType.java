import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.SystemUtils;

public class CheckOSType {
	
	 static String OS = System.getProperty("os.name").toLowerCase();
	 
	public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
	
	public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

	public static void main(String[] args) {

        
        if (isWindows()) {
            System.out.println("This is Windows");
        } else if (isUnix()) {
            System.out.println("This is Unix or Linux box");
            
            //String[] command = { "service auditd "+ args[0] };
    		try {
    			Process process = Runtime.getRuntime().exec("service auditd "+args[0]);
    			InputStream inputStream = process.getInputStream();
    			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    			String line;
    			while ((line = bufferedReader.readLine()) != null) {
    				System.out.println(line);
    			}
    		} catch (Exception ex) {
    			System.out.println("Exception : " + ex);
    		}
    	       	
    		
    		
            
        } 
        
        String str = checkforservicestatus();
        System.out.println("str :"+str);
        
	}

	private static String checkforservicestatus() {
		// TODO Auto-generated method stub
		System.out.println("checking for service");
		String ret = "";
		try {

			Process process = Runtime.getRuntime ().exec ("service auditd status");
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line;
			String scOutput = "";

			// Append the buffer lines into one string
			while ((line = br.readLine()) != null) {
				System.out.println("line :"+line);
				scOutput += line + "\n";
			}

			
				if (scOutput.contains("Active: active (running)")) {
					return "RUNNING";
				} else if (scOutput.contains("Active: inactive (dead)")){
					// PrintToFile("Service stopped");
					return "dead";
				} else
				{
					return "UNKNOWN";
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
		
	}

}
