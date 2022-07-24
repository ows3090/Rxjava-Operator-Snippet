package observable.debugging;

import io.reactivex.rxjava3.core.Observable;

public class DoOnNext {
    public static void main(String[] args) {
        Observable.just(1, 2, 3)
                .doOnNext(item -> {
                    if (item > 1) {
                        throw new IllegalArgumentException();
                    }
                })
                .subscribe(System.out::println,
                        throwable -> throwable.printStackTrace());
    }
}
