package observable.filter;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Amb {
    public static void main(String[] args) {
        ArrayList<Observable<Integer>> list = new ArrayList();
        list.add(Observable.just(20,40,60).delay(100, TimeUnit.MILLISECONDS));
        list.add(Observable.just(1,2,3));
        list.add(Observable.just(0,0,0).delay(200, TimeUnit.MILLISECONDS));

        Observable.amb(list).subscribe(System.out::println);
    }
}
