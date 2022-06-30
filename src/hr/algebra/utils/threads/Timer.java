package hr.algebra.utils.threads;

import javafx.application.Platform;

public class Timer extends Thread {

    private final int timeout;
    private final TimerLabelSetter timerLabelSetter;
    private final Runnable whenTimerIsDone;

    public Timer(TimerLabelSetter timerLabelSetter, int timeout, Runnable whenTimerIsDone) {
        this.timeout = timeout;
        this.timerLabelSetter = timerLabelSetter;
        this.whenTimerIsDone = whenTimerIsDone;
    }

    @Override
    public void run() {
        for (int i = timeout; i >= 0; i--){
            sendTime(i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                System.out.println("interrupted");
                return;
            }
        }
        Platform.runLater(whenTimerIsDone);
    }

    private void sendTime(int time) {
        Platform.runLater(() -> timerLabelSetter.setTime(time + "s"));
    }
}
