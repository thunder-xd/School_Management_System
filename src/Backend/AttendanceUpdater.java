package Backend;

public class AttendanceUpdater {
    public static double updateAttendance(boolean isAbsent, int totalDays, int presentDays) {
        totalDays += 1;
        if (!isAbsent) {
            presentDays += 1;
        }
        double attendance = (double) presentDays / totalDays * 100.0;
        return attendance;
    }
}
