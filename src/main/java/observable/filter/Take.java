package observable.filter;

import io.reactivex.rxjava3.core.Observable;

public class Take {
    public static void main(String[] args) {
        Observable.just(1,2,3,4)
                .take(2)
                .subscribe(System.out::println);
    }
}
