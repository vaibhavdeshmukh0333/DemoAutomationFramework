package UtilityClass;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.aventstack.extentreports.model.Log;

import Superclass.Baseclass;

public class Loggerclass 
{
	public static Logger log=Logger.getLogger(Log.class.getName());
	
	/**
	 * write method for when start test case execution than it will write logs of test cases execution process
	 * @param TestName
	 */
	public static void StartTest(String TestName)
	{
		log.info("=========="+TestName+" Start===========");
	}
	
	/**
	 * below method for end test case execution process than it will print
	 * @param EndTest
	 */
	public static void EndTest(String EndTest)
	{
		log.info("=========="+EndTest+" End==============");
	}
	
	/**
	 * below method for print the flow of excectuion process
	 * @param message
	 */
	public static void info(String message)
	{
		log.info(message);
	}
	
	/**
	 * below code print warn which is occured execution 
	 * @param message
	 */
	public static void warn(String message)
	{
		log.warn(message);
	}
	
	/**
	 * below code print error which is occured execution process
	 * @param message
	 */
	public static void error(String message)
	{
		log.error(message);
	}
	
	/**
	 * below code for print message of fattel error
	 * @param message
	 */
	public static void fatel(String message)
	{
		log.fatal(message);
	}
	
	/**
	 * below code for debug 
	 * @param message
	 */
	public static void debug(String message)
	{
		log.debug(message);
	}
	
}
