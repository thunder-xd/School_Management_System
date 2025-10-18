package Backend;

public class AttendanceUpdater {
    public static int updateAttendance(boolean isAbsent, int totalDays, int presentDays) {
        totalDays += 1;
        if (!isAbsent) {
            presentDays += 1;
        }
        return (int) Math.ceil((double) presentDays / totalDays * 100.0);
    }
}
