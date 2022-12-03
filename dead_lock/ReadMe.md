<h1>Some deadlock overview</h1>
The deadock appears in one of the scenarios:
<ul>
    <li>Mutual exclusion - Only one thread can have exclusive acces to a resource</li>
    <li>Hold and wait - At least one thread is holding a resource and is waiting for another resource</li>
    <li>Circular wait - A chain of at least two threads each one is holding one resource and is waiting for another resource</li>
 </ul>
The deadlock is achieved inside the synchronized blocks that hold the locks roadA and roadB.</br>
A possible solution in this case is acquiring the order of the lock acquire, that is:


```
 public void takeRoadA() {
            synchronized (roadA) {
                System.out.println("Road A is locked by thread " + Thread.currentThread().getName());
                synchronized (roadB) {
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

  public void takeRoadB() {
            synchronized (roadA) {
                System.out.println("Road B is locked by thread " + Thread.currentThread().getName());
                synchronized (roadB) {
                    System.out.println("Train is passing through road B");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
 ```             
instead of

```
 public void takeRoadA() {
            synchronized (roadA) {
                System.out.println("Road A is locked by thread " + Thread.currentThread().getName());
                synchronized (roadB) {
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

  public void takeRoadB() {
            synchronized (roadB) {
                System.out.println("Road B is locked by thread " + Thread.currentThread().getName());
                synchronized (roadA) {
                    System.out.println("Train is passing through road B");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
 ```
      
