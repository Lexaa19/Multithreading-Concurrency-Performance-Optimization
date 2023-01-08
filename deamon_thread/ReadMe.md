Daemon Threads are considered as secondary threads. That means, JRE doesn’t wait for the completion of a daemon thread. If the execution of all non-daemon threads gets over, JRE will terminate the program without bothering about the completion of the daemon thread.

By default, all threads are non-daemon, we can set any thread as daemon before starting it.
