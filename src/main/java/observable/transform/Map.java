package observable.transform;

import io.reactivex.rxjava3.core.Observable;

public class Map {
    public static void main(String[] args) {
        Observable<Integer> intSrc = Observable.just(1,2,3);
        Observable<Integer> strSrc = intSrc.map(value -> value*10);
        strSrc.subscribe(System.out::println);
    }
}
