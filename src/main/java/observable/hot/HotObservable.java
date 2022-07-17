package observable.hot;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.TimeUnit;

public class HotObservable {
    public static void main(String[] args) throws Exception {
        ConnectableObservable src = Observable.interval(1, TimeUnit.SECONDS).publish();
        src.connect();
        src.subscribe(value -> System.out.println("#1: " +value));
        Thread.sleep(3000);
        src.subscribe(value -> System.out.println("#2: "+value));
        Thread.sleep(3000);
    }
}
