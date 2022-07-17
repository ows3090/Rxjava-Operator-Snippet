package observable.from;

import io.reactivex.rxjava3.core.Observable;
import org.reactivestreams.Publisher;

import java.util.concurrent.Callable;


public class FromCallable {
    public static void main(String[] args) {
        Callable<String> callable = () -> "Hello World";
        Observable source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }
}
