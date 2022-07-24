package observable.transform;

import io.reactivex.rxjava3.core.Observable;

public class FlatMap {
    public static void main(String[] args) {
        Observable<String> src = Observable.just("a","b","c");
        src.flatMap(str -> Observable.just(str + 1, str + 2))
                .subscribe(System.out::println);

        Observable.range(2,8)
                .flatMap(x -> Observable.range(1,9)
                        .map(y -> String.format("%d*%d=%d", x, y, x*y)))
                .subscribe(System.out::println);
    }
}
