package ladjzero.hipda.core.utils;

/**
 * Created by chenzhuo on 2017/9/11.
 */

public class Logger{
	static private Log logger = new Log() {
		@Override
		public void info(String log) {
			System.out.println(log);
		}

		@Override
		public void error(String error) {
			System.err.println(error);
		}
	};

	static public void info(String log) {
		logger.info(log);
	}

	static public void error(String error) {
		logger.error(error);
	}

	static public void use(Log logger) {
		Logger.logger = logger;
	}
}
