package utils;
import org.apache.commons.lang3.SystemUtils;

public class Architecture {

	public enum OSType {
		WINDOWS, MAC, LINUX
	};

	public static OSType getOperatingSystemType() {
		if (SystemUtils.IS_OS_WINDOWS) {
			return OSType.WINDOWS;
		}
		
		if (SystemUtils.IS_OS_MAC) {
			return OSType.MAC;
		}
		
		return OSType.LINUX;
	}

	public static boolean is64bits() {
		boolean is64bit = false;
		if (System.getProperty("os.name").contains("Windows")) {
			is64bit = System.getenv("ProgramFiles(x86)") != null;
		} else {
			is64bit = System.getProperty("os.arch").indexOf("64") != -1;
		}

		return is64bit;
	}

}
