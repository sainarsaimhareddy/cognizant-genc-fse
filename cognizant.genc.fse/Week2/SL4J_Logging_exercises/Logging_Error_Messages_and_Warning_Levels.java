import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging_Error_Messages_and_Warning_Levels {

    private static final Logger logger = LoggerFactory.getLogger(Logging_Error_Messages_and_Warning_Levels.class);

    public static void main(String[] args) {
        logger.info("Application started");

        int value = 0;

        if (value == 0) {
            logger.warn("Value is zero, which might cause problems");
        }

        try {
            int result = 10 / value;
        } catch (ArithmeticException e) {
            logger.error("Error occurred while dividing by zero: {}", e.getMessage());
        }

        logger.info("Application finished");
    }
}
/*output
INFO  LoggerExample - Application started
WARN  LoggerExample - Value is zero, which might cause problems
ERROR LoggerExample - Error occurred while dividing by zero: / by zero
INFO  LoggerExample - Application finished
*/