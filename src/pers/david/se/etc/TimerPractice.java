package pers.david.se.etc;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class TimerPractice {

    public TimerPractice() {
        // TODO Auto-generated constructor stub
    }


    @Test
    public void f1() {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask1(), 2000);
    }

    static class MyTimerTask1 extends TimerTask {
        public void run() {
            System.out.println("run");
        }
    }

    @Test
    public void test2() {
        String messagePattern = "开始时间{0} 结束时间{1} 时间差{2}";
        String message;
        Calendar srartCalendar, endCalendar;
        Date startDate, endDate;
        String timesBetween;
        int loop = 100000;
        String str = "";
        StringBuffer sb = new StringBuffer("");
        StringBuilder sbd = new StringBuilder("");
        srartCalendar = Calendar.getInstance();
        startDate = srartCalendar.getTime();
        for (int i = 0; i < loop; i++) {
//			str=str+i;
//			sb.append(i);
            sbd.append(i);
        }
        endCalendar = Calendar.getInstance();
        endDate = endCalendar.getTime();
        timesBetween = endDate.getTime() - startDate.getTime() + "毫秒";
        message = MessageFormat.format(messagePattern, startDate, endDate, timesBetween);
        System.out.println(message);
    }

}
