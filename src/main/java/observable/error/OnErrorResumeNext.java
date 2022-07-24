package observable.error;

import io.reactivex.rxjava3.core.Observable;

public class OnErrorResumeNext {
    public static void main(String[] args) {
        Observable.just("1", "2", "a", "3")
                .map(i -> Integer.parseInt(i))
                .onErrorResumeNext(throwable ->
                        Observable.just(100, 200, 300))
                .subscribe(System.out::println);
    }
}
