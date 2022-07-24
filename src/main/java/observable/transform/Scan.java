package observable.transform;

import io.reactivex.rxjava3.core.Observable;

public class Scan {
    public static void main(String[] args) {
        Observable.range(1,5)
                .scan((x,y) -> {
                    System.out.print(String.format("%d+%d=",x,y));
                    return x+y;
                })
                .subscribe(System.out::println);


        Observable.just("a","b","c","d","e")
                .scan((x,y) -> x + y)
                .subscribe(System.out::println);
    }
}
