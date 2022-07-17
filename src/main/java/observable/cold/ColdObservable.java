package observable.cold;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ColdObservable {
    public static void main(String[] args) throws Exception {
        Observable src = Observable.interval(1, TimeUnit.SECONDS);
        src.subscribe(value -> System.out.println("#1: " + value));
        Thread.sleep(3000);
        src.subscribe(value -> System.out.println("#2: " + value));
        Thread.sleep(3000);
    }
}
