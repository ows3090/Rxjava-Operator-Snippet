package observable.from;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;

public class FromIterable {
    public static void main(String[] args) {
        ArrayList itemList = new ArrayList();
        itemList.add("A");
        itemList.add("B");
        itemList.add("C");

        Observable source = Observable.fromIterable(itemList);
        source.subscribe(System.out::println);
    }
}
