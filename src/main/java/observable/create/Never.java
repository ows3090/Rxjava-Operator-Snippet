package observable.create;

import io.reactivex.rxjava3.core.Observable;

public class Never {
    public static void main(String[] args) {
        Observable.never()
                .doOnTerminate(() -> System.out.println("never 종료"))
                .subscribe(System.out::println);
    }
}
