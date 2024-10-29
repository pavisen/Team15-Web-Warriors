package utilities;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataAutoGenerator {
	
	  public static String generateClassTopic() {
	        String topic = "Selenium Team15";
	        String timestamp = generateTimestamp();
	        String uniqueName = topic + timestamp;
	        return uniqueName;
	    }
	  
	  public static String generateBatchName() {
	        String batchname = "Team15-001";
	        String timestamp = generateTimestamp();
	        String uniqueName = batchname + timestamp;
	        return uniqueName;
	    }
	  private static String generateTimestamp() {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	        Date now = new Date();
	        return sdf.format(now);
	    }
}
