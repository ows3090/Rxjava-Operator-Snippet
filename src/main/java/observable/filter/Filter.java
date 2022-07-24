package observable.filter;

import io.reactivex.rxjava3.core.Observable;

public class Filter {
    public static void main(String[] args) {
        Observable.just(2,30,22,5,60,1)
                .filter(x -> x>10)
                .subscribe(System.out::println, throwable -> throwable.printStackTrace());
    }
}
