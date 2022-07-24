package observable.filter;

import io.reactivex.rxjava3.core.Observable;

public class Distinct {
    public static void main(String[] args) {
        Observable.just(1,2,2,1,3)
                .distinct()
                .subscribe(System.out::println);
    }
}
