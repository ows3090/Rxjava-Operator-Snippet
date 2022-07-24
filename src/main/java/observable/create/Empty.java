package observable.create;

import io.reactivex.rxjava3.core.Observable;

public class Empty {
    public static void main(String[] args) {
        Observable.empty()
                .doOnTerminate(() -> System.out.println("empty 종료"))
                .subscribe(System.out::println);
    }
}
