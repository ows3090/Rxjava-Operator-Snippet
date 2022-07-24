package subject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;


public class Unicastsubject {
    public static void main(String[] args) throws Exception{
        Subject<Long> subject = UnicastSubject.create();
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(subject);

        Thread.sleep(3000);
        subject.subscribe(i -> System.out.println("A: "+i));
        Thread.sleep(2000);

    }
}
