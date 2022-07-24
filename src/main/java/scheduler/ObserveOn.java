package scheduler;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class ObserveOn {
    public static void main(String[] args) throws Exception{
        Observable<Integer> src = Observable.create(emitter -> {
            for (int i = 0; i < 3; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println("#Subs on " + threadName + ": " + i);
                emitter.onNext(i);
                Thread.sleep(100);
            }
            emitter.onComplete();
        });

        src.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(s -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("#Obsv on " + threadName + ": " + s);
                });
        Thread.sleep(500);

        Observable.interval(200, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(value -> System.out.println(Thread.currentThread().getName() + ":"+value));
        Thread.sleep(1000);
    }
}
