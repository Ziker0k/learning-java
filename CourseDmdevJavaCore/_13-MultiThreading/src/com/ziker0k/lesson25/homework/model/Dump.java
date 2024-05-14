package com.ziker0k.lesson25.homework.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dump {
    private final List<RobotDetail> dump = new LinkedList<>();
    Object lock = new Object();

    public Dump() {
    }

    public Dump(List<RobotDetail> initialRobotsDetails) {
        dump.addAll(initialRobotsDetails);
    }

    public void add(RobotDetail robotDetail) {
        dump.add(robotDetail);
    }

    public RobotDetail remove(int index) {
        return dump.remove(index);
    }

    public List<RobotDetail> removeAll() {
        List<RobotDetail> robotDetails = new ArrayList<>(dump);
        dump.clear();
        return robotDetails;
    }

    public int size() {
        return dump.size();
    }

    public boolean isNotEmpty() {
        return !dump.isEmpty();
    }

    public Object getLock() {
        return lock;
    }
}
