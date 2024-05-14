package com.ziker0k.lesson25.homework.thread;

import com.ziker0k.lesson25.homework.model.Dump;
import com.ziker0k.lesson25.homework.model.RobotDetail;
import com.ziker0k.lesson25.homework.util.NightConst;
import com.ziker0k.lesson25.homework.util.RandomUtil;

import java.util.Collections;
import java.util.List;

public class Factory extends Thread {
    private static final int MAX_ROBOT_DETAILS_COUNT = 4;
    private final Night night;
    private final Dump dump;

    public Factory(Night night) {
        this(night, Collections.emptyList());
    }

    public Factory(Night night, List<RobotDetail> robotDetails) {
        this.night = night;
        this.dump = new Dump(robotDetails);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < NightConst.AMOUNT_OF_NIGHT; i++) {
                throwNewRobotDetails();
                waitNextNight();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void throwNewRobotDetails() {
        int countDetailsForThrowingToDump = RandomUtil.getNextWithoutZero(MAX_ROBOT_DETAILS_COUNT);
        synchronized (dump.getLock()) {
            for (int i = 0; i < countDetailsForThrowingToDump; i++) {
                int randomIndex = RandomUtil.getNext(RobotDetail.CASHED_VALUES.size());
                RobotDetail newRobotDetail = RobotDetail.CASHED_VALUES.get(randomIndex);
                dump.add(newRobotDetail);
            }
            System.out.printf("""
                    Factory threw out robot details. Count: %s.
                    """, countDetailsForThrowingToDump);
        }
    }

    private void waitNextNight() throws InterruptedException {
        synchronized (night.getLock()) {
            night.getLock().wait();
        }
    }

    public Dump getDump() {
        return dump;
    }
}
