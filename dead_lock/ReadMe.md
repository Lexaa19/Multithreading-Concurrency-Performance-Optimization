Some deadlock overview
The deadock appears in one of the scenarios:
<ul>
    <li>Mutual exclusion - Only one thread can have exclusive acces to a resource</li>
    <li>Hold and wait - At least one thread is holding a resource and is waiting for another resource</li>
    <li>Circular wait - A chain of at least two threads each one is holding one resource and is waiting for another resource</li>
 </ul>
The deadlock is achieved inside the synchronized blocks that hold the locks roadA and roadB.
A possible solution in this case is acquiring the order of the lock acquire, that is:

