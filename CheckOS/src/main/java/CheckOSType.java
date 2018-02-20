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
            System.out.println("This is Unix or Linux box ... change in branch1");
    
        } 

        
	}

	

}
