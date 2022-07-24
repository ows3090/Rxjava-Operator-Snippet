package observable.transform;

import io.reactivex.rxjava3.core.Observable;

public class Buffer {
    public static void main(String[] args) {
        Observable.range(0,10)
                .buffer(3)
                .subscribe(integers -> {
                    System.out.println("버퍼 데이터 발행");
                    for(Integer integer : integers){
                        System.out.println("#" + integer);
                    }
                });
    }
}
