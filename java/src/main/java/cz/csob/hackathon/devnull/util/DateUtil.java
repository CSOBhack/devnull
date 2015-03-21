package cz.csob.hackathon.devnull.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

public class DateUtil {

	private static final FastDateFormat CZECH_DATE = FastDateFormat.getInstance("dd.MM.yyyy");
	private static final FastDateFormat CZECH_DATE_SHORT = FastDateFormat.getInstance("dd.MM.yy");
	private static final FastDateFormat CZECH_DATE_TIME = FastDateFormat.getInstance("dd.MM.yyyy HH:mm:ss");
	private static final FastDateFormat CZECH_DATE_TIME_DASH = FastDateFormat.getInstance("dd-MM-yyyy HH:mm:ss");
	private static final SimpleDateFormat TIMEZONE_DATETIME = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.0000000XXX");
	private static final FastDateFormat DATE_TIME = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
	private static final FastDateFormat DATE = FastDateFormat.getInstance("yyyy-MM-dd");
	private static final FastDateFormat CZECH_DATE_TIME_TINY = FastDateFormat.getInstance("dd.MM. HH:mm");
	private static final FastDateFormat CZECH_DATE_SLASH_SHORT = FastDateFormat.getInstance("dd/MM/yy");
	private static final FastDateFormat CZECH_TIME_FULL = FastDateFormat.getInstance("HH:mm:ss");
	private static final FastDateFormat CZECH_TIME_TINY = FastDateFormat.getInstance("HH:mm");
	private static final FastDateFormat CZECH_DATE_TINY = FastDateFormat.getInstance("ddMMyyyy");
	private static final FastDateFormat CZECH_DATE_SLASHES = FastDateFormat.getInstance("dd/MM/yyyy");
	private static final FastDateFormat CZECH_DATE_TIME_FN = FastDateFormat.getInstance("ddMMyyyy_HHmm");
	private static final FastDateFormat ENG_DATE_TIME_SLASHES = FastDateFormat.getInstance("yyyy/MM/dd HH:mm");
	private static final FastDateFormat ENG_DATE_SLASHES = FastDateFormat.getInstance("yyyy/MM/dd");
	private static final FastDateFormat DAY_NUMBER = FastDateFormat.getInstance("d");
	private static final FastDateFormat DAY_MONTH = FastDateFormat.getInstance("d.M.");

	public static String toEngDate(Date date) {
		return DATE.format(date);
	}

	public static String toCzechDate(Date date) {
		return CZECH_DATE.format(date);
	}

	public static String toCzechDateTime(Date date) {
		try {
			return CZECH_DATE_TIME.format(date);
		} catch (NullPointerException e) {
			return "";
		}
	}

	public static String toCzechDateTimeTiny(Date date) {
		try {
			return CZECH_DATE_TIME_TINY.format(date);
		} catch (NullPointerException e) {
			return "";
		}
	}

	public static String toCzechDateTimeToFiles(Date date) {
		try {
			return CZECH_DATE_TIME_FN.format(date);
		} catch (NullPointerException e) {
			return "";
		}
	}

	public static String toCzechStrTimeTiny(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar today = Calendar.getInstance();
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);

		if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)) {
			return "dnes v " + CZECH_TIME_TINY.format(date);
		} else if (calendar.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == yesterday.get(Calendar.DAY_OF_YEAR)) {
			return "včera v " + CZECH_TIME_TINY.format(date);
		} else {
			return CZECH_DATE_TIME_TINY.format(date);
		}
	}

	public static String toCzechTimeFull(Date date) {
		return CZECH_TIME_FULL.format(date);
	}

	public static String toCzechDateTiny(Date date) {
		return CZECH_DATE_TINY.format(date);
	}

	public static String getDayNumber(Date date) {
		return DAY_NUMBER.format(date);
	}

	public static String getDayMonth(Date date) {
		return DAY_MONTH.format(date);
	}

	public static Date getDateDaysBefore(int numOfDaysBefore, Date fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		cal.add(Calendar.DAY_OF_MONTH, numOfDaysBefore * -1);
		return cal.getTime();
	}

	public static Date getDateFromNow(int millis) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MILLISECOND, millis);
		return cal.getTime();
	}

	public static Date getDateTimeFromEngSlashes(String dateTime) {
		if (dateTime == null || dateTime.isEmpty()) {
			return null;
		}
		try {
			return ENG_DATE_TIME_SLASHES.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getEngDateStrFromDate(Date date) {
		return ENG_DATE_SLASHES.format(date);
	}

	public static Date setTime(Date date, int hr, int min, int sec) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hr);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, sec);
		return cal.getTime();
	}

	public static Date getNextDateFromHourMinute(String hourMinute) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hourMinute.split(":")[0]));
		cal.set(Calendar.MINUTE, Integer.valueOf(hourMinute.split(":")[1]));
		cal.set(Calendar.SECOND, 0);

		Date d = cal.getTime();
		if (d.before(now) || d.equals(now)) {
			return DateUtils.addDays(d, 1);
		}
		return d;
	}

	public static Date toEngDate(String date) {
		if (date == null || date.trim().isEmpty()) {
			return null;
		}
		try {
			return DATE.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date toCzechDate(String date) {
		if (date == null || date.trim().isEmpty()) {
			return null;
		}
		if (date.contains(":") && date.contains("-")) {
			try {
				return CZECH_DATE_TIME_DASH.parse(date);
			} catch (ParseException e) {
				return null;
			}
		} else if (date.contains("/")) {
			try {
				return CZECH_DATE_SLASH_SHORT.parse(date);
			} catch (ParseException e) {
				try {
					return CZECH_DATE_SLASHES.parse(date);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			try {
				return CZECH_DATE_SHORT.parse(date);
			} catch (ParseException e) {
				try {
					return CZECH_DATE.parse(date);
				} catch (ParseException e2) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static Date toCzechDateTime(String date) {
		try {
			return CZECH_DATE_TIME.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date parseDateTime(String date) {
		try {
			return DATE_TIME.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date parseTimezoneDateTime(String date) {
		try {
			return TIMEZONE_DATETIME.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date parseDateMulti(String date) {
		try {
			return DATE.parse(date);
		} catch (ParseException e) {
			try {
				return CZECH_DATE_SLASH_SHORT.parse(date);
			} catch (ParseException e2) {
				try {
					return CZECH_DATE.parse(date);
				} catch (ParseException e3) {
					return null;
				}
			}
		}
	}

	public static Date parseDayMonth(String date, int addYear) {
		try {
			return CZECH_DATE.parse(date + addYear);
		} catch (ParseException e3) {
			return null;
		}
	}

	public static Date parseDayMonth(String date, boolean setThisYear) {
		try {
			Date d = DAY_MONTH.parse(date);
			if (setThisYear) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(d);
				cal.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
				return cal.getTime();
			}
			return d;
		} catch (ParseException e3) {
			return null;
		}
	}

	public static long getNumOfDaysFrom(Date d1) {
		return getNumOfDaysBetween(d1, new Date());
	}

	public static long getNumOfDaysBetween(Date d1, Date d2) {
		return daysBetween(dateToCalendar(d1), dateToCalendar(d2));
	}

	public static long daysBetween(Calendar startDate, Calendar endDate) {
		Calendar date = (Calendar) startDate.clone();
		long daysBetween = 0;
		while (date.before(endDate)) {
			date.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		return daysBetween;
	}

	public static Calendar dateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static Date combineDateTime(Date date, Date time) {
		if (date == null) {
			return null;
		}
		if (time == null) {
			return null;
		}
		String timeStr = CZECH_TIME_FULL.format(time);
		String dateStr = CZECH_DATE.format(date);
		String str = dateStr + " " + timeStr;
		return toCzechDateTime(str);
	}

	public static String getEngDayName(Date date) {
		return FastDateFormat.getInstance("EEEE", Locale.ENGLISH).format(date);
	}

	public static Date getDayInWeek(int dayOfWeek, Date weekDay) {
		Calendar c = Calendar.getInstance();
		c.setTime(weekDay);
		c.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		return c.getTime();
	}

	public static Date getDateMonthDiff(Date startDate, int monthDiff) {
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		c.add(Calendar.MONTH, monthDiff);
		return c.getTime();
	}

	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	public static Date getLastDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

}