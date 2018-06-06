package uk.nhs.nhsbsa.ccchs.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public final class Utilities {
	
	public enum RandomType {
		AlphaNum, Alpha, Num, NumNoZero
	}

	public enum PostCodeCountry {
		England, Scotland, Welsh, NIreland, Durham
	}

	public static String getEnglishPostCodeChars() {

		String[] english = { "NE", "DH", "SR", "TS", "DL", "HG", "LS", "YO",
				"HU", "WF", "CA", "LA", "BD", "FY", "OL", "BL", "WN", "WA",
				"CW", "SK", "DN", "NG", "DE", "LE", "PE", "NR", "IP",
				"CO", "OX", "RG", "GU", "RH", "TN", "ME", "EX", "TA", "BA",
				"DT" };
		return english[new Random().nextInt(english.length)];
	}
	
	public static String getEnglishPostCodeChars_DH() {

		String[] english = { "DH"};
		return english[new Random().nextInt(english.length)];
	}

	public static String getScottishPostCodeChars() {

		String[] scotland = { "KW", "IV", "AB", "PH", "DD", "PA", "FK", "KY",
				"G", "ML", "EH", "TD", "DG" };

		return scotland[new Random().nextInt(scotland.length)];
	}

	public static String getWelshPostCodeChars() {

		String[] welsh = { "LL", "SY", "LD", "SA", "CF", "NP" };

		return welsh[new Random().nextInt(welsh.length)];
	}

	public static String getNIrelandPostCodeChars() {
		return "BT";
	}

	public static String getRandomAlphaNumeric(int len, RandomType type) {

		String chars = "";

		switch (type) {

		case AlphaNum:
			chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			break;
		case Alpha:
			chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			break;
		case Num:
			chars = "0123456789";
			break;
		case NumNoZero:
			chars = "123456789";
			break;
		}

		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	/**
	 * generates a random post code but they aren't necessarily valid post
	 * codes, don't use in situations where you want a happy path through the
	 * application
	 * 
	 * @return
	 */
	public static String getRandomPostCode() {

		String firstPart;
		String secondPart;

		firstPart = getRandomAlphaNumeric(2, RandomType.Alpha)
				+ getRandomAlphaNumeric(1, RandomType.NumNoZero);

		secondPart = getRandomAlphaNumeric(1, RandomType.NumNoZero)
				+ getRandomAlphaNumeric(2, RandomType.Alpha);

		return firstPart + " " + secondPart;
	}

	/**
	 * generate a UK country specific random post code
	 * 
	 * @param country
	 * @return
	 */
	public static String getRandomPostCode(PostCodeCountry country) {

		String firstPart = null;
		String secondPart;

		switch (country) {
		
		case Durham:
			firstPart = getEnglishPostCodeChars_DH();
			break;
		case England:
			firstPart = getEnglishPostCodeChars();
			break;
		case Scotland:
			firstPart = getScottishPostCodeChars();
			break;
		case Welsh:
			firstPart = getWelshPostCodeChars();
			break;
		case NIreland:
			firstPart = getNIrelandPostCodeChars();
			break;
		}

		firstPart = firstPart + getRandomAlphaNumeric(1, RandomType.NumNoZero);

		secondPart = getRandomAlphaNumeric(1, RandomType.NumNoZero)
				+ getRandomAlphaNumeric(2, RandomType.Alpha);

		return (firstPart + " " + secondPart).toUpperCase(); // Postcode not taking space defect raised
		//return (firstPart +  secondPart).toUpperCase();
	}

	/**
	 * returns a string formatted date of either plus or minus one month from
	 * todays date, set minusOne to true if you want a date 1 month prior to
	 * today
	 * 
	 * @param minusOne
	 * @param noSlashes
	 * @return
	 */
	public static String getPlusMinusOneMonthStartDate(boolean minusOne,
			boolean noSlashes) {

		Calendar cal = Calendar.getInstance();

		if (minusOne) {
			cal.roll(Calendar.MONTH, 1); // subtract a month if true
		} else {
			cal.add(Calendar.MONTH, 1); // else add a month
		}

		SimpleDateFormat date;

		if (noSlashes) {
			date = new SimpleDateFormat("ddMMyyyy");
		} else {
			date = new SimpleDateFormat("dd/MM/yyyy");
		}

		String formattedDate = date.format(cal.getTime());

		return formattedDate;
	}
	
	
	/**
	 * returns a string formatted date of todays date 
	 * @param noSlashes
	 * @return
	 */
	public static String getCurrentDateStartDate(boolean noSlashes) {

		Calendar cal = Calendar.getInstance();
		
		cal.roll(Calendar.MONTH, 0);

		SimpleDateFormat date;

		if (noSlashes) {
			date = new SimpleDateFormat("ddMMyyyy");
		} else {
			date = new SimpleDateFormat("dd/MM/yyyy");
		}

		String formattedDate = date.format(cal.getTime());

		return formattedDate;
	}
	
	/**
	 * This method adds workdays (MONDAY - FRIDAY) to a given calendar object.
	 * If the number of days is negative than this method subtracts the working
	 * days from the calendar object.
	 * 
	 * 
	 * @param cal
	 * @param days
	 * @return new calendar instance
	 * @throws ParseException 
	 */
	public static Calendar addWorkDays(Calendar baseDate, final int days) throws ParseException {
		
		String HOLIDAYS_OF_YEAR = "28/08/2017";
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
	    Calendar resultDate = null;
	    Calendar workCal = Calendar.getInstance();
	    workCal.setTime(baseDate.getTime());

	    int currentWorkDay = workCal.get(Calendar.DAY_OF_WEEK);

	    // test if SATURDAY ?
	    if (currentWorkDay == Calendar.SATURDAY) {
	        // move to next FRIDAY
	        workCal.add(Calendar.DAY_OF_MONTH, (days < 0 ? -1 : +2));
	        currentWorkDay = workCal.get(Calendar.DAY_OF_WEEK);
	    }
	    // test if SUNDAY ?
	    if (currentWorkDay == Calendar.SUNDAY) {
	        // move to next FRIDAY
	        workCal.add(Calendar.DAY_OF_MONTH, (days < 0 ? -2 : +1));
	        currentWorkDay = workCal.get(Calendar.DAY_OF_WEEK);
	    }

	    // test if we are in a working week (should be so!)
	    if (currentWorkDay >= Calendar.MONDAY && currentWorkDay <= Calendar.FRIDAY) {
	        boolean inCurrentWeek = false;
	        if (days > 0)
	            inCurrentWeek = (currentWorkDay + days < 7);
	        else
	            inCurrentWeek = (currentWorkDay + days > 1);
	        	System.out.println(inCurrentWeek + " is value of boolean");

	        if (inCurrentWeek) {
	            workCal.add(Calendar.DAY_OF_MONTH, days);
	            resultDate = workCal;
	        } else {
	            int totalDays = 0;
	            int daysInCurrentWeek = 0;

	            // fill up current week.
	            if (days > 0) {
	                daysInCurrentWeek = Calendar.SATURDAY - currentWorkDay;
	                totalDays = daysInCurrentWeek + 2;
	            } else {
	                daysInCurrentWeek = -(currentWorkDay - Calendar.SUNDAY);
	                totalDays = daysInCurrentWeek - 2;
	            }

	            int restTotalDays = days - daysInCurrentWeek;
	            // next working week... add 2 days for each week.
	            int x = restTotalDays / 5;
	            totalDays += restTotalDays + (x * 2);

	            workCal.add(Calendar.DAY_OF_MONTH, totalDays);
	            resultDate = workCal;

	        }
	    }  
	      
	    return resultDate;
	}
	
	
	
	public static Calendar CheckBankHolidayDate(Calendar startdate, Calendar enddate) throws ParseException
	{
		int i=1;
		Calendar enddatetemp = enddate;
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		String formatted_enddate = df.format(enddatetemp.getTime()); 
		
		Calendar newdate = null;
		Calendar newdate1 = null;
		
		// if end date falls on the actual BH date
		if (formatted_enddate.equals("28/08/2017") || formatted_enddate.equals("29/05/2017"))
		{
    		
			enddate = addWorkDays(enddate, -1);
    		
    		return newdate;

		}
		else
		{
			while (i < 12)
			{
	    	
				if (formatted_enddate.equals("28/08/2017") || formatted_enddate.equals("29/05/2017"))
				{		
					enddate = addWorkDays(enddate, -2);
		    		
		    		System.out.println("New End Date................. " + df.format(newdate.getTime()));
		    		
		    		return enddate;

	    		}
				else
				{

				enddatetemp.add(Calendar.DATE, 1);
				
				formatted_enddate = df.format(enddatetemp.getTime());

				i++;
				}
				
			}
				
		}
		
		return (addWorkDays(enddate, -8));
		
	}
	
	
	
	
	public static Calendar CheckIfDateFallsOnBankHoliday(Calendar date) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		String formattedDate = df.format(date.getTime()); 
		
		// if end date falls on the actual BH date
				if (formattedDate.equals("28/08/2017") || formattedDate.equals("29/05/2017"))
				{
		    		
					date = addWorkDays(date, -1);
		    		
		    		System.out.println("Date falls on the actual BH........... " + df.format(date.getTime()));

				}
				
				return date;
		
	}
	
	
	
	
	/* ********* AMBER Status ********** */
	
	public static Calendar TraverseThroughDatesForNonBankHoliday_AMBER(Calendar date) throws ParseException
	{
		String[] HOLIDAYS_OF_YEAR = {"02/01/2017", "14/04/2017", "17/04/2017", "01/05/2017", "29/05/2017", "28/08/2017", "25/12/2017", "26/12/2017"};
		
		int i=1;
		int count = 0;
		Calendar finaldate= null;
		Calendar tempdate= date;
		Calendar FinalDate= date;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar CurrentDateCal = null;
		Calendar CurrentDatePlus2Cal = null;
		Calendar openedDateCal = null;
		Calendar openedDateTempCal = null;
		
		String formattedDate = df.format(date.getTime());
		System.out.println("formattedDate beginning...." + formattedDate);
		
		tempdate = date; //29
		
		String tempdateSave= df.format(date.getTime());
		
		// if end date falls on the actual BH date
//		if (formattedDate.equals("02/01/2017") || formattedDate.equals("14/04/2017") || formattedDate.equals("17/04/2017") || formattedDate.equals("01/05/2017") ||	formattedDate.equals("29/05/2017") ||formattedDate.equals("28/08/2017") || formattedDate.equals("25/12/2017") || formattedDate.equals("26/12/2017"))
			
			if (formattedDate.equals(HOLIDAYS_OF_YEAR[0]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[1]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[2]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[3]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[4]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[5]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[6]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[7]))
			{
			
			date = addWorkDays(date, -1);
    		
    		return date;

		}
		else
		{
		
			for(i=1; i<=12; i++)
			{
    	
				if (formattedDate.equals(HOLIDAYS_OF_YEAR[0]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[1]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[2]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[3]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[4]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[5]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[6]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[7]))
			{	
					count = count + 1;
					
					Date todaydate = new Date();
				    System.out.println("Today's Date to populate...." + df.format(todaydate));
				    
					CurrentDateCal = Utilities.toCalendar(todaydate); //CD
					CurrentDatePlus2Cal = Utilities.addWorkDays(CurrentDateCal, 2);   //CD + 2
				    System.out.println("CD + 2: " + df.format(CurrentDatePlus2Cal.getTime()));
				    
				    openedDateTempCal = Utilities.addWorkDays(CurrentDatePlus2Cal, -9); //go back 9 working day
				    System.out.println("openedDateTempCal: " + df.format(openedDateTempCal.getTime()));
				    
				    
				date = addWorkDays(openedDateTempCal, -count);
	    		
	    		System.out.println("New adjusted date................. " + df.format(date.getTime()));
	    		
	    		return date;

    		}
			
				tempdate.add(Calendar.DATE, 1);

				formattedDate = df.format(tempdate.getTime());
			
			System.out.println("Loop dates " + formattedDate);
			
			}
		}
		
		/* Recalculate the correct opened date */
		Date todaydate = new Date();
	    System.out.println("Today's Date to populate...." + df.format(todaydate));
	    
		CurrentDateCal = Utilities.toCalendar(todaydate); //CD
		CurrentDatePlus2Cal = Utilities.addWorkDays(CurrentDateCal, 2);   //CD + 2
	    System.out.println("CD + 2: " + df.format(CurrentDatePlus2Cal.getTime()));
	    
	    openedDateTempCal = Utilities.addWorkDays(CurrentDatePlus2Cal, -9); //go back 9 working day
	    System.out.println("openedDateTempCal: " + df.format(openedDateTempCal.getTime()));
	    
		
		return openedDateTempCal;
		//return (addWorkDays(date, -10));
		
	}
	
	
	
	
	
	
	
	/* ********* RED Status ********** */
	
	public static Calendar TraverseThroughDatesForNonBankHoliday_RED(Calendar date) throws ParseException
	{
		String[] HOLIDAYS_OF_YEAR = {"02/01/2017", "14/04/2017", "17/04/2017", "01/05/2017", "29/05/2017", "28/08/2017", "25/12/2017", "26/12/2017"};
		
		int i=1;
		int count = 0;
		Calendar finaldate= null;
		Calendar tempdate= date;
		Calendar FinalDate= date;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar CurrentDateCal = null;
		Calendar CurrentDatePlus1Cal = null;
		Calendar openedDateCal = null;
		Calendar openedDateTempCal = null;
		
		String formattedDate = df.format(date.getTime());
		System.out.println("formattedDate beginning...." + formattedDate);
		
		tempdate = date; //29
		
		String tempdateSave= df.format(date.getTime());
		
		// if end date falls on the actual BH date
//		if (formattedDate.equals("02/01/2017") || formattedDate.equals("14/04/2017") || formattedDate.equals("17/04/2017") || formattedDate.equals("01/05/2017") ||	formattedDate.equals("29/05/2017") ||formattedDate.equals("28/08/2017") || formattedDate.equals("25/12/2017") || formattedDate.equals("26/12/2017"))
			
			if (formattedDate.equals(HOLIDAYS_OF_YEAR[0]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[1]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[2]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[3]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[4]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[5]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[6]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[7]))
			{
			
			date = addWorkDays(date, -1);
    		
    		return date;

		}
		else
		{
		
			for(i=1; i<=12; i++)
			{
    	
				if (formattedDate.equals(HOLIDAYS_OF_YEAR[0]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[1]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[2]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[3]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[4]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[5]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[6]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[7]))
			{	
					count = count + 1;
					
					Date todaydate = new Date();
				    System.out.println("Today's Date to populate...." + df.format(todaydate));
				    
					CurrentDateCal = Utilities.toCalendar(todaydate); //CD
					CurrentDatePlus1Cal = Utilities.addWorkDays(CurrentDateCal, 1);   //CD + 1
				    System.out.println("CD + 1: " + df.format(CurrentDatePlus1Cal.getTime()));
				    
				    openedDateTempCal = Utilities.addWorkDays(CurrentDatePlus1Cal, -9); //go back 9 working day
				    System.out.println("openedDateTempCal: " + df.format(openedDateTempCal.getTime()));
				    
				    
				date = addWorkDays(openedDateTempCal, -count);
	    		
	    		System.out.println("New adjusted date................. " + df.format(date.getTime()));
	    		
	    		return date;

    		}
			
				tempdate.add(Calendar.DATE, 1);

				formattedDate = df.format(tempdate.getTime());
			
			System.out.println("Loop dates " + formattedDate);
			
			}
		}
		
		/* Recalculate the correct opened date */
		Date todaydate = new Date();
	    System.out.println("Today's Date to populate...." + df.format(todaydate));
	    
		CurrentDateCal = Utilities.toCalendar(todaydate); //CD
		CurrentDatePlus1Cal = Utilities.addWorkDays(CurrentDateCal, 1);   //CD + 1
	    System.out.println("CD + 1: " + df.format(CurrentDatePlus1Cal.getTime()));
	    
	    openedDateTempCal = Utilities.addWorkDays(CurrentDatePlus1Cal, -9); //go back 9 working day
	    System.out.println("openedDateTempCal: " + df.format(openedDateTempCal.getTime()));
	    
		
		return openedDateTempCal;
		//return (addWorkDays(date, -10));
		
	}
	
	
	
	
	
	/* ********* GREEN Status ********** */
	
	public static Calendar TraverseThroughDatesForNonBankHoliday_GREEN(Calendar date) throws ParseException
	{
		String[] HOLIDAYS_OF_YEAR = {"02/01/2017", "14/04/2017", "17/04/2017", "01/05/2017", "29/05/2017", "28/08/2017", "25/12/2017", "26/12/2017"};
		
		int i=1;
		int count = 0;
		Calendar finaldate= null;
		Calendar tempdate= date;
		Calendar FinalDate= date;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar CurrentDateCal = null;
		Calendar CurrentDatePlus5Cal = null;
		Calendar openedDateCal = null;
		Calendar openedDateTempCal = null;
		
		String formattedDate = df.format(date.getTime());
		System.out.println("formattedDate beginning...." + formattedDate);
		
		tempdate = date; //29
		
		String tempdateSave= df.format(date.getTime());
		
		// if end date falls on the actual BH date
//		if (formattedDate.equals("02/01/2017") || formattedDate.equals("14/04/2017") || formattedDate.equals("17/04/2017") || formattedDate.equals("01/05/2017") ||	formattedDate.equals("29/05/2017") ||formattedDate.equals("28/08/2017") || formattedDate.equals("25/12/2017") || formattedDate.equals("26/12/2017"))
			
			if (formattedDate.equals(HOLIDAYS_OF_YEAR[0]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[1]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[2]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[3]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[4]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[5]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[6]) || 
					formattedDate.equals(HOLIDAYS_OF_YEAR[7]))
			{
			
			date = addWorkDays(date, -1);
    		
    		return date;

		}
		else
		{
		
			for(i=1; i<=12; i++)
			{
    	
				if (formattedDate.equals(HOLIDAYS_OF_YEAR[0]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[1]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[2]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[3]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[4]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[5]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[6]) || 
						formattedDate.equals(HOLIDAYS_OF_YEAR[7]))
			{	
					count = count + 1;
					
					Date todaydate = new Date();
				    System.out.println("Today's Date to populate...." + df.format(todaydate));
				    
					CurrentDateCal = Utilities.toCalendar(todaydate); //CD
					CurrentDatePlus5Cal = Utilities.addWorkDays(CurrentDateCal, 5);   //CD + 5
				    System.out.println("CD + 5: " + df.format(CurrentDatePlus5Cal.getTime()));
				    
				    openedDateTempCal = Utilities.addWorkDays(CurrentDatePlus5Cal, -9); //go back 9 working day
				    System.out.println("openedDateTempCal: " + df.format(openedDateTempCal.getTime()));
				    
				    
				date = addWorkDays(openedDateTempCal, -count);
	    		
	    		System.out.println("New adjusted date................. " + df.format(date.getTime()));
	    		
	    		return date;

    		}
			
				tempdate.add(Calendar.DATE, 1);

				formattedDate = df.format(tempdate.getTime());
			
			System.out.println("Loop dates " + formattedDate);
			
			}
		}
		
		/* Recalculate the correct opened date */
		Date todaydate = new Date();
	    System.out.println("Today's Date to populate...." + df.format(todaydate));
	    
		CurrentDateCal = Utilities.toCalendar(todaydate); //CD
		CurrentDatePlus5Cal = Utilities.addWorkDays(CurrentDateCal, 5);   //CD + 5
	    
	    openedDateTempCal = Utilities.addWorkDays(CurrentDatePlus5Cal, -9); //go back 9 working day
	    System.out.println("openedDateTempCal: " + df.format(openedDateTempCal.getTime()));
	    
		
		return openedDateTempCal;
		//return (addWorkDays(date, -9));
		
	}
	
	
	
	public static Date addBusinessDays(Date baseDate, int numberOfDays){

	    if(baseDate == null){
	        baseDate = new Date();
	    }

	    Calendar baseDateCal = Calendar.getInstance();
	    baseDateCal.setTime(baseDate);

	    for(int i = 0; i < numberOfDays; i++){

	        baseDateCal.add(Calendar.DATE,1);
	        if(baseDateCal.get(Calendar.DAY_OF_WEEK)
	                         == Calendar.SATURDAY){
	           baseDateCal.add(Calendar.DATE,2);
	        }
	    }
	    return baseDateCal.getTime();
	}
	
	
//	public Calendar addBusinessDate(Calendar cal, int numBusinessDays) {
//		  int numNonBusinessDays = 0;
//		  String holidays = "28/08/2017";
//
//		  for(int i = 0; i < numBusinessDays; i++) {
//		    cal.add(Calendar.DATE, 1);
//
//		    /*
//		       It's a Canadian/American custom to get the Monday (sometimes Friday) off
//		       when a holiday falls on a weekend.
//		    */
//		    for(int j = 0; j < holidays; j++) { //holidays is list of dates
//		      if(cal.getTime() == (Date)holidays.get(j)) {
//		        numNonBusinessDays++;
//		      }
//		    }
//
//		    if(cal.get(Calendar.DAY_OF_WEEK) == 1 ||
//		       cal.get(Calendar.DAY_OF_WEEK) == 7) {
//		      numNonBusinessDays++;
//		    }
//		  }
//
//		  if(numNonBusinessDays > 0) {
//		    cal.add(Calendar.DATE, numNonBusinessDays);
//		  }
//
//		  return cal;
//		}
//	
	
//    System.out.println("aa " + df.format(resultDate.getTime()));
//    
//    Calendar calTemp = Calendar.getInstance();
//    calTemp = resultDate;
//    
//    int count=0;
//    int i =1;
//    //String formatted = null;
//    //for (int i=1; i<=days; i++)
//    while (i <= (Math.abs(days) + 3))
//    {
//    	String formatted = df.format(resultDate.getTime()); 
//    	//formatted = df.format(calTemp.getTime());
//    	
//    	if (formatted.contains("28/08/2017"))
//    	{
//    		Calendar c = toCalendar(df.parse(df.format(calTemp.getTime())));
//
//    		//addWorkDays(c, -1);
//
//    	}
//    	i++;
//    	calTemp.add(Calendar.DATE, 1);
//    	
//    }
    
    
	//a = days -1;
	//resultDate = resultDate.minusDays(300).toDate();
    
    
    
    
    
//    calTemp.add(Calendar.DATE, -1); // decrease on day
//    System.out.println("decreased day by 1 " + calTemp.getTime());
//    
//    //Date dateNeeded = resultDate.getTime(); // convert calender to date format
//    
//    System.out.println("resultDate: " + resultDate.getTime());
//    
//    String formatted = df.format(resultDate.getTime());
//    System.out.println("formatted " + formatted);
//    
//
//    /* Calculate no of working days between two dates */
//    Date date1 = baseDate.getTime(); 
//    Date date2 = resultDate.getTime();
//    
//    int a = getWorkingDaysBetweenTwoDates(date1,date2);
//    System.out.println("No of working days between two dates :"+ a);
//    
//    int counter=0;
//    for (int i=1; i<=a; i++)
//    {
//    	if (formatted.equals("28/08/2017"))
//    	{
//    		a = days -1;
//    		resultDate = resultDate.minusDays(300).toDate();
//    	}
//    	
//    }
   
    
//    /* if the resultDate falls on the bank holiday */
//    
//    if (formatted.contains("28/08/2017")) /* August Bank Holiday */
//    {
//    	Calendar c = toCalendar(df.parse(formatted));
//    
//    	addWorkDays(c, -1);
//    }
	
	
	
	public static Calendar toCalendar(Date date)
	{ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
		
	}
	
	
	
	public static int calculateDuration(Date startDate, Date endDate)
	{
		
		String HOLIDAYS_OF_YEAR = "28/08/2017";
		
	  Calendar startCal = Calendar.getInstance();
	  startCal.setTime(startDate);

	  Calendar endCal = Calendar.getInstance();
	  endCal.setTime(endDate);

	  int workDays = 0;

	  if (startCal.getTimeInMillis() > endCal.getTimeInMillis())
	  {
	    startCal.setTime(endDate);
	    endCal.setTime(startDate);
	  }

	  do
	  {
	    startCal.add(Calendar.DAY_OF_MONTH, 1);
	    if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && 
	    		startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY )
	    {
	      workDays++;
	    }
	  }
	  while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

	  return workDays;
	  
	}
	
	
	
	
	

//	 public Date addDays(Date date, int days)
//	 {
//	        Calendar cal = Calendar.getInstance();
//	        cal.setTime(date);
//	        cal.add(Calendar.DATE, days); //minus number would decrement the days
//	        
//	        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
//	        	    cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
//	        {
//	        	System.out.println(theDateFormat.format(cal.getTime()));
//	        }
//	        
//	        return cal.getTime();
//	 
//	 }
	 
	 
	 
	 


//		 public void SubtractingNWorkingDays() {
//
//		  Scanner input = null;
//		  try {
//		   input = new Scanner(System.in);
//		   System.out.println("Enter number of working days : ");
//		   int limit = input.nextInt();
//		   int orignalLimit = limit;
//		   // Create Calendar class instance
//		   Calendar calendar = Calendar.getInstance();
//		   System.out.println("Current Date : " + calendar.getTime());
//		   for (int i = 1; i <= limit; i++) {
//		    // Subtracting 1 day from calendar.
//		    calendar.add(Calendar.DAY_OF_MONTH, -1);
//		    /*
//		     * calendar.get(Calendar.DAY_OF_WEEK) = 1 (Sunday)
//		     * calendar.get(Calendar.DAY_OF_WEEK) = 7 (Saturday)
//		     * 
//		     * If day is either Sunday or Saturday then it is non working
//		     * day so Increasing the limit to compensate working days.
//		     */
//		    if ( calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7) {
//		     limit++;
//		    }
//		   }
//		   System.out.println("Before " + orignalLimit + " working day/s Date : " + calendar.getTime());
//		  } finally {
//		   if (input != null) {
//		    input.close();
//		   }
//		  }
//
//		 }
		 
		 
		 
		 
		 
		 
		 
	//Calendar c = toCalendar(df.parse(df.format(enddate.getTime())));

//	Calendar newdate = enddate;
//	
//	newdate.add(Calendar.DATE, -1);
//	
//	if (newdate.DAY_OF_WEEK == Calendar.SUNDAY)
//	{
//		newdate.add(Calendar.DATE, -2);
//	}
	
//	//formatted = df.format(calTemp.getTime());
//	while (i <= 8)
//	{
//	
//		if (formatted_enddate.contains("28/08/2017"))
//		{
//    		//Calendar c = toCalendar(df.parse(df.format(enddate.getTime())));
//			
//			
//    		
////    		Calendar newdate = enddate;
////    		
////    		newdate.add(Calendar.DATE, -1);
////    		
////    		if (newdate.DAY_OF_WEEK == Calendar.SUNDAY)
////    		{
////    			newdate.add(Calendar.DATE, -2);
////    		}
//    		
//
//    		Calendar newdate = addWorkDays(enddate, -1);
//    		
//    		System.out.println("New End Date................. " + df.format(newdate.getTime()));
//
//		}
//		
//		//System.out.println("Current date being checked is " + df.format(enddatetemp.getTime()));
//		
//		enddatetemp.add(Calendar.DATE, 1);
//		//System.out.println("New End Date + 1 " + df.format(enddatetemp.getTime()));
//		
//		formatted_enddate = df.format(enddatetemp.getTime());
//		System.out.println("New End Date + 1 " + formatted_enddate);
//
//		i++;
//	   	
//	}
	
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 private static  String[] HOLIDAYS_OF_YEAR = {"02/11","02/07","26/12","25/12" };
	      
	      public static void findNextWorkingDay(Calendar cal , int no) {
	    	  
	                  cal.add(Calendar.DAY_OF_WEEK, -no);
	                  
	                  int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	                  
	                  switch (dayOfWeek) {
	                  case Calendar.SUNDAY:
	                        findNextWorkingDay(cal,2);
	                        break;
	                  case Calendar.SATURDAY:
	                        cal.add(Calendar.DAY_OF_WEEK,1);
	                        findNextWorkingDay(cal,1);
	                        break;
	                  default:
	                        int holidayMonth = -1;
	                        int holidayDayOfMonth = -1;
	                        for (String holiday : HOLIDAYS_OF_YEAR) {
	                              holidayMonth = Integer.parseInt(holiday.substring(0, 2)) - 1;
	                              holidayDayOfMonth = Integer.parseInt(holiday.substring(3));
	                              if (cal.get(Calendar.MONTH) == holidayMonth
	                                          && cal.get(Calendar.DAY_OF_MONTH) == holidayDayOfMonth) {
	                                    findNextWorkingDay(cal,1);
	                              }
	                        }
	                        break;
	                  }
	            }
	      
	      
	      
	      public static String DATE_IN_CONSIDERATION = "06/09/2017";
	      public static String DATE_FORMAT = "dd/MM/yyyy";
		  
	  
	      public void demo (){
	    	  
	      
	        try {
	              DateFormat theDateFormat = new SimpleDateFormat(DATE_FORMAT);
	              Date date1 = theDateFormat.parse(DATE_IN_CONSIDERATION);
	              Calendar cal = Calendar.getInstance();
	              cal.setTime(date1);
	              findNextWorkingDay(cal,4);

	              System.out.println(theDateFormat.format(cal.getTime()));                
	              } catch (ParseException ex) {
	              ex.printStackTrace();
	        }
	        
	      }

		
	
	      
	      
	      
	      
	      
	      public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
	    	    Calendar startCal = Calendar.getInstance();
	    	    startCal.setTime(startDate);        

	    	    Calendar endCal = Calendar.getInstance();
	    	    endCal.setTime(endDate);

	    	    int workDays = 0;

	    	    //Return 0 if start and end are the same
	    	    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	    	        return 0;
	    	    }

	    	    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	    	        startCal.setTime(endDate);
	    	        endCal.setTime(startDate);
	    	    }

	    	    do {
	    	       //excluding start date
	    	        startCal.add(Calendar.DAY_OF_MONTH, 1);
	    	        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	    	            ++workDays;
	    	        }
	    	    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date

	    	    return workDays;
	    	}


}
