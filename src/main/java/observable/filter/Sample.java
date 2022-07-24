package observable.filter;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) throws Exception{
        Observable.interval(100, TimeUnit.MILLISECONDS)
                .sample(300, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        Thread.sleep(1000);
    }
}
