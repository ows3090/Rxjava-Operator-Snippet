package observable.create;

import io.reactivex.rxjava3.core.Observable;

public class Range {
    public static void main(String[] args) {
        Observable.range(1,3)
                .subscribe(System.out::println);
    }
}
