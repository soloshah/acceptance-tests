package uk.nhs.nhsbsa.ccchs.utils;

import org.apache.log4j.Logger;

public final class TestLogger {
	
	final static Logger logger = Logger.getLogger(TestLogger.class);

	public enum Entry {
		Step, Check, Info, Error
	}

	public static void LogTestHasStarted(String test) {
		Info("================================================================ ::");
		Info("================================================================ ::");
		Info("Starting Test: " + test);
		Info("================================================================ ::");
		Info("================================================================ ::");
	}

	public static void Step(String message) {
		LogMessage(message, Entry.Step);
	}

	public static void Check(String message) {
		LogMessage(message, Entry.Check);
	}

	public static void Info(String message) {
		LogMessage(message, Entry.Info);
	}

	public static void Error(String message, Exception ex) {
		LogMessage(message, ex);
	}

	private static void LogMessage(String message, Entry entryType) {
		logger.info(entryType + ": " + message);
	}

	private static void LogMessage(String message, Exception ex) {

	}
}
