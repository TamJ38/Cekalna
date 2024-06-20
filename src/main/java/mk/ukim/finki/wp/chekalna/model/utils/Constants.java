package mk.ukim.finki.wp.chekalna.model.utils;

import java.time.DayOfWeek;
import java.util.Map;

public class Constants {
    public static Map<DayOfWeek, String> dayOfWeekMap = Map.of(
            DayOfWeek.MONDAY, "Понеделник",
            DayOfWeek.TUESDAY, "Вторник",
            DayOfWeek.WEDNESDAY, "Среда",
            DayOfWeek.THURSDAY, "Четврток",
            DayOfWeek.FRIDAY, "Петок",
            DayOfWeek.SATURDAY, "Сабота",
            DayOfWeek.SUNDAY, "Недела"
    );
}
