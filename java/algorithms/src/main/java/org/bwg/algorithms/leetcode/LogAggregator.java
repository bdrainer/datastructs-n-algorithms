package org.bwg.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LogAggregator {

    private int machines;
    private int services;

    private Map<Integer, List<LogModel>> machineLog;
    private Map<Integer, List<LogModel>> serviceLog;

    public LogAggregator(int machines, int services) {
        this.machines = machines;
        this.services = services;

        this.machineLog = new ConcurrentHashMap<>();
        this.serviceLog = new ConcurrentHashMap<>();
    }

    public void pushLog(int logId, int machineId, int serviceId, String message) {
        LogModel logModel = new LogModel(logId, message);

        if (!machineLog.containsKey(machineId)) {
            machineLog.put(machineId, new ArrayList<>());
        }
        if (!serviceLog.containsKey(serviceId)) {
            serviceLog.put(serviceId, new ArrayList<>());
        }

        machineLog.get(machineId).add(logModel);
        serviceLog.get(serviceId).add(logModel);
    }

    public List<Integer> getLogsFromMachine(int machineId) {
        if (machineLog.containsKey(machineId)) {
            return machineLog.get(machineId).stream()
                    .map(logModel -> logModel.logId)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    public List<Integer> getLogsOfService(int serviceId) {
        if (serviceLog.containsKey(serviceId)) {
            return serviceLog.get(serviceId).stream()
                    .map(logModel -> logModel.logId)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    public List<String> search(int serviceId, String searchString) {
        if (serviceLog.containsKey(serviceId)) {
            return serviceLog.get(serviceId).stream()
                    .filter(logModel -> logModel.message.contains(searchString))
                    .map(logModel -> logModel.message)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    static class LogModel {
        int logId;
        String message;

        LogModel(int logId, String message) {
            this.logId = logId;
            this.message = message;
        }
    }
}
