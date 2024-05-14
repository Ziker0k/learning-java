package com.ziker0k.lesson25.homework.thread;

import com.ziker0k.lesson25.homework.model.Dump;
import com.ziker0k.lesson25.homework.model.RobotDetail;
import com.ziker0k.lesson25.homework.model.Scientist;
import com.ziker0k.lesson25.homework.util.NightConst;
import com.ziker0k.lesson25.homework.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class ScientistAssistant extends Thread {
    private final static int MAX_ROBOT_DETAILS_COUNT = 4;
    private final Scientist scientist;
    private final Dump dump;
    private final Night night;

    public ScientistAssistant(Scientist scientist, Dump dump, Night night) {
        this.scientist = scientist;
        this.dump = dump;
        this.night = night;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < NightConst.AMOUNT_OF_NIGHT; i++) {
                List<RobotDetail> robotDetails = grabRobotDetailsFromFactory();
                scientist.addRobotDetails(robotDetails);
                waitNextNight();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<RobotDetail> grabRobotDetailsFromFactory() {
        int detailsCount = RandomUtil.getNextWithoutZero(MAX_ROBOT_DETAILS_COUNT);
        List<RobotDetail> grabbedRobotDetails = new ArrayList<>();

        synchronized (dump.getLock()) {
            if (dump.isNotEmpty() && dump.size() < detailsCount)
                grabbedRobotDetails.addAll(dump.removeAll());
            else if (dump.isNotEmpty()) {
                for (int i = 0; i < detailsCount; i++) {
                    grabbedRobotDetails.add(dump.remove(RandomUtil.getNext(dump.size())));
                }
            }
            System.out.printf("""
                    %s's assistant grabbed next details: %s
                    """, scientist.getName(), grabbedRobotDetails);
        }
        return grabbedRobotDetails;
    }

    private void waitNextNight() throws InterruptedException {
        synchronized (night.getLock()) {
            night.getLock().wait();
        }
    }

    public Scientist getScientist() {
        return scientist;
    }
}
