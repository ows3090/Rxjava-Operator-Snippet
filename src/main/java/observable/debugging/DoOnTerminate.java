package observable.debugging;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class DoOnTerminate {
    public static void main(String[] args) throws Exception {
        Disposable dp = Observable.interval(1, TimeUnit.SECONDS)
                .doOnTerminate(() -> System.out.println("완료!"))
                .subscribe(System.out::println);

        Thread.sleep(5000);
        dp.dispose();

        Observable.just(2, 1, 0)
                .map(i -> 10 / i)
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .subscribe(System.out::println, t -> t.printStackTrace());
    }
}
