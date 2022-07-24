package observable.filter;

import io.reactivex.rxjava3.core.Observable;

public class All {
    public static void main(String[] args) {
        Observable.just(2,1)
                .all(integer -> integer > 0)
                .subscribe(System.out::println);

        Observable.just(2,1,0)
                .all(integer -> integer > 0)
                .subscribe(System.out::println);
    }
}
