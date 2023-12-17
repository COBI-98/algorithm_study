class Solution {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        int bell1 = makeAlarm(h1, m1, s1);
        int bell2 = makeAlarm(h2, m2, s2);

        int result = bell2 - bell1;
        
        if ((h1 == 12 || h1 == 0) && m1 == 0 && s1 == 0) {
            result++;
        }

        return result;

    }

    public static int makeAlarm(int h, int m, int s) {

        int bell = -1;

        double hDeg = (h * 30 + m * 0.5 + s * 0.5 / 60) % 360;
        double mDeg = (m * 6 + s * 0.1) % 360;
        double sDeg = s * 6 % 360;

        if (sDeg >= hDeg) {
            bell++;
        }
        if (sDeg >= mDeg) {
            bell++;
        }

        bell += (m + h * 60) * 2;

        bell -= h;

        if (h >= 12) {
            bell -= 2;
        }

        return bell;
    }
}