package observable.dispose;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class CompositeDispose {
    public static void main(String[] args) throws Exception{
        Observable source = Observable.interval(1000, TimeUnit.MILLISECONDS);

        Disposable d1 = source.subscribe(System.out::println);
        Disposable d2 = source.subscribe(System.out::println);
        Disposable d3 = source.subscribe(System.out::println);

        CompositeDisposable cd = new CompositeDisposable();
        cd.add(d1);
        cd.add(d2);
        cd.add(d3);

        cd.addAll(d1,d2, d3);
        Thread.sleep(5000);
        cd.dispose();
    }
}
