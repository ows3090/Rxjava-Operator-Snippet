package observable.debugging;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class DoOnDispose {
    public static void main(String[] args) throws Exception{
        Observable src = Observable.interval(500, TimeUnit.MILLISECONDS)
                .doOnDispose(() -> System.out.println("doOnDispose"));

        Disposable disposable = src.subscribe(System.out::println);
        Thread.sleep(1100);
        disposable.dispose();
    }
}
