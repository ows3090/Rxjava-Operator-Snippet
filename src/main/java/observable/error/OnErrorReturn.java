package observable.error;

import io.reactivex.rxjava3.core.Observable;

public class OnErrorReturn {
    public static void main(String[] args) {
        Observable.just("1","2","a","3")
                .map(i -> Integer.parseInt(i))
                .onErrorReturn(throwable -> -1)
                .subscribe(System.out::println);
    }
}
