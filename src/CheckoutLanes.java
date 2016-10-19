public class CheckoutLanes {
  CircularArrayQueue<Shopper>[] expressQueues;
  CircularArrayQueue<Shopper>[] regularQueues;

  public CheckoutLanes(int numExpress, int numRegular) {
    if(numRegular < 1){
      throw new IllegalStateException();
    }
    else{
      expressQueues = new CircularArrayQueue[numExpress];
      regularQueues = new CircularArrayQueue[numRegular];
    }
  }


  public void enterLane(int laneNumber, Shopper shopper) {
    if(laneNumber < expressQueues.length){
      expressQueues[laneNumber].add(shopper);
    }
    else{
      regularQueues[laneNumber - expressQueues.length].add(shopper);
    }
  }

  public void simulateCheckout() {
    while(shoppersPresent()){
      for(int i = 0; i < expressQueues.length; i ++){
        if( ((Shopper)expressQueues[i].peek()).getNumItems() > 10){
          // TODO random generator to pick which queue to move to
        }
      }
    }
  }
  
  private boolean shoppersPresent(){
    for(int i = 0; i < expressQueues.length; i ++){
      if(expressQueues[i].size() > 0){
        return true;
      }
    }
    for(int i = 0; i < regularQueues.length; i ++){
      if(regularQueues[i].size() > 0){
        return true;
      }
    }
    return false;
  }
}