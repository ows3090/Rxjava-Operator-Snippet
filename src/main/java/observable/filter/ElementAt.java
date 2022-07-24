package observable.filter;

import io.reactivex.rxjava3.core.Observable;

public class ElementAt {
    public static void main(String[] args) {
        Observable.just(1,2,3,4)
                .elementAt(2)
                .subscribe(System.out::println);
    }
}
