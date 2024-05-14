package com.ziker0k.lesson25.homework;

import com.ziker0k.lesson25.homework.model.RobotDetail;
import com.ziker0k.lesson25.homework.model.Scientist;
import com.ziker0k.lesson25.homework.thread.Factory;
import com.ziker0k.lesson25.homework.thread.Night;
import com.ziker0k.lesson25.homework.thread.ScientistAssistant;
import com.ziker0k.lesson25.homework.util.RandomUtil;
import com.ziker0k.lesson25.homework.util.ThreadUtil;

import java.util.List;
import java.util.stream.IntStream;

public class FactoryDemo {
    public static void main(String[] args) throws InterruptedException {
        var night = new Night();
        var factory = new Factory(night, getInitialRobotDetailsInDump());
        var goodAssistant = new ScientistAssistant(
                new Scientist("ScientistWithGoodAssistant"), factory.getDump(), night);
        var badAssistant = new ScientistAssistant(
                new Scientist("ScientistWithBadAssistant"), factory.getDump(), night);

        ThreadUtil.startThreads(night, factory, goodAssistant, badAssistant);
        ThreadUtil.joinThreads(night, factory, goodAssistant, badAssistant);

        viewStatistics(goodAssistant.getScientist(), badAssistant.getScientist());
    }

    private static List<RobotDetail> getInitialRobotDetailsInDump() {
        return IntStream.range(0, 20)
                .map(value -> RandomUtil.getNext(RobotDetail.CASHED_VALUES.size()))
                .mapToObj(RobotDetail.CASHED_VALUES::get)
                .toList();
    }

    public static void viewStatistics(Scientist firstScientist, Scientist secondScientist) {
        System.out.println("-----------------------------");
        System.out.println(firstScientist.getName() + " built " + firstScientist.buildRobots().size() + " robots.");
        System.out.println(secondScientist.getName() + " built " + secondScientist.buildRobots().size() + " robots.");
        System.out.println("-----------------------------");
    }
}
