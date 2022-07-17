package observable.from;

import io.reactivex.rxjava3.core.Observable;
import org.reactivestreams.Publisher;


public class FromPublisher {
    public static void main(String[] args) {
        Publisher<String> publisher = subscriber -> {
            subscriber.onNext("A");
            subscriber.onNext("B");
            subscriber.onNext("C");
            subscriber.onComplete();
        };

        Observable<String> source = Observable.fromPublisher(publisher);
        source.subscribe(System.out::println);
    }
}
