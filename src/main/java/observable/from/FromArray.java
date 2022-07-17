package observable.from;

import io.reactivex.rxjava3.core.Observable;

public class FromArray {
    public static void main(String[] args) {
        String[] itemArray = new String[]{"A","B","C"};
        Observable source = Observable.fromArray(itemArray);
        source.subscribe(System.out::println);
    }
}
