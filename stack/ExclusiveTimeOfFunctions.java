package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class ExclusiveTimeOfFunctions {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        var result = new ExclusiveTimeOfFunctions().exclusiveTime(list.size(), list);
        printArray("ANSWER-", result);
    }

    ArrayDeque<Integer> executionStack;

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] et = new int[n];

        int curtime = 0;
        ArrayDeque<Log> stack = new ArrayDeque<Log>();
        Log curLog, stackTop;
        for (String logstr : logs) {
            curLog = new Log(logstr);

            if (curLog.eventId == 0) {
                stack.push(curLog);
            } else {
                // stop event
                stackTop = stack.pop();
                curtime = curLog.timestamp - stackTop.timestamp + 1;
                et[curLog.id] += curtime;

                // exhaustedTime = exhaustedTime + curtime;
                // AB next jo bhi pop hoga usme se jo
                // abhi pop hua uska time nikal do
                if (!stack.isEmpty()) {
                    et[stack.peek().id] -= curtime;
                }
            }
        }
        return et;
    }

    public static void printArray(String message, int arr[]) {
        StringBuilder sb = new StringBuilder();
        sb.append(message).append('=');
        sb.append('[');

        for (int a : arr) {
            sb.append(a).append(' ');
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

}

class Log {
    int id;
    // 1 for start , 0 for stop
    int eventId;
    int timestamp;

    public Log(String s) {
        String inputs[] = s.split(":");
        this.id = Integer.parseInt(inputs[0]);
        this.eventId = inputs[1].contentEquals("start") ? 0 : 1;
        this.timestamp = Integer.parseInt(inputs[2]);
    }

    @Override
    public String toString() {
        return "Log [id=" + id + ", eventId=" + eventId + ", timestamp=" + timestamp + "]";
    }

}
