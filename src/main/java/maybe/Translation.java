package maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.List;

public class Translation {
    public static void main(String[] args) {
        Observable<Integer> src1 = Observable.just(1,2,3);
        Maybe<Integer> srcMaybe1 = src1.firstElement();
        srcMaybe1.subscribe(System.out::println);

        Observable<Integer> src2 = Observable.empty();
        Maybe<Integer> srcMaybe2 = src2.firstElement();
        srcMaybe2.subscribe(System.out::println, throwable -> {},
                () -> System.out.println("onComplete!"));
    }
}
