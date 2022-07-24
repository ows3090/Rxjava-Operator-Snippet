package observable.create;

import io.reactivex.rxjava3.core.Observable;

public class Just {
    public static void main(String[] args) {
        Observable source = Observable.just("Hello", "World");
        source.subscribe(System.out::println);
    }
}
