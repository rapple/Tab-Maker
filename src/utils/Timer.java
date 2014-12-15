package utils;

import scripts.Curser.Main;

public class Timer {

    private static long pauseTime = 0;

    public Timer() {
        Main.startTime = System.currentTimeMillis();
    }

    public static long getTimeElapsed() {
        return pauseTime == 0 ? System.currentTimeMillis() - Main.startTime
                : pauseTime - Main.startTime;
    }

    public static long getSecondsElapsed() {
        return getTimeElapsed() / 1000 % 60;
    }

    public static long getMintuesElapsed() {
        return getTimeElapsed() / 1000 / 60 % 60;
    }

    public static long getHoursElapsed() {
        return getTimeElapsed() / 1000 / 60 / 60 % 24;
    }

    public static long getDaysElapsed() {
        return getTimeElapsed() / 1000 / 60 / 60 / 24 % 7;
    }

    public static void reset() {
        Main.startTime = System.currentTimeMillis();
        pauseTime = 0;
    }

    public static String getFormattedTime() {
        return getDaysElapsed() > 0 ? "" + getDaysElapsed() + ":"
                + getHoursElapsed() + ":" + getMintuesElapsed() + ":"
                + getSecondsElapsed() + "" : getHoursElapsed() + ":"
                + getMintuesElapsed() + ":" + getSecondsElapsed();
    }

    public static void pause() {
        pauseTime = System.currentTimeMillis();
    }

    public static void resume() {
        if (isPaused()) {
            long timePaused = (System.currentTimeMillis() - pauseTime) + 1000;
            System.out.println("Time Paused: " + timePaused);
            Main.startTime = System.currentTimeMillis() - timePaused;
            pauseTime = 0;
        }
    }

    public static long calculatePerHour(long gained) {
        return (gained * 3600000) / getTimeElapsed();
    }

    public static boolean isPaused() {
        return pauseTime > 0;
    }


}