package observable.debugging;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class DoOnComplete {
    public static void main(String[] args) throws Exception{
        Disposable dp = Observable.interval(1, TimeUnit.SECONDS)
                .doOnComplete(() -> System.out.println("완료!"))
                .subscribe(System.out::println);

        Thread.sleep(5000);
        dp.dispose();
    }
}
