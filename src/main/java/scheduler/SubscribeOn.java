package scheduler;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {
    public static void main(String[] args) throws Exception {
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
                .subscribe(s -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("#Obsv on " + threadName + ": " + s);
                });
        Thread.sleep(500);
    }
}
