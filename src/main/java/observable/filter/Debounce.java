package observable.filter;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Debounce {
    public static void main(String[] args) throws Exception{
        Observable.create(emitter -> {
            emitter.onNext("1");
            Thread.sleep(100);
            emitter.onNext("2");
            emitter.onNext("3");
            emitter.onNext("4");
            emitter.onNext("5");
            Thread.sleep(100);
            emitter.onNext("6");
        })
                .debounce(10, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        Thread.sleep(300);
    }
}
