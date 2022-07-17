package single;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Just {
    public static void main(String[] args) {
        Single.just("Hello World")
                .subscribe(System.out::println);
    }
}
