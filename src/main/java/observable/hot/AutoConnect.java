package observable.hot;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class AutoConnect {
    public static void main(String[] args) throws Exception{
        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .publish()
                .autoConnect(2);

        src.subscribe(i -> System.out.println("A: " + i));
        //src.subscribe(i -> System.out.println("B: "+i));
        Thread.sleep(5000);

        src.subscribe(i -> System.out.println("C: "+i));
        Thread.sleep(3000);
    }
}
