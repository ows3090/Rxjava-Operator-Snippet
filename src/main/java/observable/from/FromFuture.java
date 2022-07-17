package observable.from;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.Future;


public class FromFuture {
    public static void main(String[] args) {
        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(5000);
            return "Hello World";
        });

        Observable source = Observable.fromFuture(future);
        source.subscribe(System.out::println);
    }
}
