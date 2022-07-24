package observable.debugging;

import io.reactivex.rxjava3.core.Observable;

public class DoOnError {
    public static void main(String[] args) {
        Observable.just(2, 1, 0)
                .map(i -> 10 / i)
                .doOnError(throwable -> System.out.println("오류!!"))
                .subscribe(System.out::println, t -> t.printStackTrace());
    }
}
