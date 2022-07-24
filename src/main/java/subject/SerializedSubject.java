package subject;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

import java.util.concurrent.atomic.AtomicInteger;

public class SerializedSubject {
    public static void main(String[] args) throws Exception{
        AtomicInteger counter = new AtomicInteger();
        Subject<Object> subject = PublishSubject.create().toSerialized();
        subject.doOnNext(i -> counter.incrementAndGet())
                .doOnNext(i -> counter.decrementAndGet())
                .filter(i -> counter.get() != 0)
                .subscribe(System.out::println, throwable -> throwable.printStackTrace());

        Runnable runnable = () -> {
            for(int i=0;i<100000;i++){
                try{
                    Thread.sleep(1);
                }catch (Throwable throwable){
                    throwable.printStackTrace();
                }
                subject.onNext(i);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        Thread.sleep(1000);
        System.out.println("종료");
    }
}
