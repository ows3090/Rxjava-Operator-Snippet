package subject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

public class PublishObserver {
    public static void main(String[] args) throws Exception{
        Observable src1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable src2 = Observable.interval(500, TimeUnit.MILLISECONDS);
        PublishSubject subject = PublishSubject.create();

        src1.map(item -> "A: "+item).subscribe(subject);
        src2.map(item -> "B: "+item).subscribe(subject);
        subject.subscribe(System.out::println);
        Thread.sleep(5000);
    }
}
