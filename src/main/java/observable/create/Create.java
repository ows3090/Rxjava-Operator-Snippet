package observable;

import io.reactivex.rxjava3.core.Observable;

public class Create {
    public static void main(String[] args) {
        Observable source = Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("World");
            emitter.onError(new Throwable());
            emitter.onComplete();
        });

        source.subscribe(System.out::println, throwable -> System.out.println("Error"));
    }
}
