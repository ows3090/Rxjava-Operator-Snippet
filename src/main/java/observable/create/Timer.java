package observable.create;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Timer {
    public static void main(String[] args) throws Exception{
        Observable src = Observable.timer(3, TimeUnit.SECONDS);
        System.out.println("구독!!");

        src.subscribe(event -> System.out.println("실행!"));
        Thread.sleep(5001);
    }
}
