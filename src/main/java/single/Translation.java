package single;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.List;

public class Translation {
    public static void main(String[] args) {
        Observable<Integer> src = Observable.just(1,2,3);

        Single<Boolean> singleSrc1 = src.all(i -> i > 0);
        Single<Integer> singleSrc2 = src.first(-1);
        Single<List<Integer>> singleSrc3 = src.toList();

        Single<String> singleSrc = Single.just("Hello World");
        Observable<String> observableSrc = singleSrc.toObservable();
    }
}
