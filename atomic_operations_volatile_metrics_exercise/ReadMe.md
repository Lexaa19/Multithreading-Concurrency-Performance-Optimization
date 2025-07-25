<h1>Min - Max Metrics Exercise Statement</h1>

In this exercise, we are going to implement a class called MinMaxMetrics.

A single instance of this class will be passed to multiple threads in our application.

MinMaxMetrics is an analytics class and is used to keep track of the minimum and the maximum of a particular business or performance metric in our application.

<b>Example:</b>

A stock trading application that keeps track of the minimum and maximum price of the stock on a daily basis.


<b>The class will have 3 methods:</b>

addSample(..) - Takes a new sample.

getMin() - Returns the sample with the minimum value we have seen so far. 

getMax() - Returns the sample with the maximum value we have seen so far.



<b>Notes:</b>

- Each method can be called concurrently by any given number of threads, so the class needs to be thread-safe.

- In addition, this class is used for analytics, so it needs to be as performant as possible, as we don't want it to slow down our business logic threads too much.

- Threads that call getMin() or getMax() are interested in only one of the values and are never interested in both the min and the max at the same time
