README ICSHomework6

This project creates a circular array queue and a simulated store with "shoppers" to test the queue functions.

There are two types of queues in the CheckoutLanes class, the first is an expressQueue which simulates an 
express line at a store, where the customer is only allowed to be in the line if the customer has less than a
certain amount of items. In this case the item limit is 10. The second type of queue is a regularQueue which 
is a simulation of a regular line at a store in which the customer may have as many items as they want. If a 
shopper in the expressQueue tries to check out with more than 10 items, that shopper gets sent to the end of 
the shortest regularQueue.

To test the functionality of the CircularArrayQueue and that of the CheckoutLanes classes, Paul provided us
a JUnit test file for each.

The test file for the CircularArrayQueue was partially completed. What was left undone was well commented to
give us a good idea of what the test method should test for. For each unfinished test method, I filled in 
code that tested what the method described.

The test file for the CheckoutLanes class only ensured that it ran and completed. Other than that we
were expected to test it ourselves. To do this I created multiple multiple express and regular lines and
filled them with shoppers that had varied numbers of items. This tested that the print functions were
working correctly, along with the functions of the CircularArrayClass. It also tested that the shoppers in 
the express lane with more than one item were moved to the shortest regularQueue when they reached the front
of the queue. 
