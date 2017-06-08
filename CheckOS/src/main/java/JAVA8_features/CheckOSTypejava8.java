package JAVA8_features;

import org.apache.commons.lang3.SystemUtils;

public class CheckOSTypejava8 {
	
	 static String OS = System.getProperty("os.name").toLowerCase();
	 
	public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
	
	public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		if(SystemUtils.IS_OS_WINDOWS_7)
            System.out.println("It's a Windows 7 OS");
        if(SystemUtils.IS_OS_WINDOWS_8)
            System.out.println("It's a Windows 8 OS");
        if(SystemUtils.IS_OS_LINUX)
            System.out.println("It's a Linux OS");

        
       
        
        if (isWindows()) {
            System.out.println("This is Windows");
        } else if (isUnix()) {
            System.out.println("This is Unix or Linux");
        } 
        
	}

}

