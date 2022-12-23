package com.practice.multithreading;

public class ThreadStates {

    /*
                 Thread t1 = new Thread();
                        NEW
                         |
                         |
                         |  t1.start()
                         |
                         |
                         |    time completed / notify()/ resume()
            |----- >  RUNNABLE <------------------------------------------------|
            |            |                                                      |
            |            |                                                      |
      YIELD |            |   run()                                           BLOCKED
            |            |                                                      ^
            |            |                                                      |
            |-----     RUNNING  ------------------------------------------------|
                         |    sleep()/wait()/suspend()/join()
                         |
                         |
                         |   stop()
                         |  execution completed
                         |
                        DEAD



 BLOCKED
Java doc formally defines BLOCKED state as: “A thread that is blocked waiting for a monitor lock is in this state.”

Real-life example: Today you are going for a job interview. This is your dream job, which you have been targeting for last few years. You woke up early in the morning, got ready, put on your best outfit, looking sharp in front of the mirror. Now you step out to your garage and realize that your wife has already taken the car. In this scenario, you only have one car, so what will happen? In real life, a fight may happen :-). Here you are BLOCKED because your wife has already taken the car. You won't be able to go to the interview.

This is the BLOCKED state. Explaining it in technical terms, you are the thread T1 and your wife is the thread T2 and lock is the car. T1 is BLOCKED on the lock (i.e. the car), because T2 has already acquired this lock.

Titbit: A Thread will enter in to BLOCKED state when it’s waiting for a monitor lock to enter a synchronized block/method or reenter a synchronized block/method after calling Object#wait() method.



WAITING
Java doc formally defines WAITING state as: “A thread that is waiting indefinitely for another thread to perform a particular action is in this state.”

Real-life example: Let’s say few minutes later your wife comes back home with the car. Now you realize that the interview time is approaching, and there is a long distance to drive to get there. So, you put all the power on the gas pedal in the car. You drive at 100 mph when the allowed speed limit is only 60 mph. Your luck, a traffic cop sees you driving over the speed limit, and he pulls you over to the curb. Now you are entering into the WAITING state, my friend. You stop driving the car and sit idly in the car until the cop investigates you, and then lets you go. Basically, until he lets you go, you are stuck in the WAITING state.

Explaining it in technical terms, you are thread T1 and the cop is thread T2. You released your lock (i.e. you stopped driving the car), and went into the WAITING state. Until the cop (i.e. T2) lets you go, you will be stuck in this WAITING state.

Titbit: A Thread will enter in to WAITING state when it’s calling one of the following methods:



Object#wait() with no timeout

Thread#join() with no timeout

LockSupport#park()



Thread that has called Object.wait() on an object is in WAITING state until another thread to call Object.notify() or Object.notifyAll() on that object. A thread that has called Thread.join() is in WAITING state for a specified thread to terminate.



TIMED_WAITING
Java doc formally defines TIMED_WAITING state as: “A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.”

Real-life example:  Despite all the drama, you did extremely well in the interview, impressed everyone and got this high paying job. (Congratulations!) You come back home and tell to your neighbor about this new job and how excited you are about it. Your friend says that he is also working in the same office building. He suggests that the two of you should drive together. You think it’s a great idea. So on the first day of work, you go to his house. You stop your car in front of his house. You wait for 10 minutes, but your neighbor still doesn’t come out. You go ahead and start driving to work, as you don’t want to be delayed on your first day.  Now this is TIMED_WAITING.

Explaining it in technical terms, you are thread T1 and your neighbor is thread T2. You release lock (i.e. stop driving the car) and wait up to 10 minutes. If your neighbor, T2, doesn’t come out in 10 minutes, you start driving the car again.

Titbit: A Thread will enter in to TIMED_WAITING state when it’s calling one of the following methods:



Thread#sleep()

Object#wait() with timeout

Thread#join() with timeout

LockSupport#parkNanos()

LockSupport#parkUntil()

     */
}
