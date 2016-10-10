/*
 * 
 */
package raiti.RaitisMod.API.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** <h1>TutorialLogger</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class TutorialLogger {
	
	public static Logger logger = LogManager.getLogger("TileTutorial");
	
	private TutorialLogger() {}
	
	public static void trace(String msg) {
		TutorialLogger.logger.trace(msg);
	}
 
	public static void info(String msg) {
		TutorialLogger.logger.info(msg);
	}
 
	public static void warn(String msg) {
		TutorialLogger.logger.warn(msg);
	}
	
}
