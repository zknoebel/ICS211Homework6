README ICSHomework6

This project creates a circular array queue and a simulated store with "shoppers" to test the queue functions.

There are two types of queues, the first is an expressQueue which simulates an express line at a store, where
the customer is only allowed to be in the line if the customer has less than a certain amount of items. In 
this case the item limit is 10. The second type of queue is a regularQueue which is a simulation of a regular
line at a store in which the customer may have as many items as they want.
If a shopper in the express line tries to check out with more than 10 items, that shopper gets sent to the 
shortest regularQueue.

To test the functionality of the CircularArrayQueue and that of the CheckoutLanes classes, Paul provided us
with two JUnit test files, one for each.

The test file for the CircularArrayQueue was partially completed. What was left undone was ...

The test file for the CheckoutLanes class was just to make sure that
it ran and completed. Other than that we were expected to test it ourselves. 
