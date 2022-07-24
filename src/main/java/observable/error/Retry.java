package observable.error;

import io.reactivex.rxjava3.core.Observable;

public class Retry {
    public static void main(String[] args) {
        Observable.just("1", "2", "a", "3")
                .map(i -> Integer.parseInt(i))
                .retry(2)
                .subscribe(System.out::println,
                        throwable -> throwable.printStackTrace());
    }
}
