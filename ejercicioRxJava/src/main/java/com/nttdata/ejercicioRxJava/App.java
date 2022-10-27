package com.nttdata.ejercicioRxJava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Prueba RxJava
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Observable<String> messageSender = Observable.just("Mensaje1", "Mensaje2", "Mensaje3");
        
        messageSender.subscribe(new Observer() {

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Observer1. Subscribed.");
			}

			@Override
			public void onNext(Object t) {
				System.out.println("Observer1. Received " + t + ".");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Observer1. Error: " + e.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("Observer1.");
			}
        });
        
        messageSender.subscribe(new Observer() {

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Observer2. Subscribed.");
			}

			@Override
			public void onNext(Object t) {
				System.out.println("Observer2. Received " + t + ".");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Observer2. Error: " + e.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("Observer2.");
			}
        });
    }
}
