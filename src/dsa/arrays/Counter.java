package algo.array;

import algo.utils.ConsolePrinter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Counter {

    LinkedList<FixedCount> timeStampCount  = new LinkedList<>();
    private List<Event> events = new ArrayList<>();
    private final Duration fixedWindowDuration;
    private final Duration slidingWindowDuration;
    int totalCount = 0;

    public Counter(Duration fixedWindowDuration, Duration slidingWindowDuration) {
        if(fixedWindowDuration.getSeconds() <= 0 || slidingWindowDuration.getSeconds() <= 0) {
            throw new IllegalArgumentException("Invalid window");
        }
        if(fixedWindowDuration.compareTo(slidingWindowDuration) > 0) {
            throw new IllegalArgumentException("Sliding window must be greater than fixed window");
        }
        this.fixedWindowDuration = fixedWindowDuration;
        this.slidingWindowDuration = slidingWindowDuration;
    }

    public void incrementByOne() {
        long currentTime = System.currentTimeMillis();
        events.add(new Event(Type.INC, currentTime));
        if(timeStampCount.isEmpty()) {
            timeStampCount.add(new FixedCount(currentTime, currentTime + fixedWindowDuration.toMillis(), 1));
        } else {
            if(timeStampCount.getLast().maxTime > currentTime) {
                timeStampCount.getLast().incr(1);
            } else {
                timeStampCount.add(new FixedCount(currentTime, currentTime + fixedWindowDuration.toMillis(), 1) );
            }
        }
        incrTotal();
    }

    private void incrTotal() {
        totalCount = totalCount + 1;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void consumeState(Consumer<FixedCount> consumer) {
        Iterator<FixedCount> iterator = timeStampCount.iterator();
        while(iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }


    public int getValue() {
        long requestTime = System.currentTimeMillis();
        events.add(new Event(Type.GET_VAL, requestTime));
        int sum = totalCount;
        while(!timeStampCount.isEmpty()) {
            FixedCount first = timeStampCount.getFirst();
            if(isWithinDuration(first,requestTime)) {
               return sum;
            } else {
                sum = sum - first.count;
                timeStampCount.removeFirst();
            }
        }
        return sum;
    }

    public boolean isWithinDuration(FixedCount fixedCount, long requestedTime) {
        Duration timeInterval = Duration.ofMillis(requestedTime - fixedCount.startTime);
        return timeInterval.compareTo(slidingWindowDuration) <= 0;
    }

    // 1 2 3 4 5 6 7 8 9 10 14

    public static void main(String[] args) throws InterruptedException {
       Counter counter = new Counter(Duration.ofSeconds(1), Duration.ofSeconds(5));
       for(int i=0; i < 100; i++) {
           counter.incrementByOne();
          Thread.sleep((int)(Math.random()*200));
       }
       counter.consumeState(System.out::println);
       Thread.sleep(2000);
       System.out.println(counter.getValue());
        counter.consumeState(System.out::println);
        ConsolePrinter.out(counter.getEvents().size() + " total events received");
       counter.getEvents().stream().forEach(System.out::println);

    }

    private static class FixedCount {
        long startTime;
        long maxTime;
        int count = 0;

        public FixedCount(long startTime, long maxTime, int i) {
            this.startTime = startTime;
            this.maxTime = maxTime;
            this.count = i;
        }

        public void incr(int val) {
            count = count + val;
        }

        @Override
        public String toString() {
            return "FixedCount{" +
                    "startTime=" + startTime +
                    ", maxTime=" + maxTime +
                    ", count=" + count +
                    '}';
        }
    }

    public enum Type {
        INC, GET_VAL;
    }

    private static class Event {
        Type type;
        long time;

        public Event(Type type, long time) {
            this.type = type;
            this.time = time;
        }

        public String toString() {
            return type + " " + time;
        }
    }

}
